package graphs;

import java.util.*;

public class WordLadderII {

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList(new String[] {"hot","dot","dog","lot","log","cog"});
        WordLadderII w = new WordLadderII();
        w.findLadders("hit", "cog", wordList);
    }

    int len;
    Map<String, List<String>> allCombo = new HashMap<>();
    boolean isConnected = false;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        len = beginWord.length();
        if (len == 0)
            return result;
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.remove(endWord))
            return result;

        wordList.forEach((word -> {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i+1, len);
                List<String> list = allCombo.getOrDefault(newWord, new ArrayList<>());
                list.add(word);
                allCombo.put(newWord, list);
            }
        }));

        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);

        Map<String, List<String>> map = new HashMap<>();
        bfs(begin, end, dict, map, false);

        List<String> list = new ArrayList<String>();
        list.add(beginWord);

        dfs(beginWord, endWord, map, list, result);

        return result;
    }

    private void dfs(String beginWord, String endWord, Map<String, List<String>> map,
                     List<String> list, List<List<String>> result) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<String>(list));
            return;
        }

        if (!map.containsKey(beginWord))
            return;

        for (String str : map.get(beginWord)) {
            list.add(str);
            dfs(str, endWord, map, list, result);
            list.remove(list.size()-1);
        }
    }

    private void bfs(Set<String> begin, Set<String> end, Set<String> dict,
                     Map<String, List<String>> map, boolean swap) {
        if (begin.isEmpty() || end.isEmpty())
            return;
        if (begin.size() > end.size()) {
            bfs(end, begin, dict, map, !swap);
            return;
        }
        dict.removeAll(begin);
        dict.removeAll(end);

        Set<String> set = new HashSet<String>();

        for(String str : begin){
            for(int i = 0; i < str.length(); i++){
                String newWord = str.substring(0, i) + "*" + str.substring(i+1, len);
                for (String temp : allCombo.getOrDefault(newWord, new ArrayList<>())) {
                    if(!end.contains(temp) && !dict.contains(temp)){
                        continue;
                    }

                    String key = !swap? str : temp;
                    String val = !swap? temp : str;
                    if(!map.containsKey(key))
                        map.put(key, new ArrayList<String>());

                    if(end.contains(temp)){
                        map.get(key).add(val);
                        isConnected = true;
                    }

                    if(!isConnected && dict.contains(temp)){
                        map.get(key).add(val);
                        set.add(temp);
                    }
                }
            }
        }

        if(!isConnected){
            bfs(set, end, dict, map, swap);
        }

    }

}

package strings;

import java.util.*;

public class WorkBreak {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        wordBreak("leetcode", list);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean segmented = false;
        int len = s.length();
        if (len == 0 || wordDict.size() == 0) {
            return segmented;
        }
        String subString;
        int[] pos = new int[s.length()+1];
        Arrays.fill(pos, -1);
        pos[0]=0;
        for (int i=0; i < len; i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=s.length(); j++){
                    subString = s.substring(i, j);
                    if(wordDict.contains(subString)){
                        pos[j]=i;
                    }
                }
            }
        }

        return pos[s.length()] != -1;
    }
}

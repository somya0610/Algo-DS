package recursion;

import java.util.*;

public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0 || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        dfs(candidates, target, 0, path, result);
        return result;
    }

    public static void dfs(int[] candidates, int target, int index, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            List<Integer> p = new ArrayList<>();
            for (int i : path) {
                p.add(i);
            }
            result.add(p);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target)
                return;
            if (i == index || candidates[i] != candidates[i-1]) {
                path.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}

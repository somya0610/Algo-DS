package graphs;

import java.util.*;

public class CutOffTrees {

    public static void main(String[] args) {
        CutOffTrees c = new CutOffTrees();
        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(new Integer[]{1,2,3});
        List<Integer> list2 = Arrays.asList(new Integer[]{0,0,4});
        List<Integer> list3 = Arrays.asList(new Integer[]{7,6,5});
        forest.add(list1);
        forest.add(list2);
        forest.add(list3);
        c.cutOffTree(forest);
    }

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.isEmpty()) {
            return 0;
        }

        int m = forest.size();
        int n = forest.get(0).size();

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1)
                    pq.add(new int[]{i, j, forest.get(i).get(j)});
            }
        }

        int[] start = new int[]{0, 0, forest.get(0).get(0)};
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            int steps = bfs(start, next, forest);
            if (steps == -1) {
                return -1;
            }
            sum += steps;
            start = next;
        }
        return sum;
    }

    private int bfs(int[] start, int[] next, List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();
        boolean visited[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] < 0 || curr[0] >= m || curr[1] < 0 || curr[1] >= n
                    || forest.get(curr[0]).get(curr[1]) == 0 || visited[curr[0]][curr[1]])
                continue;

            visited[curr[0]][curr[1]] = true;
            if (curr[0] == next[0] && curr[1] == next[1])
                return curr[2];

            q.add(new int[]{curr[0], curr[1] + 1, curr[2] + 1});
            q.add(new int[]{curr[0], curr[1] - 1, curr[2] + 1});
            q.add(new int[]{curr[0] + 1, curr[1], curr[2] + 1});
            q.add(new int[]{curr[0] - 1, curr[1], curr[2] + 1});
        }
        return -1;
    }

}

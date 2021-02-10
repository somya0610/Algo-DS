package graphs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MachineMatrix {

    // Complete the minTime function below.
    static int minTime(int[][] roads, int[] machines) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            List<List<Integer>> lists1 = map.getOrDefault(roads[i][0], new ArrayList<>());
            List<Integer> list1 = new ArrayList<>();
            list1.add(roads[i][1]);
            list1.add(roads[i][2]);
            lists1.add(list1);
            map.put(roads[i][0], lists1);

            List<List<Integer>> lists2 = map.getOrDefault(roads[i][1], new ArrayList<>());
            List<Integer> list2 = new ArrayList<>();
            list2.add(roads[i][0]);
            list2.add(roads[i][2]);
            lists2.add(list2);
            map.put(roads[i][1], lists2);
        }

        boolean[] visited = new boolean[roads.length+1];
        boolean[] isMachine = new boolean[roads.length+1];
        for (int  i = 0; i < machines.length; i++) {
            isMachine[machines[i]] = true;
        }
        int totalTime = 0;

        for (int i = 0; i < machines.length; i++) {
            List<List<Integer>> edges = map.get(machines[i]);

                visited[machines[i]] = true;
                int min = Integer.MAX_VALUE;
                int edgeToRemove = -1;
                boolean machineConnected = false;
                for (List<Integer> edge : edges) {
                    if (isMachine[edge.get(0)] && !visited[edge.get(0)]) {
                        totalTime += edge.get(1);
                        machineConnected = true;
                        visited[edge.get(0)] = true;
                    } else if (!isMachine[edge.get(0)] && !machineConnected && !visited[edge.get(0)]) {
                        if (min > edge.get(1)) {
                            min = edge.get(1);
                            edgeToRemove = edge.get(0);
                        }
                    }
                }
                if (edgeToRemove != -1 && !machineConnected) {
                    visited[edgeToRemove] = true;
                    totalTime += min;
                }
        }

        return totalTime;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] roads = new int[n - 1][3];

        for (int i = 0; i < n - 1; i++) {
            String[] roadsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int roadsItem = Integer.parseInt(roadsRowItems[j]);
                roads[i][j] = roadsItem;
            }
        }

        int[] machines = new int[k];

        for (int i = 0; i < k; i++) {
            int machinesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            machines[i] = machinesItem;
        }

        int result = minTime(roads, machines);

        scanner.close();
    }
}

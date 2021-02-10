package graphs;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ShortestReachToEachPoint {
    public static class Graph {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] distance;

        public Graph(int size) {
            distance = new int[size];
            Arrays.fill(distance, -1);
            while (--size >= 0) {
                map.put(size, new ArrayList<>());
            }
        }

        public void addEdge(int first, int second) {
            if (first != second) {
                map.get(first).add(second);
                map.get(second).add(first);
            }
        }

        public int[] shortestReach(int startId) { // 0 indexed
            Queue<Integer> queue = new LinkedList<>();
            queue.add(startId);
            distance[startId] = 0;
            boolean[] visited = new boolean[distance.length];
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                visited[curr] = true;
                List<Integer> list = map.get(curr);
                for (int edge : list) {
                    if (!visited[edge]) {
                        queue.add(edge);
                        if (distance[edge] == -1) {
                            distance[edge] = distance[curr] + 6;
                        } else {
                            distance[edge] = Math.min(distance[edge], distance[curr] + 6);
                        }
                    }
                }
            }
            return distance;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}


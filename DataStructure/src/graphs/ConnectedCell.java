package graphs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ConnectedCell {

    // Complete the maxRegion function below.
    static int count;
    static int maxRegion(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for(int j =0; j < grid[i].length;j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    count = evaluateRegion(grid, i, j);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }

    private static int evaluateRegion(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        count++;
        grid[i][j] = 0;
        evaluateRegion(grid, i, j+1);
        evaluateRegion(grid, i, j-1);
        evaluateRegion(grid, i+1, j);
        evaluateRegion(grid, i-1, j);
        evaluateRegion(grid, i+1, j+1);
        evaluateRegion(grid, i-1, j-1);
        evaluateRegion(grid, i-1, j+1);
        evaluateRegion(grid, i+1, j-1);
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        int res = maxRegion(grid);

        scanner.close();
    }
}


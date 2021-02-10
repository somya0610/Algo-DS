package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloodFill {

    public static void main(String[] args) {
        FloodFill f = new FloodFill();
        int[][] image = new int[][] {{0,0,0}, {0,1,1}};
        f.floodFill(image, 1, 1, 1);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        bfs(image, sr, sc, newColor, image[sr][sc], visited);
        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int newColor, int originalColor, boolean[][] visited) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length
                || image[sr][sc] != originalColor || visited[sr][sc])
            return;
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        bfs(image, sr, sc+1, newColor, originalColor, visited);
        bfs(image, sr, sc-1, newColor, originalColor, visited);
        bfs(image, sr+1, sc, newColor, originalColor, visited);
        bfs(image, sr-1, sc, newColor, originalColor, visited);

    }
}

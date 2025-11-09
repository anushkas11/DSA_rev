import java.util.*;

class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length, count = 0;

        // mark all boundary-connected lands (not closed)
        for (int i = 0; i < n; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            dfs(grid, 0, j);
            dfs(grid, n - 1, j);
        }

        // count remaining closed islands
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1)
            return;
        grid[i][j] = 1;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}

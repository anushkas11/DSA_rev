import java.util.*;

class MinPathSum {
    int[][] dp;

    public int minPathSumMemo(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(grid, m - 1, n - 1);
    }

    int solve(int[][] g, int i, int j) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE / 2;
        if (i == 0 && j == 0) return g[0][0];
        if (dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = g[i][j] + Math.min(solve(g, i - 1, j), solve(g, i, j - 1));
    }

    public int minPathSumTab(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = g[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int up = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE / 2;
                int left = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE / 2;
                dp[i][j] = g[i][j] + Math.min(up, left);
            }
        }
        return dp[m - 1][n - 1];
    }
}

import java.util.*;

class UniquePaths2 {
    int[][] dp;

    public int uniquePathsWithObstaclesMemo(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(grid, m - 1, n - 1);
    }

    int solve(int[][] g, int i, int j) {
        if (i < 0 || j < 0 || g[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = solve(g, i - 1, j) + solve(g, i, j - 1);
    }

    public int uniquePathsWithObstaclesTab(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] dp = new int[m][n];
        if (g[0][0] == 1) return 0;
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1) dp[i][j] = 0;
                else if (i > 0 || j > 0) {
                    int up = i > 0 ? dp[i - 1][j] : 0;
                    int left = j > 0 ? dp[i][j - 1] : 0;
                    dp[i][j] += up + left;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

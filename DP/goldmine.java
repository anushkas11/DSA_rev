import java.util.*;

class GoldMine {
    int[][] dp;

    public int maxGoldMemo(int n, int m, int[][] M) {
        dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, solve(M, i, 0, n, m));
        return max;
    }

    int solve(int[][] M, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j >= m) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int right = solve(M, i, j + 1, n, m);
        int rightUp = solve(M, i - 1, j + 1, n, m);
        int rightDown = solve(M, i + 1, j + 1, n, m);
        return dp[i][j] = M[i][j] + Math.max(right, Math.max(rightUp, rightDown));
    }

    public int maxGoldTab(int n, int m, int[][] M) {
        int[][] dp = new int[n][m];
        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                int right = j == m - 1 ? 0 : dp[i][j + 1];
                int rightUp = (i == 0 || j == m - 1) ? 0 : dp[i - 1][j + 1];
                int rightDown = (i == n - 1 || j == m - 1) ? 0 : dp[i + 1][j + 1];
                dp[i][j] = M[i][j] + Math.max(right, Math.max(rightUp, rightDown));
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) max = Math.max(max, dp[i][0]);
        return max;
    }
}

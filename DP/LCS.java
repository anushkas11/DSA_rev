import java.util.*;

class LCS {
    // Recursive
    public int lcsRecursive(String s1, String s2) {
        return rec(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    int rec(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (s1.charAt(i) == s2.charAt(j)) return 1 + rec(s1, s2, i - 1, j - 1);
        return Math.max(rec(s1, s2, i - 1, j), rec(s1, s2, i, j - 1));
    }

    // Memoization
    int[][] dp;
    public int lcsMemo(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return memo(s1, s2, n - 1, m - 1);
    }

    int memo(String s1, String s2, int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + memo(s1, s2, i - 1, j - 1);
        return dp[i][j] = Math.max(memo(s1, s2, i - 1, j), memo(s1, s2, i, j - 1));
    }

    // Tabulation
    public int lcsTab(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
}

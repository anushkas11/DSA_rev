import java.util.*;

class Solution {
    int[] dp;
    public int numSquaresMemo(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return memo(n);
    }
    int memo(int n) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int ans = n;
        for (int i = 1; i * i <= n; i++)
            ans = Math.min(ans, 1 + memo(n - i * i));
        return dp[n] = ans;
    }

    public int numSquaresTab(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j * j <= i; j++)
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
        return dp[n];
    }
}

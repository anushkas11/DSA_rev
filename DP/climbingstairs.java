import java.util.*;

class Solution {
    int[] dp;
    public int climbStairsMemo(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return memo(n);
    }
    int memo(int n) {
        if (n <= 2) return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = memo(n - 1) + memo(n - 2);
    }

    public int climbStairsTab(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}

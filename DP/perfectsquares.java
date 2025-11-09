import java.util.*;

class Solution {
    int[] dp;
    public int[] countBitsMemo(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        for (int i = 0; i <= n; i++) memo(i);
        return dp;
    }
    int memo(int n) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        return dp[n] = 1 + memo(n & (n - 1));
    }

    public int[] countBitsTab(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++)
            dp[i] = dp[i >> 1] + (i & 1);
        return dp;
    }
}

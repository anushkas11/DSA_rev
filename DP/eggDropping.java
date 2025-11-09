import java.util.*;

class EggDroppingMemo {
    int[][] dp;

    public int eggDrop(int eggs, int floors) {
        dp = new int[eggs + 1][floors + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(eggs, floors);
    }

    int solve(int e, int f) {
        if (f == 0 || f == 1) return f;
        if (e == 1) return f;
        if (dp[e][f] != -1) return dp[e][f];

        int ans = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            int broken = solve(e - 1, k - 1);
            int notBroken = solve(e, f - k);
            ans = Math.min(ans, 1 + Math.max(broken, notBroken));
        }
        return dp[e][f] = ans;
    }
}

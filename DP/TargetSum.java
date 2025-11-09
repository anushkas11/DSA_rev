import java.util.*;

class TargetSum {
    int[][] dp;

    public int findTargetSumWaysMemo(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) sum += x;
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) return 0;
        int s1 = (sum + target) / 2;
        dp = new int[nums.length][s1 + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return countSubsets(nums, nums.length - 1, s1);
    }

    int countSubsets(int[] nums, int i, int sum) {
        if (i == 0) {
            if (sum == 0 && nums[0] == 0) return 2;
            if (sum == 0 || nums[0] == sum) return 1;
            return 0;
        }
        if (dp[i][sum] != -1) return dp[i][sum];
        int notTake = countSubsets(nums, i - 1, sum);
        int take = (nums[i] <= sum) ? countSubsets(nums, i - 1, sum - nums[i]) : 0;
        return dp[i][sum] = take + notTake;
    }

    public int findTargetSumWaysTab(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) sum += x;
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) return 0;
        int s1 = (sum + target) / 2;
        int n = nums.length;
        int[][] dp = new int[n][s1 + 1];

        if (nums[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if (nums[0] != 0 && nums[0] <= s1) dp[0][nums[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= s1; j++) {
                int notTake = dp[i - 1][j];
                int take = (nums[i] <= j) ? dp[i - 1][j - nums[i]] : 0;
                dp[i][j] = take + notTake;
            }
        }
        return dp[n - 1][s1];
    }
}

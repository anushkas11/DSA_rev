import java.util.*;

public class subsets {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};

        List<List<Integer>> result = sol.subsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] nums, int idx, List<Integer> curr, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(curr)); 
            return;
        }
        helper(nums, idx + 1, curr, result);
        curr.add(nums[idx]);
        helper(nums, idx + 1, curr, result);
        curr.remove(curr.size() - 1);
    }
}

import java.util.*;

public class permutations2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permuteUnique(nums);

        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private static void helper(int[] nums, List<Integer> curr, boolean[] flag, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!flag[i]) {
                if (i == 0 || nums[i] != nums[i - 1] || flag[i - 1]) {
                    flag[i] = true;
                    curr.add(nums[i]);
                    helper(nums, curr, flag, result);
                    curr.remove(curr.size() - 1);
                    flag[i] = false;
                }
            }
        }
    }
}

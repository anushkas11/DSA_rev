import java.util.*;

public class permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);

        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
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
                flag[i] = true;
                curr.add(nums[i]);
                helper(nums, curr, flag, result);
                curr.remove(curr.size() - 1);
                flag[i] = false;
            }
        }
    }
}

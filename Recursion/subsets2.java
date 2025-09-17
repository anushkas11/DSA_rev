import java.util.*;

public class subsets2 {
    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        List<List<Integer>> result = subsetsWithDup(nums);

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void helper(int[] nums, int idx, List<Integer> curr, List<List<Integer>> result) {
        if (idx == nums.length) {
            if (!result.contains(curr)) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }
        helper(nums, idx + 1, curr, result);
        curr.add(nums[idx]);
        helper(nums, idx + 1, curr, result);
        curr.remove(curr.size() - 1);
    }
}

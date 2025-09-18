import java.util.*;

public class combinationsum {
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result, new ArrayList<>(), target);
        return result;   
    }

    public static void helper(int[] nums, int idx, List<List<Integer>> result, List<Integer> curr, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0 || idx == nums.length) {
            return;
        }

        curr.add(nums[idx]);
        helper(nums, idx, result, curr, target - nums[idx]);
        curr.remove(curr.size() - 1);

        helper(nums, idx + 1, result, curr, target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        List<List<Integer>> result = combinationSum(nums, target);

        System.out.println(result);

        sc.close();
    }
}

import java.util.*;

public class combinationsum2 {
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, result, new ArrayList<>(), target);
        return result;   
    }

    public static void helper(int[] nums, int idx, List<List<Integer>> result, List<Integer> curr, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            if (nums[i] > target) break;
            curr.add(nums[i]);
            helper(nums, i + 1, result, curr, target - nums[i]);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        List<List<Integer>> result = combinationSum2(nums, target);
        System.out.println(result);

        sc.close();
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) map.put(n, true);
        for (int i = 0; i <= nums.length; i++) {
            if (!map.containsKey(i)) return i;
        }
        return -1;
    }
}

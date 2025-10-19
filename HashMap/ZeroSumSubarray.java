import java.util.HashMap;

class Solution {
    public int findSubarray(int[] arr) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : arr) {
            sum += num;
            if (map.containsKey(sum)) count += map.get(sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

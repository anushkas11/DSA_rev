import java.util.HashSet;

class LargestSubarray {
   public static  int maxLength(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < arr.length; right++) {
            while (set.contains(arr[right])) {
                set.remove(arr[left]);
                left++;
            }
            set.add(arr[right]);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

import java.util.*;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        long sum1 = 0, sum2 = 0;
        int chunks = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i];
            sum2 += sorted[i];
            if (sum1 == sum2) chunks++;
        }
        return chunks;
    }
}

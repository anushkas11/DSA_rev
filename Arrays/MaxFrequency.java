class Solution {
    public int maxFrequencyElements(int[] nums) {
        final int MAX = 100;
        int[] count = new int[MAX + 1];
        for (int num : nums) count[num]++;
        int maxFreq = 0;
        for (int f : count) if (f > maxFreq) maxFreq = f;
        int ans = 0;
        for (int f : count) if (f == maxFreq) ans += maxFreq;
        return ans;
    }
}

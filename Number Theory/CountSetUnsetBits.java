class Solution {
    public static int countSetBits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) count += Integer.bitCount(i);
        return count;
    }
}

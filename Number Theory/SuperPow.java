class Solution {
    private static final int MOD = 1337;
    
    public int superPow(int a, int[] b) {
        if (b.length == 0) return 1; 
        
        int lastDigit = b[b.length - 1];
        
   
        int[] remaining = new int[b.length - 1];
        System.arraycopy(b, 0, remaining, 0, b.length - 1);
        
       
        int part1 = modPow(superPow(a, remaining), 10);
        int part2 = modPow(a, lastDigit);              
        
        return (part1 * part2) % MOD;
    }
    private int modPow(int a, int k) {
        a %= MOD;
        int result = 1;
        for (int i = 0; i < k; i++) {
            result = (result * a) % MOD;
        }
        return result;
    }
}

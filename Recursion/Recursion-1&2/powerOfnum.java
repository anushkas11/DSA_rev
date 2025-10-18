class Solution {
    static final int MOD = 1000000007;

    private long reverse(long n) {
        long rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    private long power(long base, long exp) {
        long result = 1;
        base = base % MOD;  

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1; 
        }

        return result;
    }
    public int reverseExponentiation(int n) {
        long r = reverse(n);
        return (int) power(n, r);
    }
}
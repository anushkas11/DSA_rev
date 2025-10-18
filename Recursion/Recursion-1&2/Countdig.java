class Solution {
    static int evenlyDivides(int n) {
         if (n == 0)
            return 0;

        return 1 + evenlyDivides(n / 10);
        
    }
}
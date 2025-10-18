// User function Template for Java

class Solution {
    int arraySum(int arr[]) {
        return sum(arr,arr.length);
        
    }
    public static int sum(int[] arr, int n) {
       
        if (n == 0)
            return 0;

        return arr[n - 1] + sum(arr, n - 1);
    }
}

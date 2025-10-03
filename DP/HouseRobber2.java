class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int first=robcheck(nums,0,n-2);
        int last=robcheck(nums,1,n-1);
        return Math.max(first,last);
         
        
    }
    public int robcheck(int[] arr,int start,int end) {
        int n=end-start+1;
        int dp[]=new int[n];
        dp[0]=arr[start];
        if(n>1) dp[1]=Math.max(arr[start],arr[start+1]);
        else return dp[0];
        for(int i=2;i<n;i++){
            dp[i]=Math.max(arr[start+i]+dp[i-2],dp[i-1]);
        }
       return dp[n-1]; 
    }
}
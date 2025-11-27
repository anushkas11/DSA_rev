class MaxProductsub{
    public static void main(String[] args) {
        int nums[]={2,3,-2,4};
        System.out.println(check(nums));
     }
     private static int check(int[] nums){
        int pre=1,suff=1;
        int n=nums.length;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre=pre*nums[i];
            suff=suff*nums[n-i-1];
            ans=Math.max(ans,Math.max(pre,suff));
        }
        return ans;
     }
 }

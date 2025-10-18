class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int st=0,end=n-1;
        int ans=-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<nums[end]){
                if(target>nums[mid] && target<=nums[end]){
                    st=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            else{
                if(target>=nums[st] && target<nums[mid]){
                    end=mid-1;
                }
                else{
                    st=mid+1;
                }
            }
        }
        return ans;
        
    }
}
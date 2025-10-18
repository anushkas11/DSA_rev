class Solution {
    public boolean search(int[] a, int target) {
        int st=0,end=a.length-1;
        int ans=-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(a[mid]==target) {
                return true;
            }
            if(a[st]==a[mid] && a[end]==a[mid]){
                st++;
                end--;
            }
             else if(a[mid]<=a[end]){
                if(target>a[mid] && target<=a[end]) st=mid+1;
                else end=mid-1;
            }
            else {
                if(target>=a[st] && target<a[mid]) end=mid-1;
                else st=mid+1;
            }
        }
        return false;
        
    }
}
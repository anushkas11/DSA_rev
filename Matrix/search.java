class Solution {
    public boolean searchMatrix(int[][] a, int target) {
       int n=a.length;
       int m=a[0].length;
       int st=0,end=n*m-1;
       while(st<=end){
        int mid=st+(end-st)/2;
        int midEle=a[mid/m][mid%m];
        if(midEle==target)return true;
        if(target<midEle)end=mid-1;
        else st=mid+1;

       }
       return false;
    }
}
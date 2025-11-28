class lwrbound{
    public static void main(String[] args) {
        int arr[]={1,2,2,3};
        int key=2;
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>=key){
                ans=mid;
                end=mid-1;
            }
            else start=mid+1;
        }
        System.out.println(ans);
    }
}
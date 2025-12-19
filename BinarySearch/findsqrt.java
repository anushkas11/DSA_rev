class findsqrt{
    public static void main(String[] args) {
        int n=28;
        int l=1,h=n;
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(mid<=n/mid){
                ans=mid;
                l=mid+1;
            }
            else h=mid-1;
        }
        System.out.println(ans);
    }
}
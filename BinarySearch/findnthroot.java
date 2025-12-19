class findnthroot{
    public static void main(String[] args) {
        int n=4,m=67;
        int l=1,h=m;
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(Math.pow(mid,n)<=m){
                ans=mid;
                l=mid+1;
            }
            else h=mid-1;
        }
        System.out.println(ans);
    }
}
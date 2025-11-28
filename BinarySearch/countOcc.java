class countOcc{
    public static int firstOcc(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                result = mid;      
                right = mid - 1;    
            } 
            else if (arr[mid] < target) {
                left = mid + 1;
            } 
        }
        return result;
    }

    public static int lastOcc(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                result = mid;      
                left = mid + 1;     
            } 
            else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 6, 7, 8};
        int target = 4;

        int first = firstOcc(arr, target);
        int last = lastOcc(arr, target);

        System.out.println("Ans="+(last-first+1));
    }
}
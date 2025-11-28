class floorciel {
    public static void main(String[] args) {
        int arr[] = {3, 4, 4, 7, 8, 10};
        int key = 5;

        int floor = -1; 
        int ceil = -1;

        int i = 0, j = arr.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (arr[mid] == key) {
                floor = arr[mid];
                ceil = arr[mid];
                break;
            }

            if (arr[mid] < key) {
                floor = arr[mid];   
                i = mid + 1;
            } else {
                ceil = arr[mid];   
                j = mid - 1;
            }
        }

        System.out.println("Floor = " + floor + ", Ceil = " + ceil);
    }
}

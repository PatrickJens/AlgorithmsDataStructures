package Search;

public class BinarySearch {
    public static int search(int[] arr, int target){
        int first = 0;
        int last  = arr.length - 1;
        while(last >= first){
            int mid = (first + last)/2;
            if( arr[mid] < target)
                last = mid - 1;
            else if( arr[mid] > target)
                first = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}

package Sorts;
//i and j propogate from outside to inside
public class QuickSortHoare {
    private static void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void sort(int[] arr){
        int first = 0;
        int last  = arr.length-1;
        hoare(arr, first, last);
    }
    private static void hoare(int[] arr, int first, int last){
        //Base Condition
        if( first >= last) return;
        //Partition array.
        int i = first+1, j = last;
        while( i <= j){
            if( arr[i] < arr[first])
                i ++;
            else if( arr[j] > arr[first])
                j --;
            else{
                swap(arr, i , j);
                i++;
                j--;
            }
        }
        swap(arr, first, j);
        hoare(arr, first, j-1);
        hoare(arr, j+1, last);
    }
}
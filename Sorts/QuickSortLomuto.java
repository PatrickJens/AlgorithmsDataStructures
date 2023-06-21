package Sorts;
/* i and j propogate in the same direction
*  pivot always first index
*  for nested-while j = i - 1
*/
public class QuickSortLomuto{
    private static void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void sort(int[] arr){
        int first = 0;
        int last  = arr.length-1;
        lomuto(arr, first, last);
    }
    private static void lomuto(int[] arr, int first, int last){
        //Base Condition
        if( first >= last) return;
        //Partition array. First is the pivot
        int i = first, j = first;
        for( i = first; i <= last; i ++){
            if( arr[i] < arr[first]){
                j ++;
                swap(arr, j, i);
            }
        }
        swap(arr, j, first);


        lomuto(arr, first, j-1);
        lomuto(arr, j+1, last);
    }
}

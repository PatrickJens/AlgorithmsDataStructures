package Sorts;
// Insertion sort selects unsorted element and searches sorted sub array
// for the index to inserted arr[i] into.
// Bubbles sorted elements to the right
public class InsertionSort
{
    public static void sort(int[] arr){
        int i, j, tmp;
        for(i = 0; i < arr.length ; i++){
            j = i - 1;
            tmp = arr[i];
            while( j >= 0 && arr[j] > tmp  ){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j+1] = tmp;
        }
    }
}

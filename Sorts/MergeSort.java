package Sorts;

public class MergeSort {
    public static void sort(int[] arr){
        int first = 0;
        int last  = arr.length - 1;
        mergesort(arr, first, last);
    }
    public static void mergesort(int[] arr, int first, int last){
        //Base Condition
        if( first == last ) return;
        //Middle index
        int mid = (first + last)/2;
        //Pass left and right sub arrays to recursive method
        mergesort(arr, first, mid);
        mergesort(arr, mid + 1, last);
        //Merge sub arrays into aux array in asc order
        int[] aux = new int[arr.length];
        int i = first, j = mid+1, k = first;
        while( i <= mid && j <= last){
            if(arr[i] < arr[j])
                aux[k++] = arr[i++];
            else
                aux[k++] = arr[j++];
        }
        while( i <= mid)
            aux[k++] = arr[i++];
        while( j <= last)
            aux[k++] = arr[j++];
        k=first;
        while(k <= last)
            arr[k] = aux[k++];
    }
}

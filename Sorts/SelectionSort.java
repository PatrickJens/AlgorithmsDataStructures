package Sorts;

public class SelectionSort {
    static public void sort(int[] A) {
        int i=0, j=0;
        int minIdx 	= 0;
        int tmp  	= 0;

        for(i=0; i < A.length; i ++) {
            minIdx = i;
            for(j=i; j < A.length ; j ++) {
                if(A[j] < A[minIdx])
                    minIdx = j;
            }
            tmp = A[minIdx];
            A[minIdx] = A[i];
            A[i] = tmp;
        }
    }
}

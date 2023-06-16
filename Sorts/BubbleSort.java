package Sorts;

public class BubbleSort {

    static public void sort(int[] A){
        int i = 0, j = 0;
        int tmp = 0;
        for(i=0; i < A.length; i ++){
            for(j=0; j < (A.length - i - 1); j ++){
                if( A[j] > A[j+1]){
                    tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
                }
            }
        }
    }
}

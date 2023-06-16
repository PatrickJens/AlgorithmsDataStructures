import mgmt.*;
import Sorts.*;
import java.util.*;
public class Main {
    public static void main(String[] args){
        int[] arr = AM.createIntArray(10);
        System.out.println(Arrays.toString(arr));
        QuickSortLomuto.sort(arr);
        System.out.println("my sort=   " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("java sort= " + Arrays.toString(arr));



    }



}

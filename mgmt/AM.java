package mgmt;
import java.util.Random;
public class AM
{
    static private Random r = new Random();

    static public int[] createIntArray(int size) {
        int[] a = new int[size];
        for(int i = 0 ; i < size ; i ++) {
            a[i] = r.nextInt(25);
        }
        return a;
    }
    static public void printInt(int[] a) {
        for(int i = 0 ; i < a.length ; i ++) {
            System.out.print(" " + a[i]);
        }
        System.out.println("");
    }
}

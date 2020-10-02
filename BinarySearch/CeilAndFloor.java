import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int d = scn.nextInt();
        int low = 0;
        int high = n - 1;
        int c=0; 
        int f=0;

        while (low <= high) {
            int mid = (int)(low + high) / 2;
            if (d > arr[mid]) {
                low = mid + 1;
                f=arr[mid];
            } else if (d < arr[mid]) {
                high = mid - 1;
                c=arr[mid];
            } else {
                c=arr[mid];
                f=arr[mid];
                break;
            }
        }
        
        System.out.println(c+"\n"+f);
    }

}
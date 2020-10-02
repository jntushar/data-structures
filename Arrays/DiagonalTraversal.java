import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        for(int gap=0; gap<n; gap++){
            int i=0;
            for(int j=gap; j<n; j++){
                System.out.println(arr[i][j]);
                i++;
            }
        }
    }

}
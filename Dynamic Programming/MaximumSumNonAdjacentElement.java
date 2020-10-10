/*

1. You are given a number n, representing the count of elements.
2. You are given n numbers, representing n elements.
3. You are required to find the maximum sum of a subsequence with no adjacent elements.

*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int inc = arr[0];
        int exc = 0;
        for(int i=1; i<n; i++){
            int ninc = exc + arr[i];
            int nexc = Math.max(inc, exc);
            
            exc = nexc;
            inc = ninc;
        }
        
        System.out.println(Math.max(inc, exc));
    }
}
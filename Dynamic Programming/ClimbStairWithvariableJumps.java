/*

1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you 
     could jump to in a single move.  
     You can of course jump fewer number of steps in the move.
4. You are required to print the number of different paths via which you can climb to the top.

*/


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
        int path = getStairCaseWithVariableJumps(n, arr, new int[n + 1]);
        System.out.println(path);
    }

    public static int getStairCaseWithVariableJumps(int n, int[] arr, int[] dp) {
        
        dp[n] = 1;
        for(int i=dp.length-2; i>=0; i--){
            for(int j=1; j<=arr[i]; j++){
                if(i+j<dp.length){
                    dp[i] += dp[i+j];
                }
            }
        }
        return dp[0];
    }
}
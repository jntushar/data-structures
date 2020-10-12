/*

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction

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
        int maxProfit = 0;
        int buy = arr[0];
        int sell = 0;
        for(int i=1; i<n; i++){
            if(arr[i]<=buy){
                buy = arr[i];
            }else{
                sell = arr[i];
                maxProfit = Math.max(maxProfit, sell-buy);
            }
        }
        maxProfit = Math.max(maxProfit, sell-buy);
        System.out.println(maxProfit);
    }

}
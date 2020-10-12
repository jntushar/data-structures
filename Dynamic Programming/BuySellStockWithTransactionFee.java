/*

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are give a number fee, representing the transaction fee for every transaction.
4. You are required to print the maximum profit you can make if you are allowed infinite transactions, but has to pay "fee" for every closed transaction.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).

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
        int fee = scn.nextInt();
        
        int oBuy = -arr[0];
        int oSell = 0;
        
        for(int i=1; i<n; i++){
            int nBuy = 0;
            int nSell = 0;
            
            if(oSell - arr[i] > oBuy){
                nBuy = oSell - arr[i];
            }else{
                nBuy = oBuy;
            }
            
            if(oBuy + arr[i] - fee > oSell){
                nSell = oBuy + arr[i] - fee;
            }else{
                nSell = oSell;
            }
            
            oSell = nSell;
            oBuy = nBuy;
        }
        
        System.out.println(oSell);
    }

}
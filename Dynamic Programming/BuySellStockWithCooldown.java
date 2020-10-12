/*

1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions, but have to cooldown for 1 day after 1 transaction
i.e. you cannot buy on the next day after you sell, you have to cooldown for a day at-least before buying again.
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
        
        int oBuy = -arr[0];
        int oSell = 0;
        int oCool = 0;
        
        for(int i=1; i<n; i++){
            int nBuy = 0;
            int nSell = 0;
            int nCool = 0;
            
            //Buy
            if(oCool -arr[i] > oBuy){
                nBuy = oCool - arr[i];
            }else{
                nBuy = oBuy;
            }
            
            //Sell
            if(oBuy + arr[i] > oSell){
                nSell = oBuy+arr[i];
            }else{
                nSell = oSell;
            }
            
            //Cool
            if(oSell > oCool){
                nCool = oSell;
            }else{
                nCool = oCool;
            }
            
            oCool = nCool;
            oSell = nSell;
            oBuy = nBuy;
        }
        
        System.out.println(oSell);
    }

}

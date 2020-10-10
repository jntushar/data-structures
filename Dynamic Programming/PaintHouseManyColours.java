/*

1. You are given a number n and a number k separated by a space, representing the number of houses and number of colors.
2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with one of the k colors.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.

*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int c = scn.nextInt();
        int[][] arr = new int[n][c];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][c];

        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for (int j = 0; j < c; j++) {
            dp[0][j] = arr[0][j];

            if (arr[0][j] <= least) {
                sleast = least;
                least = arr[0][j];
            } else if(arr[0][j] <= sleast) {
                sleast = arr[0][j];
            }
        }

        for (int i = 1; i < n; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;

            for (int j = 0; j < c; j++) {
                dp[i][j] = arr[i][j];

                if (dp[i - 1][j] == least) {
                    dp[i][j] += sleast;
                } else {
                    dp[i][j] += least;
                }
                // calculating new min and second last min
                if (dp[i][j] <= nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if(dp[i][j] <= nsleast){
                    nsleast = dp[i][j];
                }
            }

            least = nleast;
            sleast = nsleast;
        }
        
        System.out.println(least);
    }
}
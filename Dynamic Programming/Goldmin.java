/*

link: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/goldmine-official/ojquestion#

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from 
     any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.


*/



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mine = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mine[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        System.out.println(getMaxGold(mine, dp));
    }

    public static int getMaxGold(int[][] mine, int[][] dp) {
        for (int j = 0; j < mine[0].length; j++) {
            for (int i = 0; i < mine.length; i++) {
                if (j == 0) {
                    dp[i][j] = mine[i][j];
                } else {
                    int max = Integer.MIN_VALUE;
                    for (int row = i - 1, col = j - 1; row <= i + 1; row++) {
                        if (row >= 0 && row < mine.length) {
                        	if(dp[row][col] > max) {
                            max = dp[row][col];
                        	}
                        }
                    }
                    dp[i][j] = mine[i][j] + max;
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < mine.length; i++) {
            if (res < dp[i][mine[0].length - 1]) {
                res = dp[i][mine[0].length - 1];
            }
        }
        return res;
    }

}
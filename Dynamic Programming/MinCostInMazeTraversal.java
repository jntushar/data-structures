/*

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom- 
     right cell).
7. You are required to traverse through the matrix and print the cost of path which is least costly.

*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] maze = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                maze[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        System.out.println(getMinCost(maze, dp));
    }
    
    public static int getMinCost(int[][] maze, int[][] dp){
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                if(i==0 && j==0){
                    dp[i][j] = maze[i][j];
                }else if(i==0){
                    dp[i][j] = maze[i][j]+dp[i][j-1];
                }else if(j==0){
                    dp[i][j] = maze[i][j]+dp[i-1][j];
                }else{
                    if(dp[i-1][j]<dp[i][j-1]){
                        dp[i][j] = maze[i][j] + dp[i-1][j];
                    }else{
                        dp[i][j] = maze[i][j] + dp[i][j-1];
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

}
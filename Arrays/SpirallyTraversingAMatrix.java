/*

GFG Question

https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix/0


Given a matrix mat[][] of size M*N. Traverse and print the matrix in spiral form.

Input:
The first line of the input contains a single integer T, denoting the number of test cases. Then T test cases follow. Each testcase has 2 lines. First line contains M and N respectively separated by a space. Second line contains M*N values separated by spaces.

Output:
Elements when travelled in Spiral form, will be displayed in a single line.

Constraints:
1 <= T <= 100
2 <= M,N <= 10
0 <= Ai <= 100

Example:
Input:
2
4 4
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
3 4
1 2 3 4 5 6 7 8 9 10 11 12

Output:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
1 2 3 4 8 12 11 10 9 5 6 7

*/


***********SOLUTION*************


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
		Scanner scanner = new Scanner(System.in);
		int t=scanner.nextInt();
		while(t-->0){
		    int m=scanner.nextInt();
		    int n=scanner.nextInt();
		    
		    int matrix[][] = new int[m][n];
		    for(int i=0; i<m; i++){
		        for(int j=0; j<n; j++){
		            matrix[i][j] = scanner.nextInt();
		        }
		    }
		    
		    List<Integer> res = new ArrayList<>();
		    
		    int topRow=0;
		    int bottomRow=m-1;
		    int leftCol=0;
		    int rightCol=n-1;
		    
		    while(topRow<=bottomRow && leftCol<=rightCol){
		        for(int i=leftCol; i<=rightCol; i++){
		            res.add(matrix[topRow][i]);
		        }
		        topRow++;
		        
		        for(int i=topRow; i<=bottomRow; i++){
		            res.add(matrix[i][rightCol]);
		        }
		        rightCol--;
		        
		        if(topRow<=bottomRow){
		            for(int i=rightCol; i>=leftCol; i--){
		                res.add(matrix[bottomRow][i]);
		            }
		        }
		        bottomRow--;
		        
		        if(leftCol<=rightCol){
		            for(int i=bottomRow; i>=topRow; i--){
		                res.add(matrix[i][leftCol]);
		            }
		        }
		        leftCol++;
		    }
		    
		    for(int i=0; i<res.size(); i++)
		        System.out.print(res.get(i) + " ");
		    System.out.println();
		}
	 }
}
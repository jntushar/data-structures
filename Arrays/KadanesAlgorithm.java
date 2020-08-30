/*

GFG Question

https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0


Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

Constraints:
1 = T = 110
1 = N = 106
-107 = A[i] <= 107

Example:
Input
2
5
1 2 3 -2 5
4
-1 -2 -3 -4
Output
9
-1

Explanation:
Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.

*/


***********SOLUTION***********


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t=scanner.nextInt();
		
		while(t-->0){
		    int size=scanner.nextInt();
		    int[] arr=new int[size];
		    for(int i=0; i<size; i++){
		        arr[i]=scanner.nextInt();
		    }
		    
		    int maxSum=arr[0];
		    int curSum=arr[0];
		    for(int i=1; i<size;i++){
		        curSum = Math.max(arr[i],curSum+arr[i]);
		        maxSum = Math.max(maxSum, curSum);
		    }
		    
		    System.out.println(maxSum);
		}
	}
}
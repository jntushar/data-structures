/*

GFG QUESTIOIN


https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0


Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1010

Example:
Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
Output:
2 4
1 5

Explanation :
Testcase1: sum of elements from 2nd position to 4th position is 12
Testcase2: sum of elements from 1st position to 5th position is 15

*/



**********SOLUTION************

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t=scanner.nextInt();
		
		while(t-->0){
		    int n = scanner.nextInt();
		    int s = scanner.nextInt();
		    int[] arr = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i]=scanner.nextInt();
		    }
		    
		    ArrayList res=getSubarray(n, s, arr);
		    for(int i=0; i<res.size(); i++)
		    	System.out.print(res.get(i) + " ");
		    System.out.println();
		    
		}
	}
	
	static ArrayList<Integer> getSubarray(int n, int s, int[] arr){
	    int counter=0;
	    int sum=0;
	    ArrayList<Integer> res=new ArrayList<>();
	    for(int i = 0; i<n; i++){
	        sum+=arr[i];
	        
	        while(sum>s){
	            sum -= arr[counter];
	            counter++;
	        }
	        
	        if(sum == s){
	           res.add(counter+1);
	           res.add(i+1);
	           return res;
	        }
	    }
	    res.add(-1);
	    return res;
	}		
}

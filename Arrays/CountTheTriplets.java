/*

Geeksforgeeks

https://practice.geeksforgeeks.org/problems/count-the-triplets/0


Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.

Output:
For each test case, print the count of all triplets, in new line. If no such triplets can form, print "-1".

Constraints:
1 <= T <= 100
3 <= N <= 105
1 <= A[i] <= 106

Example:
Input:
2
4
1 5 3 2
3
3 2 7
Output:
2
-1

Explanation:
Testcase 1: There are 2 triplets: 1 + 2 = 3 and 3 +2 = 5

*/

**********SOLUTION**********


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		
		while(t-->0){
		    int n=scanner.nextInt();
		    int[] arr = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = scanner.nextInt();
		    }
		    
		    Arrays.sort(arr);
		    int start = 0;
		    int end = n-2;
		    int j = n-1;
		    int count = 0;
		    while(j>1){
		        if(end>start){
		            if(arr[start]+arr[end] > arr[j])
		                end--;
		            else if(arr[start]+arr[end] < arr[j])
		                start++;
		            else{
		                count++;
		                start++;
		                end--;
		            }     
		        }
		        else{
		            start=0;
		            j -= 1;
		            end = j-1;
		        }
		    }
		    if(count == 0)
		        System.out.println(-1);
		    else
		        System.out.println(count);
		}
	}
}
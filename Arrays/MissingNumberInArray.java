/*

GFG Question

https://practice.geeksforgeeks.org/problems/missing-number-in-array/0


Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number is to be found.

Input:
The first line of input contains an integer T denoting the number of test cases. For each test case first line contains N(size of array). The subsequent line contains N-1 array elements.

Output:
Print the missing number in array.

Constraints:
1 = T = 200
1 = N = 107
1 = C[i] = 107

Example:
Input:
2
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10

Output:
4
9

Explanation:
Testcase 1: Given array : 1 2 3 5. Missing element is 4.

*/


*********SOLUTION***********


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
		    int[] arr=new int[size-1];
		    for(int i=0; i<size-1; i++){
		        arr[i]=scanner.nextInt();
		    }
		    Arrays.sort(arr);
		    System.out.println(getMissingNumber(size, arr));
		}
	}
	
	static int getMissingNumber(int size, int[] arr){
	    if(arr[0]!=1) return 1;
	    if(arr[size-2] != size) return size;
	    
	    int i=0;
	    for(i=1; i<size-2;i++){
	        if(arr[i]!=arr[i-1]+1)
	            break;
	    }
	    
	    return i+1;
	}
}




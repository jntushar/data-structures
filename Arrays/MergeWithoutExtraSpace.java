/*

GFG Question

https://www.geeksforgeeks.org/must-do-coding-questions-for-companies-like-amazon-microsoft-adobe/


Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).

Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify existing arrays as following.

Input: arr1[] = {10};
       arr2[] = {2, 3};
Output: arr1[] = {2}
        arr2[] = {3, 10}  

Input: arr1[] = {1, 5, 9, 10, 15, 20};
       arr2[] = {2, 3, 8, 13};
Output: arr1[] = {1, 2, 3, 5, 8, 9}
        arr2[] = {10, 13, 15, 20} 
Input:
First line contains an integer T, denoting the number of test cases. First line of each test case contains two space separated integers X and Y, denoting the size of the two sorted arrays. Second line of each test case contains X space separated integers, denoting the first sorted array P. Third line of each test case contains Y space separated integers, denoting the second array Q.

Output:
For each test case, print (X + Y) space separated integer representing the merged array.

Constraints:
1 <= T <= 100
1 <= X, Y <= 5*104
0 <= arr1i, arr2i <= 109

Example:
Input:
2
4 5
1 3 5 7
0 2 6 8 9
2 3
10 12
5 18 20

Output:
0 1 2 3 5 6 7 8 9
5 10 12 18 20

Explanation:
Testcase 1: After merging two non-decreasing arrays, we have, 0 1 2 3 5 6 7 8 9.

*/


**********SOLUTION***********


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
		    int x=scanner.nextInt();
		    int y=scanner.nextInt();
		    
		    int[] p=new int[x];
		    int[] q=new int[y];
		    
		    for(int i=0; i<x; i++){
		        p[i]=scanner.nextInt();
		    }
		    
		    for(int i=0; i<y; i++){
		        q[i]=scanner.nextInt();
		    }
		    
		    int ptr1=x-1;
		    int ptr2=0;
		    int temp;
		    
		    while(ptr1>=0 && ptr2<y){
		        if(p[ptr1] > q[ptr2]){
		            temp=p[ptr1];
		            p[ptr1]=q[ptr2];
		            q[ptr2]=temp;
		        }
		        else
		            break;
		        ptr1--;
		        ptr2++;
		    }
		    
		    Arrays.sort(p);
		    Arrays.sort(q);
		    
		    for(int i=0; i<x; i++){
		        System.out.print(p[i] +" ");
		    }
		    
		    for(int i=0; i<y; i++){
		        System.out.print(q[i] +" ");
		    }
		    
		    System.out.println();
		    
		}
	 }
}



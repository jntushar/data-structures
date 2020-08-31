/*

GFG Question

https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0

Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.The result is going to be very large, hence return the result in the form of a string.

Input:
The first line of input consists number of the test cases. The description of T test cases is as follows:
The first line of each test case contains the size of the array, and the second line has the elements of the array.

Output:
In each separate line print the largest number formed by arranging the elements of the array in the form of a string.

Constraints:
1 = T = 100
1 = N = 102
0 = A[i] = 103

Example:
Input:
2
5
3 30 34 5 9
4
54 546 548 60

Output:
9534330
6054854654


*/


********SOLUTION*********


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.next());
		while(t-->0)
		{
		    int n=Integer.parseInt(sc.next());
		    ArrayList<String> numbers=new ArrayList<>();
		    for(int i=0;i<n;i++)
		    {
		        numbers.add(String.valueOf(sc.next()));
		    }
		    Collections.sort(numbers,new Comp());
		    
		    for(String number : numbers)
		    {
		        System.out.print(number);
		    }
		    System.out.println();
		}
	}
	
	public static class Comp implements Comparator<String>
	{
	    public int compare(String str1,String str2)
	    {

	        return -Integer.compare(Integer.parseInt(str1+str2),Integer.parseInt(str2+str1));
	    }
	}
}
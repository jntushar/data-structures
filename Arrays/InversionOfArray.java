/*

GFG Question

https://practice.geeksforgeeks.org/problems/inversion-of-array/0/


Given an array of positive integers. The task is to find inversion count of array.

Inversion Count : For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, the size of array. The second line of each test case contains N elements.

Output:
Print the inversion count of array.

Constraints:
1 = T = 100
1 = N = 107
1 = C = 1018

Example:
Input:
1
5
2 4 1 3 5

Output:
3

Explanation:
Testcase 1: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).

*/


*******SOLUTION*********


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
		Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while(t-->0){
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for(int i=0; i<n; i++){
                arr[i]=scanner.nextInt();
            }
            
            System.out.println(mergeSort(arr));
        }
	 }
	 
	 static long mergeSort(int[] arr) {
	    long count = 0;
		int mid;
		if(arr.length > 1) {
			mid = arr.length/2;
			int[] L = new int[mid];
			int[] R = new int[arr.length-mid];
			for(int i=0; i<L.length;i++)
				L[i]=arr[i];
			int l = mid;
			for(int i=0; i<arr.length-mid ;i++) {
				R[i]=arr[l];
				l++;
			}
						
			count += mergeSort(L);
		    count += mergeSort(R);
			
			count += merge(arr,L,R);
		}
		return count;
	}
	
	static long merge(int[] arr, int[] L, int[] R) {
		long count=0;
		int i=0, j=0, k=0;
		while(i<L.length && j<R.length) {
			if(L[i]<R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
				count = count + (L.length-i);
			}
			k++;
		}
		
		while(i<L.length) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j<R.length) {
			arr[k] = R[j];
			j++;
			k++;
		}
		return count;
	}
}
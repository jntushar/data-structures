/*
 * 
 * GeeksForGeeks
 * https://practice.geeksforgeeks.org/problems/next-happy-number
 * 
For a given non-negative integer N, find the next smallest Happy Number.
A number is called happy if it leads to 1 after a sequence of steps where in each step number is replaced by sum of squares of its digit that is if we start with Happy Number and keep replacing it with digits square sum, we reach 1.

Input:

First line of input is an integer T, denoting the number of test cases.
For each test case, there is one line of input consisting of an integer N, whose next smallest happy number has to be found.

Output:

The only line of output for each test case consists of the next smallest happy number for the given number N.
If the integer N, is a happy number itself, then too, it's next smallest happy number should be printed as output.


Constraints:

0<=T<=200

0<=N<1000


Example:

Input:

4
8
3
0
10

Output:

10
7
1
13


Explanation:

The next smallest happy numbers for the numbers 8,3 and 0 are 10,7 and 1 respectively.
For 10 which is a happy number itself, therefore it's next smallest happy number is 13.


 */


class NextHappyNumber {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		
		for(int i=0; i<t; i++){
		    int n = scanner.nextInt();
		    if(checkHappyNumber(n) == 1)
		        n += 1;
		    while(checkHappyNumber(n)!=1)
		        n += 1;
		    System.out.println(n);
		}
	}
	
	public static int checkHappyNumber(int n){
	    int squareSum=0;
	    while(n!=0){
	        int temp = n%10;
	        squareSum += temp*temp;
	        n = n/10;
	    }
	    if(squareSum == 1)
	        return 1;
	    else if(squareSum>=0 && squareSum<=9)
	        return 2;
	   return checkHappyNumber(squareSum);
	}
}
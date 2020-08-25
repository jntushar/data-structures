/*
 * GeeksForGeeks
 * https://practice.geeksforgeeks.org/problems/express-as-sum-of-power-of-natural-numbers/0
 * 
 * 
 * Given two numbers X and N, find out the total number of ways X can be expressed as sum of Nth power of unique natural numbers.

Examples:

Input  : X = 10, N = 2
Output : 1
Explanation: 10 = 12 + 32, 
Hence total 1 possibility

Input  : X = 100, N = 2
Output : 3
Explanation: 100 = 102
             OR 62 + 82
             OR 12 + 32 + 42 + 52 + 72
Hence total 3 possibilities

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains a single line containing two space seperated integers denoting the values of X and N respectively.

Output:
For each test case output a new line containing a single integer denoting the total number of ways X can be expressed as sum of Nth power of unique natural numbers.

Constraints:
1 <= T <= 100
1 <= X <= 103
1 <= N <= 5

Example:
Input:
2
10 2
100 2
Output:
1
3
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class SumOfPowerOfNaturalNumber {
	public static void main (String[] args) throws IOException, NumberFormatException {
		//Scanner scanner = new Scanner(System.in);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int t = Integer.parseInt(br.readLine());
				
				while(t-->0) {
					//double x = scanner.nextDouble();
					//double n = scanner.nextDouble();
					
					String inputs[] = br.readLine().trim().split(" ");
					double x = Double.parseDouble(inputs[0]);
					double n = Double.parseDouble(inputs[1]);
					
					
					double start = Math.pow(x, (1/n));
					System.out.println(getUniqueNumber(x, n, start));
				}
	}
	
	public static int getUniqueNumber(double x, double n, double start) {
		if(x==0)
			return 1;
		if(x<0)
			return 0;
		if(start==0)
			return 0;
		
		double value = Math.pow(start, n);
		return getUniqueNumber(x-value, n, start-1) + getUniqueNumber(x, n, start-1);
	}
}
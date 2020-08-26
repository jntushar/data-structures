import java.util.Scanner;

/*
 * GeeksForGeeks
 * 
 * https://practice.geeksforgeeks.org/problems/handshakes/0
 * 
 * 
 * We have N persons sitting on a round table. Any person can do a handshake with any other person.

    1
2        3
    4
Handshake with 2-3 and 1-4 will cause cross.

In how many ways these N people can make handshakes so that no two handshakes crosses each other. N would be even. 

For example, in above diagram, there are two non-crossing ways to handshake {{1, 2}, {3, 4}} and {{1, 3}, {2, 4}}.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N.

Output:

Print number of ways.

Constraints:

1 ≤ T ≤ 20
2 ≤ N ≤ 30

Example:

Input:
2
2
8

Output:
1
14
 * */

class Handshakes {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
            int n=scanner.nextInt();
            System.out.println(getHandshakes(n));
        }
	}    
    public static int getHandshakes(int n){
        if(n==0)
            return 1;
        int ways=0;
        for(int i=2;i<=n;i+=2){
            ways += getHandshakes(i-2)*getHandshakes(n-i);
        }
        return ways;
    }
}

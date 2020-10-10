/*

1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.

*/



import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int prev0 = 1;
    int prev1 = 1;
    int cur0 = 0;
    int cur1 = 0;
    
    for(int i=2; i<=n; i++){
        cur1 = prev0 + prev1;   
        cur0 = prev1;
        prev0 = cur0;
        prev1 = cur1;
    }
    
    System.out.println(cur0 + cur1);
 }

}
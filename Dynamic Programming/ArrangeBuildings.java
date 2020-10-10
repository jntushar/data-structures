/*

1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.

*/


import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    long prevS = 1;
    long prevB = 1;
    long curS = 0;
    long curB = 0;
    for(int i=2; i<=n; i++){
        curB = prevS;
        curS = prevS+prevB;
        prevS = curS;
        prevB = curB;
    }
    
    long oneSide = curS+curB;
    System.out.println(oneSide*oneSide);
 }

}
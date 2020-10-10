/*

1. You are given a string str.
2. You are required to calculate and print the count of subsequences of the nature a+b+c+.
For abbc -> there are 3 subsequences. abc, abc, abbc
For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.

*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        int a = 0;
        int ab = 0;
        int abc = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                a = 2 * a + 1;
            } else if (str.charAt(i) == 'b') {
                ab = 2 * ab + a;
            } else if (str.charAt(i) == 'c') {
                abc = 2 * abc + ab;
            }
        }

        System.out.println(abc);
    }
}
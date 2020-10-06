/*

1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
Use the input-output below to get more understanding on what is required
123 -> abc, aw, lc
993 -> iic
013 -> Invalid input. A string starting with 0 will not be passed.
103 -> jc
303 -> No output possible. But such a string maybe passed. In this case print nothing.

*/



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printEncodings(str, "");
    }

    public static void printEncodings(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        } else if (ques.length() == 1) {
            if (ques.charAt(0) == '0') {
                return;
            } else {
                int chv = ques.charAt(0) - '0';
                char code = (char)('a' + chv - 1);
                ans = ans + code;
                System.out.println(ans);
            }
        } else {
            char ch = ques.charAt(0);
            String rem = ques.substring(1);

            if (ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                printEncodings(rem, ans + code);
            }

            String ch12 = ques.substring(0, 2);
            String rem12 = ques.substring(2);
            int ch12v = Integer.parseInt(ch12);
            if (ch12v <= 26) {
                char code = (char)('a' + ch12v - 1);
                printEncodings(rem12, ans + code);
            }
        }
    }

}
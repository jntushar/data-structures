/*

Input: PepCODiNg
Output: pEPcodIng

*/


import java.io.*;
import java.util.*;

public class Main {

    public static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            int ascii = (int) sb.charAt(i);
            if (ascii >= 65 && ascii <= 90) {
                char ch = (char) (ascii + 32);
                sb.setCharAt(i, ch);
            } else {
                char ch = (char) (ascii - 32);
                sb.setCharAt(i, ch);
            }
        }

        return sb.toString();

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }

}
/*

1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
2. The following list is the key to characters map :
    0 -> .;
    1 -> abc
    2 -> def
    3 -> ghi
    4 -> jkl
    5 -> mno
    6 -> pqrs
    7 -> tu
    8 -> vwx
    9 -> yz
3. Complete the body of getKPC function - without changing signature - to get the list of all words that could be produced by the keys in str.
Use sample input and output to take idea about output.

*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(getKPC(str));
    }

    static String[] codes = {
        ".;",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tu",
        "vwx",
        "yz"
    };
    public static ArrayList < String > getKPC(String str) {
        if (str.length() == 0) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }

        char ch = str.charAt(0);
        String rem = str.substring(1);
        
        ArrayList<String> arr = getKPC(rem);
        ArrayList<String> words = new ArrayList<>();
        
        for(char chcode: codes[ch - 48].toCharArray()){
            for(String rstr: arr){
                words.add(chcode + rstr);
            }
        }
        return words;
    }

}
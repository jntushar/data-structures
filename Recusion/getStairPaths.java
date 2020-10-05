import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n<=0){
            ArrayList<String> a = new ArrayList<>();
            if(n==0){
                a.add("");
            }
            return a;
        }
        
        ArrayList<String> arr1 = getStairPaths(n-1);
        ArrayList<String> arr2 = getStairPaths(n-2);
        ArrayList<String> arr3 = getStairPaths(n-3);
        ArrayList<String> arr = new ArrayList<>();
        
        for(String a: arr1){
            arr.add(1+a);
        }
        for(String a: arr2){
            arr.add(2+a);
        }
        for(String a: arr3){
            arr.add(3+a);
        }
        
        return arr;
    }

}
/*

1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.

*/


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(getMazePaths(0,0,n-1,m-1));

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr>dr || sc>dc){
            ArrayList<String> arr = new ArrayList<>();
            return arr;
        }else if(sr==dr && sc==dc){
            ArrayList<String> arr = new ArrayList<>();
            arr.add("");
            return arr;
        }
        
        
        ArrayList<String> path1 = getMazePaths(sr+1, sc, dr, dc);
        ArrayList<String> path2 = getMazePaths(sr, sc+1, dr, dc);
        
        ArrayList<String> paths = new ArrayList<>();
        
        for(String a: path2){
            paths.add("h"+a);
        }
        for(String a: path1){
            paths.add("v"+a);
        }
        
        return paths;
    }

}
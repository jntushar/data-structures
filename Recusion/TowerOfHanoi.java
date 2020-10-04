import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int source = scn.nextInt();
        int destination = scn.nextInt();
        int helper = scn.nextInt();
        toh(n, source, destination, helper);

    }

    public static void toh(int n, int source, int destination, int helper) {
        if (n == 0) {
            return;
        }

        toh(n - 1, source, helper, destination);
        System.out.println(n + "[" + source +" -> " + destination +"]");
        toh(n - 1, helper, destination, source);
    }

}
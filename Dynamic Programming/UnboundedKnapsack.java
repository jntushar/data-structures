import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weights[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        int[] dp = new int[cap + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= weights[j]) {
                    dp[i] = Math.max(dp[i], dp[i -weights[j]] + values[j]);
                }
            }
        }
        System.out.println(dp[cap]);
    }
}
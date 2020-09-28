import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num1 = scn.nextInt();
        int num2 = scn.nextInt();
        int gcd = getGCD(num1, num2);
        System.out.println(gcd);
        System.out.println(getLCM(num1, num2, gcd));

    }

    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return getGCD(b, a % b);
    }

    public static int getLCM(int a, int b, int gcd) {
        int res = gcd;
        return (int)(res * (a/gcd) * (b/gcd));
    }
}
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int temp = n;
        int count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        
        k=k%count;
        if(k<0)
        k=k+count;

        int div = (int) Math.pow(10, k);
        int rem = n % div;
        n = n / div;
        int res = rem * (int) Math.pow(10, count - k);
        System.out.println(res + n);
    }
}
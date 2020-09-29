/*

*
	*
		*
			*
				*

*/



import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int space = 1; space < i; space++) {
                System.out.print("\t");
            }

            System.out.println("*");
        }

    }
}
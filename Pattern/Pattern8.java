/*

		*
	*		*
*				*
	*		*
		*

*/


import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int oSpace = n / 2;
        int iSpace = -1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= oSpace; j++) {
                System.out.print("\t");
            }
            System.out.print("*\t");
            for (int j = 1; j <= iSpace; j++) {
                System.out.print("\t");
            }
            if (i > 1 && i < n) {
                System.out.print("*");
            }

            if (i <= n / 2) {
                oSpace--;
                iSpace += 2;
            } else {
                oSpace++;
                iSpace -= 2;
            }
            System.out.println("");
        }
    }
}
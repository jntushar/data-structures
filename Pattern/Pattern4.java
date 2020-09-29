/*

* * *	* * *
* *	  * *
*	    *
* *       * *
* * *   * * *

*/



import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int nStars = n / 2 + 1;
        int nSpaces = 1;
        for (int i = 1; i <= n; i++) {
            for (int stars = 1; stars <= nStars; stars++) {
                System.out.print("*\t");
            }

            for (int j = 1; j <= nSpaces; j++) {
                System.out.print("\t");
            }

            for (int stars = 1; stars <= nStars; stars++) {
                System.out.print("*\t");
            }

            if (i <= n / 2) {
                nStars --;
                nSpaces+=2;
            } else {
                nStars++;
                nSpaces-=2;
            }
            System.out.println("\t");
        }

    }
}
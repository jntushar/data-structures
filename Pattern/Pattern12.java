/*

		1	
	2	3	2	
3	4	5	4	3	
	2	3	2	
		1	

*/



import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sp = n / 2;
        int star = 1;
        int val = 1;
        for (int i = 1; i <= n; i++) {
            int cval = val;
            for (int j = 1; j <= sp; j++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= star; j++) {

                System.out.print(cval + "\t");

                if (j <= star / 2) {
                    cval++;
                } else {
                    cval--;
                }
            }

            if (i <= n / 2) {
                sp--;
                val++;
                star += 2;
            } else {
                val--;
                sp++;
                star -= 2;
            }
            System.out.println();
        }

    }
}
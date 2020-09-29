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
        for(int i=1; i<=n; i++){
            for(int space = n-i; space>=1; space--){
                System.out.print("\t");
            }
            System.out.println("*");
        }
    }
}
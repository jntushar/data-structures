/*

1												1	
1	2										2	1	
1	2	3								3	2	1	
1	2	3	4						4	3	2	1	
1	2	3	4	5				5	4	3	2	1	
1	2	3	4	5	6		6	5	4	3	2	1	
1	2	3	4	5	6	7	6	5	4	3	2	1	

*/


import java.util.*;

public class Main{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    int star = 1;
    int space = (2*n)-3;
    int val = 1;
    
    for(int i=1; i<=n; i++){
        for(int j=1; j<=star; j++){
            System.out.print(val + "\t");
            val++;
        }
        for(int j=1; j<=space; j++){
            System.out.print("\t");
        }
        if(i==n){
            star--;
            val--;
        }
        for(int j=1; j<=star; j++){
            val--;
            System.out.print(val + "\t");
        }
        star++;
        space-=2;
        System.out.println();
    }

 }
}
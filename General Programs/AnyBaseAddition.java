import java.util.*;
  
  public class Main{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int b = scn.nextInt();
      int n1 = scn.nextInt();
      int n2 = scn.nextInt();
  
      int d = getSum(b, n1, n2);
      System.out.println(d);
   }
  
   public static int getSum(int b, int n1, int n2){
       return decimalToAnyBase(anyBaseToDecimal(n1, b)+anyBaseToDecimal(n2,b),b);
   }
   
   public static int anyBaseToDecimal(int n, int b){
       int res = 0;
       int p = 1;
       while(n>0){
           int dig = n % 10;
           n = n/10;
           
           res+=dig*p;
           p = p*b;
       }
       return res;
   }
   
   public static int decimalToAnyBase(int n, int b){
       int res = 0;
        int p = 1;
        while(n>0){
            int dig = n % b;
            n = n/b;
            res += dig*p;
            p = p *10;
        }
        return res;
   }
   
  }
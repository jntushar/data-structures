  public class Main{
  
  public static void main(String[] args) {
      Scanner scn  = new Scanner(System.in);
      int num = scn.nextInt();
      if(num == 1){
          System.out.println(0);
      }else if(num == 2){
          System.out.println(0);
          System.out.println(1);
      }else{
          System.out.println(0);
          System.out.println(1);
          int a = 0;
          int b = 1;
          int c;
          for(int i=3; i<=num; i++){
              c=a+b;
              System.out.println(c);
              a=b;
              b=c;
          }
      }
   }
  }
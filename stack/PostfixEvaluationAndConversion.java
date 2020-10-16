/*

1. You are given a postfix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to prefix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

*/


import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();
    Stack<Integer> postVal = new Stack<>();
    
    for(int i = 0; i<exp.length(); i++){
        char ch = exp.charAt(i);
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            //infix
            String v2 = infix.pop();
            String v1 = infix.pop();
            String val = "(" + v1 + ch + v2 + ")";
            infix.push(val);
            
            //prefix
            String x2 = prefix.pop();
            String x1 = prefix.pop();
            val = ch + x1 + x2;
            prefix.push(val);
            
            //postfix evaluation
            postVal.push(calculate(ch, postVal));
            
        }else{
            infix.push(ch + "");
            prefix.push(ch + "");
            postVal.push(ch - '0');
        }
    }
    
    System.out.println(postVal.peek());
    System.out.println(infix.peek());
    System.out.println(prefix.peek());
 }
 
 public static int calculate(char ch, Stack<Integer> postVal){
     int y2 = postVal.pop();
     int y1 = postVal.pop();
     if(ch == '+'){
         return y1 + y2;
     }else if(ch == '-'){
         return y1 - y2;
     }else if(ch == '*'){
         return y1 * y2;
     }else{
         return y1 / y2;
     }
 }
 
}
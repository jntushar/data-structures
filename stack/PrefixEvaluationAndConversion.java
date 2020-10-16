/*

1. You are given a prefix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to postfix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

*/


import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> preVal = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> postfix = new Stack<>();
    
    for(int i=exp.length()-1; i>=0; i--){
        char ch = exp.charAt(i);
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            //postfix
            String v1 = postfix.pop();
            String v2 = postfix.pop();
            String val = v1 + v2 + ch;
            postfix.push(val);
            
            //infix
            String x1 = infix.pop();
            String x2 = infix.pop();
            val = "(" + x1 + ch + x2 + ")";
            infix.push(val);
            
            //prefix evaluation
            preVal.push(calculate(ch, preVal));
            
        }else{
            infix.push(ch + "");
            postfix.push(ch + "");
            preVal.push(ch - '0');
        }
    }
    
    System.out.println(preVal.peek());
    System.out.println(infix.peek());
    System.out.println(postfix.peek());
 }
 
 public static int calculate(char ch, Stack<Integer> preVal){
     int x1 = preVal.pop();
     int x2 = preVal.pop();
     if(ch == '+'){
         return x1 + x2;
     }else if(ch == '-'){
         return x1 - x2;
     }else if(ch == '*'){
         return x1 * x2;
     }else{
         return x1 / x2;
     }
 }
 
}
/*

1. You are given an infix expression.
2. You are required to evaluate and print it's value.

CONSTRAINTS:

1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.

*/


**************Solution************

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for (int i = 0; i < exp.length(); i++) {
      char ch = exp.charAt(i);

      if (ch == '(') {
        operators.push(ch);
      } else if (Character.isDigit(ch)) {
        operands.push(ch - '0');
      } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
        while (operators.size() > 0 && operators.peek() != '(' && 
               precedence(ch) <= precedence(operators.peek())) {
          int val2 = operands.pop();
          int val1 = operands.pop();
          char op = operators.pop();

          int opval = operation(val1, val2, op);
          operands.push(opval);
        }

        operators.push(ch);
      } else if (ch == ')') {
        while (operators.size() > 0 && operators.peek() != '(') {
          int val2 = operands.pop();
          int val1 = operands.pop();
          char op = operators.pop();

          int opval = operation(val1, val2, op);
          operands.push(opval);
        }

        if (operators.size() > 0) {
          operators.pop();
        }
      }
    }

    while (operators.size() > 0) {
      int val2 = operands.pop();
      int val1 = operands.pop();
      char op = operators.pop();

      int opval = operation(val1, val2, op);
      operands.push(opval);
    }

    int val = operands.pop();
    System.out.println(val);
  }

  public static int precedence(char op){
    if(op == '+' || op == '-'){
      return 1;
    } else {
      return 2;
    } 
  }

  public static int operation(int val1, int val2, char op){
    if(op == '+'){
      return val1 + val2;
    } else if(op == '-'){
      return val1 - val2;
    } else if(op == '*'){
      return val1 * val2;
    } else {
      return val1 / val2;
    }
  }
}
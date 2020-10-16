/*

1. You are given an infix expression.
2. You are required to convert it to postfix and print it.
3. You are required to convert it to prefix and print it.

CONSTRAINTS:
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.

*/

***************Solution****************

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<String> operator = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            String ch = exp.substring(i, i + 1);
            if (ch.equals("(")) {
                operator.push(ch);
            } else if (ch.equals(")")) {
                while (!operator.peek().equals("(")) {
                    String op = operator.pop();

                    // prefix
                    String v2 = prefix.pop();
                    String v1 = prefix.pop();
                    String val = op + v1 + v2;
                    prefix.push(val);

                    //postfix
                    String x2 = postfix.pop();
                    String x1 = postfix.pop();
                    val = x1 + x2 + op;
                    postfix.push(val);
                }
                operator.pop();
            } else if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                while (operator.size() > 0 && !operator.peek().equals("(") &&
                    precedence(operator.peek()) >= precedence(ch)) {
                    String op = operator.pop();

                    // prefix
                    String v2 = prefix.pop();
                    String v1 = prefix.pop();
                    String val = op + v1 + v2;
                    prefix.push(val);

                    //postfix
                    String x2 = postfix.pop();
                    String x1 = postfix.pop();
                    val = x1 + x2 + op;
                    postfix.push(val);
                }
                operator.push(ch);
            } else {
                prefix.push(ch);
                postfix.push(ch);
            }
        }

        while (operator.size() > 0) {
            String op = operator.pop();

            // prefix
            String v2 = prefix.pop();
            String v1 = prefix.pop();
            String val = op + v1 + v2;
            prefix.push(val);

            //postfix
            String x2 = postfix.pop();
            String x1 = postfix.pop();
            val = x1 + x2 + op;
            postfix.push(val);
        }
        
        System.out.println(postfix.peek());
        System.out.println(prefix.peek());

    }


    public static int precedence(String str) {
        if (str.equals("+") || str.equals("-")) {
            return 1;
        } else
            return 2;
    }

}
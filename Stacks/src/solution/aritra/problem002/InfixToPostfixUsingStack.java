package solution.aritra.problem002;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Discuss infix to postfix conversion algorithm using stack
 * Description:
 * a)Create a stack
 * b)for each character t in the input stream
 *      if(t is an operand) output t
 *      else if(t is a right parenthesis)
 *          pop and output tokens until a left parenthesis is popped (but not output)
 *      else //t is an operator or left parenthesis
 *          pop and output tokens until one of lower priority than t is encountered or a left parenthesis
 *          is encountered or the stack is empty
 *          push t
 * c)pop and output tokens until the stack is empty
 */
public class InfixToPostfixUsingStack {
    public static void main(String[] args) {
        String expr1 = "(A*B-(C+D)+E+D)%R/F";
        System.out.println("Postfix expr = " + infixToPostfix(expr1));
    }

    public static String infixToPostfix(String s){
        Stack<Character> stk = new Stack<Character>();
        StringBuffer postfixExpression = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                while(stk.peek() != '('){
                    postfixExpression.append(stk.pop());
                    if(stk.isEmpty())
                        break;
                }
                stk.pop();
            }else if( s.charAt(i) == '+'){
                if(!stk.isEmpty()) {
                    while (getPriority(stk.peek()) >= getPriority('+')) {
                        postfixExpression.append(stk.pop());
                        if(stk.isEmpty())
                            break;
                    }
                }
                stk.push(s.charAt(i));
            }else if( s.charAt(i) == '-') {
                if(!stk.isEmpty()) {
                    while (getPriority(stk.peek()) >= getPriority('-')) {
                        postfixExpression.append(stk.pop());
                        if(stk.isEmpty())
                            break;
                    }
                }
                stk.push(s.charAt(i));
            }else if( s.charAt(i) == '*') {
                if(!stk.isEmpty()) {
                    while (getPriority(stk.peek()) >= getPriority('*')) {
                        postfixExpression.append(stk.pop());
                        if(stk.isEmpty())
                            break;
                    }
                }
                stk.push(s.charAt(i));
            }else if( s.charAt(i) == '/') {
                if(!stk.isEmpty()) {
                    while (getPriority(stk.peek()) >= getPriority('/')) {
                        postfixExpression.append(stk.pop());
                        if(stk.isEmpty())
                            break;
                    }
                }
                stk.push(s.charAt(i));
            }else if( s.charAt(i) == '%') {
                if(!stk.isEmpty()) {
                    while (getPriority(stk.peek()) >= getPriority('%')) {
                        postfixExpression.append(stk.pop());
                        if(stk.isEmpty())
                            break;
                    }
                }
                stk.push(s.charAt(i));
            }else if(s.charAt(i) == '('){
                stk.push(s.charAt(i));
            }else{
                postfixExpression.append(s.charAt(i));
            }
        }
        while(!stk.isEmpty()){
            postfixExpression.append(stk.pop());
        }
        return postfixExpression.toString();
    }

    public static int getPriority(Character ch){
        if(ch == '+' || ch == '-')
            return 1;
        if(ch == '*' || ch == '/' || ch == '%')
            return 2;
        return -1;
    }
}

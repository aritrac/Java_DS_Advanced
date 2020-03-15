package solution.aritra.problem001;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Use a stack to check balancing of symbols in an expression
 * Description:
 * a)Create a stack
 * b)while(end of input is not reached)
 *      1)If the character read is not a symbol to be balanced, ignore it.
 *      2)If the character is an opening symbol like (,[,{, push it onto the stack
 *      3)If it is a closing symbol like ),],}, then if the stack is empty report an error. Otherwise pop the stack.
 *      4)If the symbol popped is not the corresponding opening symbol, report an error
 * c)At the end of input, if the stack is not empty report an error.
 */
public class CheckSymbolBalancingUsingStack {
    public static void main(String[] args) {
        //Few expressions to be validated
        String expr1 = "(A+B)+(C-D)";
        String expr2 = "((A+B)+(C-D)";
        String expr3 = "((A+B)+[C-D])";
        String expr4 = "((A+B)+[C-D]}";

        System.out.println("Is expr1 balanced? " + isValidSymbolPattern(expr1));
        System.out.println("Is expr2 balanced? " + isValidSymbolPattern(expr2));
        System.out.println("Is expr3 balanced? " + isValidSymbolPattern(expr3));
        System.out.println("Is expr4 balanced? " + isValidSymbolPattern(expr4));
    }
    public static boolean isValidSymbolPattern(String s){
        Stack<Character> stk = new Stack<Character>();
        if(s == null || s.length() == 0)
            return true;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(!stk.isEmpty() && stk.peek() == '(')
                    stk.pop();
                else
                    return false;
            }else if(s.charAt(i) == ']'){
                if(!stk.isEmpty() && stk.peek() == '[')
                    stk.pop();
                else
                    return false;
            }else if(s.charAt(i) == '}'){
                if(!stk.isEmpty() && stk.peek() == '{')
                    stk.pop();
                else
                    return false;
            }else if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stk.push(s.charAt(i));
            }
        }
        if(stk.isEmpty())
            return true;
        else
            return false;
    }
}

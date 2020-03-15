package solution.aritra.problem004;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Aritra Chatterjee
 * Problem: Evaluate postfix expressions using stack
 * Solution:
 * 1.Scan the postfix string from left to right
 * 2.Initialize an empty stack
 * 3.Repeat steps 4 and 5 till all the characters are scanned
 * 4.If the scanned character is an operand, push it onto the stack
 * 5.If the operator is a binary operator, then pop two elements from the stack. After popping the elements,
 * apply the operator to those popped elements. Let the result of this operation be put back onto the stack.
 * 6.After all the characters are scanned, we will have only one element in the stack.
 * 7.Return top of the stack as result.
 */
public class EvaluatePostfixExpressions {
    public static int expressionEvaluation(String[] tokens){
        Stack<Integer> s = new Stack<Integer>();
        for(String token: tokens){
            if(token.equals("+")){
                int op1 = s.pop();
                int op2 = s.pop();
                int res = op1 + op2;
                s.push(res);
            }else if(token.equals("-")){
                int op1 = s.pop();
                int op2 = s.pop();
                int res = op2 - op1;
                s.push(res);
            }else if(token.equals("*")){
                int op1 = s.pop();
                int op2 = s.pop();
                int res = op1 + op2;
                s.push(res);
            }else if(token.equals("/")){
                int op1 = s.pop();
                int op2 = s.pop();
                int res = op1/op2;
                s.push(res);
            }else{
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        String postFixExpr = "1 2 3 * + 5 7 -";
        List<String> tokens = new ArrayList<String>();

        Pattern pattern = Pattern.compile("[0-9.]+|[*\\/+\\-]");
        Matcher matcher = pattern.matcher(postFixExpr);

        while(matcher.find()){
            tokens.add(matcher.group(0));
        }
        Object[] tokenArray = tokens.toArray();
        int result = expressionEvaluation(Arrays.copyOf(tokenArray,tokenArray.length,String[].class));
        System.out.println("Result = " + result);
    }
}

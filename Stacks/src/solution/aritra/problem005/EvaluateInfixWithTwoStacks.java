package solution.aritra.problem005;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Evaluate an infix expression with two stacks in one pass
 * Description: We can use the following algorithm
 *  ->Create an empty operator stack
 *  ->Create an empty operand stack
 *  ->For each token in the input string
 *     ->Get the next token in the infix string
 *     ->If the next token is an operand, place it on the operand stack
 *     ->If the next token is an operator, evaluate the operator
 *  ->While operator stack is not empty, pop operator and operands(left and right), evaluate left operator right
 *  and push the result onto operand stack
 *  ->Pop result from operand stack.
 */
public class EvaluateInfixWithTwoStacks {
    public static void main(String[] args) {
        String infixExpression = "2 * 4 + 6 / 2 - 8"; //result should be 5
        String[] tokens = infixExpression.split(" ");
        int result = evaluateInfixExpr(tokens);
        System.out.println("Result = " + result);
    }

    public static int evaluateInfixExpr(String[] tokens){
        Stack<Integer> operands = new Stack<Integer>();
        Stack<String> operators = new Stack<String>();
        for(String token : tokens){
            System.out.println( "Token: " + token + " " + operands.size() + " " + operators.size());
            if(isOperator(token)){
                if(operators.size() > 0) {
                    while (operands.size() > 0 && operators.size() > 0 && getPrecedence(operators.peek()) >= getPrecedence(token)) {
                        int res = applyOperator(operands.pop(), operands.pop(), operators.pop());
                        operands.push(res);
                        System.out.println("Result = " + res);
                    }
                }
                operators.push(token);
            }else{
                operands.push(Integer.parseInt(token));
            }
        }
        return operands.pop();
    }

    public static int applyOperator(int op1, int op2, String operator){
        if(operator.equals("+"))
            return op1 + op2;
        else if(operator.equals("-"))
            return op1 - op2;
        else if(operator.equals("*"))
            return op1 * op2;
        else if(operator.equals("/"))
            return op1 / op2;
        return 0;
    }

    public static int getPrecedence(String operator){
        if(operator.equals("+") || operator.equals("-"))
            return 1;
        else if(operator.equals("*") || operator.equals("/"))
            return 2;
        return 0;
    }

    public static boolean isOperator(String oper){
        if(oper.equals("+") || oper.equals("-") || oper.equals("*") || oper.equals("/")){
            return true;
        }
        return false;
    }
}
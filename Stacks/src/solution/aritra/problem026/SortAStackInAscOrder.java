package solution.aritra.problem026;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for sorting a stack in ascending order
 * Description: We will use two stacks for sorting the stack
 */
public class SortAStackInAscOrder {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(12);
        stk.push(7);
        stk.push(29);
        stk.push(30);
        stk.push(31);
        stk.push(46);

        Stack<Integer> ascStack = sortStack(stk);
        while(!ascStack.isEmpty())
            System.out.println(ascStack.pop());
    }

    public static Stack<Integer> sortStack(Stack<Integer> stk){
        Stack<Integer> ascStack = new Stack<>();
        while(!stk.isEmpty()){
            int temp = stk.pop();
            while(!ascStack.isEmpty() && ascStack.peek() > temp){
                stk.push(ascStack.pop());
            }
            ascStack.push(temp);
        }
        return ascStack;
    }
}

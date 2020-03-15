package solution.aritra.problem006;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Design a stack to get the minimum element in O(1) time
 * Description: Take an auxilliary stack that maintains the minimum of all values in the stack. Also, assume that
 * each element of the stack is less than its below elements. For simplicity let us call the auxilliary stack
 * min stack. When we pop the main stack, pop the min stack too. When we push the main stack, push either the new
 * element or the current minimum, whichever is lower. At any point, if we want to get the minimum, then we just
 * need to return the top element from the min stack. Let us take an example and trace it out.
 */
public class GetStackMinimumInO1 {
    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();
        int[] numArray = {2,3,5,10,7,8,29,56,44,1,-7,7,8,29}; // the numbers whose min will be decided in O(1)
        for(int num : numArray){
            st1.push(num);
            if(minStack.size() == 0)
                minStack.push(num);
            else if(minStack.peek() >= num){
                minStack.push(num);
            }else{
                minStack.push(minStack.peek());
            }
        }

        //printing out the minimum of all the elements
        System.out.println("Minimum of all elements = " + minStack.peek());

        //now printing out min element while popping one element from the original stack
        while (!st1.isEmpty()){
            System.out.println("Popped element: " + st1.pop());
            System.out.println("New minimum element: " + minStack.pop());
        }
    }
}

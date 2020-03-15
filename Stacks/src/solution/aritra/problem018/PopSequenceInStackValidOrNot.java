package solution.aritra.problem018;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a list of integers say 1,2,3,4,5,6 which will be inserted in order into a stack, and provided
 * a pop sequence such as 3,2,5,6,4,1. You need to validate whether this pop sequence is achievable with push(S)
 * and pop(X) operations.
 * Description:
 */
public class PopSequenceInStackValidOrNot {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5,6};
        int[] poppedValid = {3,2,5,6,4,1};
        int[] poppedInvalid = {1,5,4,6,2,3};
        int len = pushed.length;

        System.out.println("Is the push sequence valid? " + validateStackPopSequence(pushed,poppedValid,len));
        System.out.println("Is the push sequence valid? " + validateStackPopSequence(pushed,poppedInvalid,len));
    }

    public static boolean validateStackPopSequence(int[] pushed, int[] popped, int len){
        //count of popped elements
        int poppedCount = 0;

        //our stack
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            stack.push(pushed[i]);
            //check if the pushed value is next to be popped out and continue popping while popped[poppedCount] matches pushed.peek()
            while(!stack.isEmpty() && poppedCount < len && stack.peek() == popped[poppedCount]){
                stack.pop();
                poppedCount++;
            }
        }
        return poppedCount == len;
    }
}

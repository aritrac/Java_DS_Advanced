package solution.aritra.problem028;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an array of numbers, recursively remove adjacent duplicate numbers. The output array should not have
 * any adjacent duplcates.
 * Description: This solution runs with the concept of in-place stack. When element on stack doesnt match to the current
 * number, we add it to stack. When it matches to stack top, we skip numbers until the element match the top of stack
 * and remove the element from stack.
 */
public class RemoveAdjacentDuplicatesFromStack {
    public static void main(String[] args) {
        int[] array1 = {1,5,6,8,8,8,0,1,1,0,6,5}; //output should be 1
        int[] array2 = {1,9,6,8,8,8,0,1,1,0,6,5}; //output should be 1,9,5

        removeDuplicates(array1);
        removeDuplicates(array2);
    }

    public static void removeDuplicates(int[] array){
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < array.length;){
            if(st.isEmpty() || st.peek() != array[i])
                st.push(array[i++]);
            else {
                while(i < array.length && st.peek() == array[i]) //avoid duplicates from incoming array to enter the stack
                    i++;
                st.pop(); //remove that same element from the stack itself as it is a duplicate
            }
        }
        //printing the array from stk after duplicates removal
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
}

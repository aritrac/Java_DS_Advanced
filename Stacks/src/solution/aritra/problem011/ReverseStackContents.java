package solution.aritra.problem011;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a stack, how to reverse the contents of the stack using only stack operations (push and pop)
 * Description:
 * ->First pop all the elements of the stack till it becomes empty.
 * ->For each upward step in recursion, insert the element at the bottom of the stack.
 */
public class ReverseStackContents {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        //testing the insertAtBottomOfStack method
        insertAtBottomOfStack(stk,8); //this 8 will be inserted before 1
        System.out.println("Testing the insertAtBottomOfStack method");
        while(!stk.isEmpty()){
            System.out.println(stk.pop());
        }
        System.out.println("Now testing the reverseStack method");
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        reverseStack(stk);
        while(!stk.isEmpty())
            System.out.println(stk.pop());
    }
    //This method reverses the stack using the second method insertAtBottomOfStack
    public static void reverseStack(Stack<Integer> stk){
        if(stk.isEmpty())
            return;
        int temp = stk.pop();
        reverseStack(stk);
        insertAtBottomOfStack(stk,temp);
    }
    //This method empties the stack and then reinserts all elements in the original order
    public static void insertAtBottomOfStack(Stack<Integer> stk, int data){
        if(stk.isEmpty()){
            stk.push(data);
            return;
        }
        int temp = stk.pop();
        insertAtBottomOfStack(stk, data);
        stk.push(temp);
    }
}

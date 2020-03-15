package solution.aritra.problem007;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Improve the space complexity for problem006 while generating the minimum element in stack in O(1) time.
 * Description: Yes, the main problem of the previous approach is for each push operation we were pushing the element
 * onto min stack also. That means we were pushing duplicate elements onto the min stack. We will rectify that in this
 * approach
 */
public class GetStackMinInO1Time {
    public static void main(String[] args) {
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();
        int[] elements = {2,5,17,-4,8,10,-5,16,99,100,7,8,11};

        for(int element : elements){
            st1.push(element);
            if(minStack.size() == 0)
                minStack.push(element);
            else if(minStack.peek() >= element) //avoiding duplicates
                minStack.push(element);
        }

        System.out.println("Minimum of all the elements : " + minStack.peek());

        while(!st1.isEmpty()){
            int element = st1.pop();
            System.out.println("Popped element: " + element);
            if(!minStack.isEmpty() && minStack.peek() == element){
                minStack.pop();
                if(!minStack.isEmpty())
                    System.out.println("New minimum = " + minStack.peek());
                else
                    System.out.println("Main list is empty");
            }
        }
    }
}

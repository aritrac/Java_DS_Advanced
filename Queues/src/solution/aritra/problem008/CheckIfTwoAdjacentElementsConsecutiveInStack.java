package solution.aritra.problem008;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a stack of integers, how do you check whether each successive pair of numbers in the stack is
 * consecutive or not.The pairs can be increasing or decreasing, and if the stack has an odd number of elements,
 * the element at the top is left out of a pair. For example, if the stack of elements are [4,5,-2,-3,11,10,5,6,20]
 * then the output should be true because each of the pairs (4,5),(-2,-3),(11,10),and (5,6) consists of consecutive
 * numbers
 * Description:
 */
public class CheckIfTwoAdjacentElementsConsecutiveInStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(4);
        s.push(5);
        s.push(-2);
        s.push(-3);
        s.push(11);
        s.push(10);
        s.push(5);
        s.push(6);

        System.out.println("Is the stack pairwise ordered? " + checkStackPairwiseOrder(s));
        s.clear();
        s.push(4);
        s.push(6);
        s.push(-2);
        s.push(-3);
        s.push(11);
        s.push(10);
        s.push(5);
        s.push(6);
        System.out.println("Is the stack pairwise ordered? " + checkStackPairwiseOrder(s));
    }

    public static boolean checkStackPairwiseOrder(Stack<Integer> s){
        Queue<Integer> q = new LinkedList<>();
        boolean pairwiseOrdered = true;
        while(!s.isEmpty())
            q.add(s.pop());
        while(!q.isEmpty())
            s.push(q.remove());
        while(!s.isEmpty()){
            int n = s.pop();
            q.add(n);
            if(!s.isEmpty()){
                int m = s.pop();
                q.add(m);
                if(Math.abs(n-m) != 1){
                    pairwiseOrdered = false;
                }
            }
        }
        while(!q.isEmpty())
            s.push(q.remove());
        return pairwiseOrdered;
    }
}

package solution.aritra.problem024;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Find the largest area in a histogram
 * Description: Please refer to the following youtube video -> https://www.youtube.com/watch?v=ZmnqCZp9bBs
 */
public class LargestRectangleUnderHistogram {
    public static void main(String[] args) {
        int[] A = {1,2,4,1,1};
        System.out.println("Max area = " + maxRectangleArea(A));
    }
    public static int maxRectangleArea(int[] A){
        Stack<Integer> s = new Stack<Integer>();
        if(A == null || A.length == 0)
            return 0;
        //initialize max area
        int maxArea = 0;
        int i = 0;
        //run through all bars of a histogram
        while(i < A.length){
            //if current bar is higher than the bar of the stack.peek(), push it onto stack
            if(s.isEmpty() || A[s.peek()] <= A[i]){
                s.push(i++);
            }else{
                //if current bar is lower than the stack.peek(),
                //calculate area of rectangle with stack top as the smallest bar.
                //'i' is 'right index' for the top and element before the top in stack is the left index
                int top = s.pop();
                //calculate the area with A[top] value as the smallest bar and update maxArea if needed
                maxArea = Math.max(maxArea, A[top] * (s.isEmpty()? i : i - s.peek() - 1));
            }
        }
        //Now since all the remaining bars will be in ascending order due to the condition A[s.peek()] <= A[i]
        while(!s.isEmpty()){
            int top = s.pop();
            maxArea = Math.max(maxArea, A[top] * (s.isEmpty()? i : i - s.peek() - 1));
        }
        return maxArea;
    }
}

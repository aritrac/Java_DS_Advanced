package solution.aritra.problem023;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an array A the span S[i] of A[i] is the maximum number of consecutive elements A[j] immediately
 * preceding A[i] and such that A[j] <= A[j+1] i.e. the maximum increasing sequence till A[i]
 * Solution: We can see that span S[i] on day i can be easily calculated if we know the closest day preceding i,
 * such that the price is greater on that day than the price on day i. Let us call such a day P. If such a day
 * exists then the span can now be defined as S[i] = i - P
 */
public class FindLargestSpanOfAnArrayUsingStack {

    public static void main(String[] args) {
        int[] array = {6,3,4,5,2};
        int[] spanArray = findSpans(array);
        for(int span : spanArray){
            System.out.println(span);
        }
    }

    public static int[] findSpans(int[] array){
        int[] spans = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        for(int i = 0; i < array.length; i++){
            while(!stack.isEmpty() && array[i] > array[stack.peek()]){
                stack.pop();//we pop the indices which honors the condition array[i] > array[stack.peek()] as
                //if i honored, i-1 honored, i-2 honored but i-3 didn't then in the stack we keep i and i-3 because
                //in future i is honored, then i-1 and i-2 will automatically be honored. Hence removing them from
                //stack.
            }
            if(stack.isEmpty())
                p = -1; //p is the position where the condition array[i] > array[stack.peek()] fails. So to get the span
                        //we subtract index p from index i to get how many indices honored the above condition and
                        //that is the span
            else
                p = (Integer)stack.peek();
            spans[i] = i - p;
            stack.push(i);
        }
        return spans;
    }
}

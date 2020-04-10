package problem006;

/**
 * Author: Aritra Chatterjee
 * Problem: Can we solve problem004 using dynamic programming?
 * Description: Let us say M(i) indicates maximum sum over all windows ending at i. To find maximum sum we have to do
 * one of the following and select maximum among them using two ways
 * ->Either extend the old sum by adding A[i]
 * ->Or start a new window starting with one element A[i]
 * M(i) = either 0 or max{M(i-1) + A[i]}
 */
public class ContiguousMaximumSumUsingDP {
    public static void main(String[] args) {
        int[] A = {-2,11,-4,13,-5,2};
        System.out.println("Max sum = " + maxContiguousSum(A));
    }

    public static int maxContiguousSum(int[] A){
        int maxSum = A[0], sum = 0;
        for(int i = 0; i < A.length; ++i){
            sum = Math.max(sum + A[i], A[i]);
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
}

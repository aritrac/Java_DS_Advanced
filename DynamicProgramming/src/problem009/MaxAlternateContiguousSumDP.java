package problem009;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a sequence of n numbers, give an algorithm for finding a contiguous subsequence A(i) to A(j)
 * for which the sum of the elements in the subsequence is maximum. Here the condition is we should not select
 * two contiguous numbers.
 * Description: We can do that using the following algorithm
 *          Max{A[i] + M(i-2), M(i-1)}, if i > 2
 * M(i) =   A[1]                        if i = 1
 *          Max{A[1],A[2]}              if i = 2
 * The first case indicates whether we are selecting the ith element or not. If we don't select the ith element
 * then we have to maximize the sum using elements 1 to i-1. If the ith element is selected then we should not
 * select i-1 th element and need to maximize the sum using 1 to i-2 elements.
 */
public class MaxAlternateContiguousSumDP {
    public static void main(String[] args) {
        int[] A = {-2,11,-4,13,-5,2};
        System.out.println("Max sum = " + maxSumWithNoTwoContiguousNumbers(A));
    }

    public static int maxSumWithNoTwoContiguousNumbers(int[] A){
        int[] M = new int[A.length + 1];
        M[0] = A[0];
        M[1] = (A[0] > A[1])?A[0]:A[1];
        int i;
        for(i = 2; i < A.length; i++){
            M[i] = (M[i-1] > M[i-2] + A[i]? M[i-1]: M[i-2] + A[i]);
        }
        return M[A.length - 1];
    }
}

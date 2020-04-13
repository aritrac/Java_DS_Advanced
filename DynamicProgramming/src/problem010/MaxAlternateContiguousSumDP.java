package problem010;

/**
 * Author: Aritra Chatterjee
 * Problem: In problem 9, we assumed that M(i) represents the maximum sum from 1 to i numbers without selecting two
 * contiguous numbers. Can we solve the same problem by changing the definition as M(i) represents the maximum sum
 * from i to n numbers without selecting two contiguous numbers
 * Description: We can do that using the following algorithm
 *          Max{A[i] + M(i+2), M(i+1)}, if i > 2
 * M(i) =   A[1]                        if i = 1
 *          Max{A[1],A[2]}              if i = 2
 * The first case indicates whether we are selecting the ith element or not. If we don't select the ith element
 * then we have to maximize the sum using the elements i+1 to n. If ith element is selected then we should not
 * select i+1th element need to maximize the sum using i+2 to n elements.
 * The last two cases indicate the base cases.
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
            M[i] = (M[i+1] > M[i+2] + A[i]? M[i+1]: M[i+2] + A[i]);
        }
        return M[A.length - 1];
    }
}


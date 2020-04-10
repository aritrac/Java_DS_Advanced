package problem005;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an array of n numbers give an algorithm for finding a contiguous subsequence A(i)...A(j) for which
 * the sum of elements is maximum.
 * Solution: If there are no negative numbers, then the solution is just the sum of all elements in the given array. If
 * negative sum are there, then our aim is to maximize the sum (there can be a negative number in the contiguous sum)
 * One important observation is that, if we have already calculated the sum for the subsequence i to j-1, then we need
 * only one more addition to get the sum for the subsequence i to j. But the previous approach ignores this
 * information. If we use this fact, we can get an improved algorithm with runtime of O(n^2)
 */

public class MaximumContiguousSequenceSumOptimized {
    public static void main(String[] args) {
        int[] A = {-2,11,-4,13,-5,2};
        System.out.println("Max sum = " + maxContiguousSum(A));
    }

    public static int maxContiguousSum(int[] A){
        int maxSum = 0;
        for(int i = 0; i < A.length; i++){
            int currentSum = 0;
            for(int j = i; j < A.length; j++){
                currentSum += A[j];
                if(currentSum > maxSum)
                    maxSum = currentSum;
            }
        }
        return maxSum;
    }
}

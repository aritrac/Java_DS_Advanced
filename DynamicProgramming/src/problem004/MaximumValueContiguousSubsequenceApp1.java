package problem004;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an array of n numbers give an algorithm for finding a contiguous subsequence A(i)...A(j) for which
 * the sum of elements is maximum.
 * Solution: (BRUTEFORCE) If there are no negative numbers, then the solution is just the sum of all elements in the given array. If
 * negative sum are there, then our aim is to maximize the sum (there can be a negative number in the contiguous sum)
 * One simple and brute force approach is to see all possible sums and select the one which has maximum value.
 */
public class MaximumValueContiguousSubsequenceApp1 {
    public static void main(String[] args) {
        int[] A = {-2,11,-4,13,-5,2};
        System.out.println("Max sum = " + maxContiguousSum(A));
    }

    public static int maxContiguousSum(int[] A){
        int maxSum = 0;
        for(int i = 0; i < A.length;i++){ //position 1
            for(int j = i; j < A.length; j++){ //position 2
                int currentSum = 0;
                for(int k = i; k <= j; k++){ //iterate between position 1 and position 2 to find the sum
                    currentSum += A[k];
                    if(currentSum > maxSum) //then check whether this range gives a better max sum or not
                        maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }
}

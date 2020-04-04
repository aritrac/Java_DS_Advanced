package problem027;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a sequence of n numbers A(1) to A(N) give an algorithm for finding a contiguous subsequence
 * A(i)...A(j) for which the sum of elements in the subsequence is maximum.
 * Description:
 * Case 1: it can be completely in the first half
 * Case 2: it can be completely in the second half
 * Case 3: it begins in the first half and ends in the second half
 * We will do the following:
 * ->Recursively compute the maximum contiguous subsequence that resides entirely in the first half
 * ->Recursively compute the maximum contiguous subsequence that resides entirely in the second half
 * ->Compute via two consecutive loops, the maximum contiguous subsequence sum that begins in the first half
 * but ends in the second half
 * ->Choose the largest of the 3 sums
 */

public class MaximumValueContiguousSubsequence{

    public static int maxSumSubArray(int[] A){
        if(A.length == 0)
            return 0;
        return maxSumSubArray(A,0,A.length - 1);
    }

    public static int maxSumSubArray(int[] A, int low, int high){
        int leftMidSum = Integer.MIN_VALUE;
        int rightMidSum = Integer.MIN_VALUE;
        int sum = 0;
        if(low == high)
            return A[low];
        int mid = low + (high - low)/2;
        int maxLeftSum = maxSumSubArray(A,low,mid);
        int maxRightSum = maxSumSubArray(A,mid+1, high);

        for(int i = mid; i >= low; i--){ //across sum
            sum += A[i];
            leftMidSum = (sum > leftMidSum)? sum : leftMidSum;
        }
        sum = 0; //reset sum as 0
        for(int i = mid + 1; i <= high; i++){
            sum += A[i];
            rightMidSum = (sum > rightMidSum)?sum : rightMidSum;
        }
        return max(maxLeftSum,maxRightSum,leftMidSum + rightMidSum);
    }

    public static int max(int a, int b, int c){
        return a > b? (a > c ? a : c) : (b > c? b: c);
    }

    public static void main(String[] args) {

    }
}

package problem007;

/**
 * Author: Aritra Chatterjee
 * Problem: Can we solve problem004 using dynamic programming?
 * Description: We can solve this problem without DP too(without memory). The algorithm is a little tricky.
 * One simple way is to look for all positive contiguous segments of the array (sumEndingHere) and keep track of the
 * maximum sum contiguous segment among all positive segments (sumSoFar). Each time we get a positive sum compare it
 * (sumEndingHere) with sumSoFar and update sumSoFar if it is greater than sumSoFar
 */

public class MaximumContiguousSumDP {
    public static void main(String[] args) {
        int[] A = {-2,11,-4,13,-5,2};
        System.out.println("Max sum = " + maxContiguousSum(A));
    }

    public static int maxContiguousSum(int[] A){
        int sumSoFar = 0, sumEndingHere = 0;
        for(int i = 0; i < A.length; i++){
            sumEndingHere = sumEndingHere + A[i];
            if(sumEndingHere < 0){
                sumEndingHere = 0;
                continue;
            }
            if(sumSoFar < sumEndingHere)
                sumSoFar = sumEndingHere;
        }
        return sumSoFar;
    }
}

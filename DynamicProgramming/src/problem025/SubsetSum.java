package problem025;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a sequence of n positive numbers A1...An, give an algorithm which checks whether there exists a subset
 * of A whose sum of all numbers is T.
 * Description: This is a variation of the knapsack problem. We will use the following formula
 * M[i][j] = Max(M[i-1,j],M(i-1,j-Ai))
 * According to the above recursive formula similar to the knapsack problem, we check if we can get the sum
 * j by not including the element i in our subset, and we check if we can get the sum j by including i and checking
 * if the sum j -Ai exists without the ith element. This is identical to knapsack, except that we are storing 0/1s
 * instead of values. In the below implementation we can use binary OR operation to get the maximum among
 * M[i-1,j] and M[i-1,j-Ai]
 * Refer to this link -> https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
 */
public class SubsetSum {
    //DP Solution
    public int subsetSum(int A[], int n, int T){
        int i,j;
        int[][] M = new int[n+1][T+1];
        M[0][0] = 0;
        for(i = 1; i <= T; i++)
            M[0][i] = 0;
        for(i = 1; i<= n; i++){
            for(j =0; j<= T; j++){
                M[i][j] = M[i-1][j] | M[i-1][j-A[i]];
            }
        }
        return M[n][T];
    }

    // Recursive solution
    // Returns true if there is a subset
    // of set[] with sum equal to given sum
    static boolean isSubsetSum(int set[],
                               int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than
        // sum, then ignore it
        if (set[n-1] > sum)
            return isSubsetSum(set, n-1, sum);

        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return isSubsetSum(set, n-1, sum) ||
                isSubsetSum(set, n-1, sum-set[n-1]);
    }
}

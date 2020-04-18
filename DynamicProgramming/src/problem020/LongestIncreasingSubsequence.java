package problem020;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a sequence of n numbers A1 ... An, determine a subsequence (not necessarily contiguous) of
 * maximum length in which the values in the subsequence form a strictly increasing subsequence.
 * Description: Let us generalize the discussion and decide about ith element. Let L(i) represent the optimal subsequence
 * which is starting at position A[1] and ending at A[i]. The optimal way to obtain a strictly increasing
 * subsequence ending at position i is to extend some subsequence starting at some earlier position j. For this
 * the recursive formula can be written as
 *                  L(i) = Max (j < i and A[j] < A[i]){L(j)} + 1
 * The above recurrence says that we have to select some earlier position j which gives the maximum sequence. The 1
 * in the recursive formula indicates the addition of ith element. Now after finding the maximum sequence for all
 * positions we have to select the one among all positions which gives the maximum sequence and it is defined as:
 *                  Max(i){L(i)}
 */
public class LongestIncreasingSubsequence {
    static int[] A = {5,6,2,3,4,1,9,9,8,9,5};
    static int n = A.length;
    public static int[] LISTable = new int[n+1];

    public static int getLongestIncreasingSubsequence(int[] A){
        int i,j,max = 0;
        for(i = 0; i < A.length; i++)
            LISTable[i] = 1;
        for(i = 0; i < A.length; i++){
            for(j = 0; j< i; j++){
                if(A[i] > A[j] && LISTable[i] < LISTable[j] + 1)
                    LISTable[i] = LISTable[j] + 1;
            }
        }
        for(i = 0; i < A.length; i++){
            if(max < LISTable[i])
                max = LISTable[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("The longest sequence is = " + getLongestIncreasingSubsequence(A));
    }
}

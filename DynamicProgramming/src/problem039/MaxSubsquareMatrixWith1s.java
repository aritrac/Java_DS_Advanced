package problem039;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a matrix wtih 0's and 1's, give an algorithm for finding the maximum size of subsquare matrix
 * with all 1s
 * Description: Following is the algorithm
 * 1) Construct a sum matrix S[R][C] for the given M[R][C].
 *      a)    Copy first row and first columns as it is from M[][] to S[][]
 *      b)    For other entries, use following expressions to construct S[][]
 *          If M[i][j] is 1 then
 *              S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
 *          Else If M[i][j] is 0
 *              S[i][j]=0
 * 2)Find the maximum entry in S[R][C]
 * 3)Using the value and coordinates of maximum entry in S[i],print sub-matrix of M[][]
 * Also watch the video for a very easy to understand solution -> https://www.youtube.com/watch?v=_Lf1looyJMU
 */
public class MaxSubsquareMatrixWith1s {
    public static int maxSubSquareMatrixWith1s(int[][] A){
        final int n = A.length;
        final int m = A[0].length;
        //will hold the size of the largest square sub-matrix with all 1s including L[i][j]
        //where L[i][j] is the rightmost and bottom most cell of the sub matrix
        int[][] L = new int[n][m];
        //initializing first row and first column to zero
        for(int i = 0; i < n; i++){
            L[i][0] = A[i][0];
        }
        for(int j = 0; j < m; j++){
            L[0][j] = A[0][j];
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(A[i][j] == 1){
                    L[i][j] = Math.min(Math.min(L[i][j-1],L[i-1][j]),L[i-1][j-1]) + 1;
                }else{
                    L[i][j] = 0;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                max = Math.max(max,L[i][j]);
            }
        }
        return max;
    }
}

package problem015;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a series of matrices A1 x A2 x A3 x ... x A4 with their dimensions, what is the best way to
 * parenthesize them so that it produces the manimum number of total multiplications. Assume that we are using
 * standard matrix
 * Description: https://www.youtube.com/watch?v=GMzVeWpyTN0 (Wonderfully explained)
 */

public class MatrixProductParenthesization {
    ///P is the sizes of the matrices, matrix i has the dimension P[i-1] x P[i]
    //M[i][j] is the best cost of multiplying matrices i through j
    //S[i][j] saves the multiplication point and we use this for back tracking

    public static void chainMultiplicationDP(int[] P){
        int n = P.length;
        int[][] M = new int[n][n];
        int[][] S = new int[n][n];
        for(int i = 1; i<= n; i++){
            M[i][i] = 0; //Filling in the matrix diagonal as M[i][j] should be 0 if i == j
        }
        for(int l = 2; l <= n; l++){ //here l is the chain length
            for(int i = 1; i <= n - l + 1; i++){
                int j = i + l - 1;
                M[i][j] = Integer.MAX_VALUE;
                //Try all possible division points i...k and k...j
                for(int k = i; k <= j - 1; k++){
                    int thisCost = M[i][k] + M[k+1][j] + P[i-1]*P[k]*P[j];
                    if(thisCost < M[i][j]){
                        M[i][j] = thisCost;
                        S[i][j] = k;
                    }
                }
            }
        }
    }
}

package problem037;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a matrix with n rows and m columns (n x m). In each cell there are a number of apples. We start from
 * the upper left corner of the matrix. We can go down or right one cell. Finally we need to arrive at the bottom
 * right corner. Find the maximum number of apples we can collect.
 * Description: Let us assume that the given matrix is A[n][m]. The first thing that must be observed is that there
 * are atmost 2 ways we can come to a cell - from the left (if its not situated on the first column) and from the top
 * (if its not situated on the top most row).To find the best solution for that cell, we have to have already found
 * the best solutions for all of the cells from which we can arrive to the current cell. From above the following
 * is obtained
 *
 *      S(i,j) = A[i][j] + Max[S(i,j-1),S(i-1,j)]
 */
public class BottomAndRightMotionInMatrix {
    public static int findMaxApplesCount(int[][] A){
        int[][] S = new int[A.length][A[0].length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                S[i][j] = A[i][j];
                if(j > 0 && S[i][j] < S[i][j] + S[i][j-1])
                    S[i][j] += S[i][j-1];
                if(i > 0 && S[i][j] < S[i][j] + S[i-1][j])
                    S[i][j] += S[i-1][j];
            }
        }
        return S[A.length - 1][A.length-1];
    }
}

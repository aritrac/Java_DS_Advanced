package problem041;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an n x n matrix M of positive and negative integers, give an algorithm to find the sub-matrix
 * with the largest possible sum.
 * Description: Please refer to this video and as a prerequisite, we need to know how to find the max sum in a
 * 1-D array using Kadane's algorithm before understanding the algo behind this problem.
 */
public class FindMaxSumSubMatrix {
    public static void findMaximumSubMatrix(int[][] A){
        //computing the vertical prefix sum for columns
        int[][] M = new int[A.length][A.length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                if(j == 0)
                    M[j][i] = A[j][i];
                else
                    M[j][i] = A[j][i] + M[j-1][i];
            }
        }
        int maxSoFar = 0, min, subMatrix;
        //iterate over the possible combinations applying Kadane's algo.
        for(int i = 0; i < A.length; i++){
            for(int j = i; j < A.length; j++){
                min = 0;
                subMatrix = 0;
                for(int k = 0; k < A.length; k++){
                    if(i == 0){
                        subMatrix += M[j][k];
                    }else{
                        subMatrix += M[j][k] - M[i-1][k];
                    }
                    if(subMatrix < min){
                        min = subMatrix;
                    }
                    if((subMatrix - min) > maxSoFar){
                        maxSoFar = subMatrix - min;
                    }
                }
            }
        }
        System.out.println("Result: " + maxSoFar);
    }

    public static void main(String[] args) {
        int[][] A ={
                {1,2,-1,-4,-20},
                {-8,-3,4,2,1},
                {3,8,10,1,3},
                {-4,-1,1,7,-6}
        };
        findMaximumSubMatrix(A);
    }
}

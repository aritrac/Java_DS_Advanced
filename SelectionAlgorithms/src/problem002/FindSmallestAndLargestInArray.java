package problem002;

/**
 * Author: Aritra Chatterjee
 * Problem: Find the largest and smallest elements in an array A of size n
 * Description: We can follow the same approach of problem 1
 */
public class FindSmallestAndLargestInArray {
    public static void findSmallestAndLargestInArray(int[] A, int n){
        int small = A[0];
        int large = A[0];
        for(int i = 1; i <= n-1; i++){
            if(A[i] < small)
                small = A[i];
            else if(A[i] > large)
                large = A[i];
        }
        System.out.println("Smallest: " + small + " Largest: " + large);
    }
}

package problem001;

/**
 * Author: Aritra Chatterjee
 * Problem: Find the largest element in an array A of size n
 * Description: Scan the complete array and return the largest element.
 */
public class FindLargestInArray {
    public static void findLargestInArray(int n, int[] A){
        int large = A[0];
        for(int i = 1; i<= n-1; i++){
            if(A[i] > large)
                large = A[i];
        }
        System.out.println("Largest = " + large);
    }
}

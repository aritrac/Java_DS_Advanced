package problem003;

/**
 * Author: Aritra Chatterjee
 * Problem: Can we improve upon the previous algorithm
 * Description: We can do this by comparing in pairs
 */
public class FindLargestSmallestUsingPairComparison {
    public static void findWithPairComparison(int[] A,int n){
        int large,small;
        large = small = -1;
        for(int i = 0; i <= n-1; i = i + 2){
            if(A[i] < A[i+1]){
                if(A[i] < small)
                    small = A[i];
                if(A[i+1] > large)
                    large = A[i+1];
            }else{
                if(A[i+1] < small)
                    small = A[i+1];
                if(A[i] > large)
                    large = A[i];
            }
        }
        System.out.println("Smallest: " + small + " Largest: " + large);
    }
}

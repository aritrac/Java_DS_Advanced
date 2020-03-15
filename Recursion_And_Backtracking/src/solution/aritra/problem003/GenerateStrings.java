package solution.aritra.problem003;

/**
 * Author: Aritra Chatterjee
 * Description: Generate all the strings of n bits. Assume A[0...n-1] is an array of size n.
 */
public class GenerateStrings {
    public static void main(String[] args) {
        int n = 6;
        int[] A = new int[n];
        generateAllStrings(A,n);
    }
    public static void generateAllStrings(int[] A,int n){
        if(n < 1) {
            for(int a: A){
                System.out.print(a);
            }
            System.out.println();
        } else{
            A[n-1] = 0;
            generateAllStrings(A, n - 1);
            A[n-1] = 1;
            generateAllStrings(A,n-1);
        }
    }
}

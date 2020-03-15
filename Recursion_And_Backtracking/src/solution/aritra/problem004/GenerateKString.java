package solution.aritra.problem004;

/**
 * Author: Aritra Chatterjee
 * Description: Generate all the strings of length n drawn from 0 to k-1
 */
public class GenerateKString {
    public static void main(String[] args) {
        int n = 6;
        int k = 4;
        int[] array = new int[n];
        generateKString(n,k,array);
    }
    public static void generateKString(int n,int k, int[] array){
        if(n < 1){
            for (int a: array){
                System.out.print(a);
            }
            System.out.println();
        }else {
            for (int i = 1; i <= k; i++) {
                array[n-1] = i;
                generateKString(n - 1, k, array);
            }
        }
    }
}

package solution.aritra.bubblesort;

/**
 * Author: Aritra Chatterjee
 * Problem: Write the bubble sort algorithm but with a small improvement, if a pass detects that no swap happened,
 * then the remaining passes will be avoided.
 * Description: Please see the algorithm below
 */
public class BubbleSortImproved {
    public static void main(String[] args) {
        int[] array = {12,34,11,9,56,110};
        bubbleSortImproved(array);
        for(int a : array)
            System.out.print(a + " ");
    }

    public static void bubbleSortImproved(int[] A){
        boolean swapped = true;
        int temp;
        for(int i = A.length -1 ; i >=0 && swapped; i--){
            swapped = false;
            for(int j = 0; j <= i - 1; j++ ){
                if(A[j] > A[j+1]){
                    temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                    swapped = true;
                }
            }
        }
    }
}

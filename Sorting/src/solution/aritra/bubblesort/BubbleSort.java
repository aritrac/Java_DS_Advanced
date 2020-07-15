package solution.aritra.bubblesort;

/**
 * Author: Aritra Chatterjee
 * Problem: Demonstrate the bubble sort algorithm
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5,10,6,7,1,2};
        bubbleSort(array);
        for(int a: array)
            System.out.print(a + " ");
    }

    public static void bubbleSort(int[] A){
        for(int pass = A.length - 1; pass >= 0; pass--){
            for(int i = 0; i <= pass - 1; i++){
                if(A[i] > A[i+1]){
                    //swap elements
                    int temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                }
            }
        }
    }
}

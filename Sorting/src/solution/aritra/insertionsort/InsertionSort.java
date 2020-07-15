package solution.aritra.insertionsort;

/**
 * Author: Aritra Chatterjee
 * Problem: Demonstrate insertion sort
 * Description: Every repetition of insertion sort removes an element from the input data, and inserts it into the
 * correct position in the already sorted list until no input elements remain. Sorting is typically done in-place.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {12,20,67,89,1,2,3};
        insertionSort(array);
        for(int a : array)
            System.out.print(a + " ");
    }

    public static void insertionSort(int[] A){
        int i,j,v;
        for(i = 1; i < A.length ; i++){
            v = A[i];
            j = i;
            while(A[j-1] > v && j >= 1){
                A[j] = A[j-1];
                j--;
                if(j == 0)
                    break;
            }
            A[j] = v;
        }
    }
}

package solution.aritra.selectionsort;

/**
 * Author: Aritra Chatterjee
 * Problem: Write the selection sort algorithm
 * Description: It follows the following algorithm
 * 1-> Find the minimum value in the list
 * 2-> Swap it with the value in the current position
 * 3-> Repeat this process for all the elements until the entire array is sorted
 *
 * This algorithm is called selection sort since it repeatedly selects the smallest element
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {12,20,76,11,9,46};
        selectionSort(array);
        for(int a : array)
            System.out.print(a + " ");
    }

    public static void selectionSort(int[] A){
        int i,j,min,temp;
        for(i = 0; i < A.length-1; i++){
            min = i;
            for(j = i+1; j < A.length; j++){ //find minimum in the array starting from j to end and then swap ith position with min position
                if(A[j] < A[min])
                    min = j;
            }
            //swap elements
            temp = A[min];
            A[min] = A[i];
            A[i] = temp;
        }
    }
}

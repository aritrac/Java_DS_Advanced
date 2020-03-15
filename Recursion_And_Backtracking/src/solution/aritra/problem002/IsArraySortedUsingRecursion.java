package solution.aritra.problem002;

/**
 * Author: Aritra Chatterjee
 * Description: Given an array, check whether the array is in ascending sorted order with recursion
 */
public class IsArraySortedUsingRecursion {
    public static void main(String[] args) {
        int[] unSortedArray = {3,67,12,15,90,100};
        System.out.println(isArraySorted(unSortedArray,unSortedArray.length));

        int[] sortedArray = {1,2,3,4,5,6,7};
        System.out.println(isArraySorted(sortedArray,sortedArray.length));
    }
    public static boolean isArraySorted(int[] array, int pos){
        if(array.length == 1 || pos == 1){
            return true;
        }
        return array[pos - 1] < array[pos - 2] ? false : isArraySorted(array,pos - 1);
    }
}

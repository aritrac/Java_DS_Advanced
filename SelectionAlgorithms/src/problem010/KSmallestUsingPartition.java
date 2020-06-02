package problem010;

/**
 * Author: Aritra Chatterjee
 * Problem: Find the k smallest elements in an array S of n elements using the partition method
 * Description:
 * ->Choose a pivot from the array
 * ->Partition the array so that: A[low...pivotpoint - 1] <= pivotpoint <= A[pivotpoint + 1...high]
 * ->If k < pivotpoint then it must be on the left of the pivot, so do the same method recursively on the left part
 * ->If k = pivotpoint then it must be the pivot and print all the elements from low to pivotpoint
 * ->If k > pivotpoint then it must be on the right of pivot, so do the same method recursively on the right part
 */
public class KSmallestUsingPartition {
    public static int partition(int[] A, int start, int end){
        int pivot = A[start];
        int pivotPosition = start++;
        while(start <= end){
            //scan for values less than the pivot
            while((start <= end) && (A[start] < pivot)){
                start++;
            }
            //scan for values greater than the pivot
            while((end >= start) && (A[end] >= pivot)){
                end--;
            }
            if(start > end){
                //swap the end unconfirmed
                //element with the pivot
                swap(A,pivotPosition,end);
            }else{
                //swap unconfirmed elements
                //start with the one that was not lesser than the pivot
                //and end with the one that was not larger than the pivot
                swap(A,start,end);
            }
        }
        return end;
    }
    private static int orderStatistic(int[] A, int k, int start, int end){
        int pivotPosition = partition(A,start,end);
        if(pivotPosition == k-1){
            return A[k-1];
        }
        if(k-1 < pivotPosition){
            return orderStatistic(A,k,start,pivotPosition - 1);
        }else{
            return orderStatistic(A,k,pivotPosition + 1, end);
        }
    }

    //iterative version
    private static int orderStatistics(int[] A, int k, int start, int end){
        int pivotPosition = partition(A,start,end);
        while(pivotPosition != k-1){
            if(k-1 < pivotPosition){
                end = pivotPosition - 1;
            }else{
                start = pivotPosition + 1;
            }
            pivotPosition = partition(A,start,end);
        }
        return A[k-1];
    }
    public static int kthSmallest(int[] A, int k){
        return orderStatistic(A,k,0,A.length - 1);
    }
    public static void swap(int[] A, int start, int end){
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
}

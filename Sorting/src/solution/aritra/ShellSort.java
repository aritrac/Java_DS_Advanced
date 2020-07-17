package solution.aritra;

/**
 * Author: Aritra Chatterjee
 * Problem: Demonstrate shell sort algorithm
 * Description: The basic idea in shell sort is to exchange every hth element in the array. It works by starting with big enough
 *  h so as to allow eligible element exchanges that are far apart. Once a sort is complete with a particular h,
 *  the array can be said as h-sorted. The next step is to reduce h by a certain sequence, and again perform another
 *  complete h-sort. Once h is 1 and h-sorted, the array is completely sorted. Notice that the last sequence for h is 1
 *  so the last sort is always an insertion sort, except by this time the array is already well-formed and easier to
 *  sort.
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {2,9,10,5,78,55,32};
    }

    public static void shellSort(int[] A){
        int i,j,h,v;
        for(h = 1; h < A.length/9; h = 3*h + 1){
            for(;h > 0; h = h/3){
                for(i = h + 1; i < A.length; i+=1){
                    v = A[i];
                    j = i;
                    while(j > h && A[j-h] > v){
                        A[j] = A[j-h];
                        j -= h;
                    }
                    A[j] = v;
                }
            }
        }
    }
}

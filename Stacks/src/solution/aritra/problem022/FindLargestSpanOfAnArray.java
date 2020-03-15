package solution.aritra.problem022;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an array A the span S[i] of A[i] is the maximum number of consecutive elements A[j] immediately
 * preceding A[i] and such that A[j] <= A[j+1] i.e. the maximum increasing sequence till A[i]
 * Solution: Find increasing pairs starting from i - 1 to 0 and for each such pair increase the span count.
 */
public class FindLargestSpanOfAnArray {
    public static void main(String[] args) {
        int[] array = {6,3,4,5,2};
        int[] spanArray = findSpan(array);
        for(int span : spanArray){
            System.out.println(span);
        }
    }
    public static int[] findSpan(int[] array){
        int[] spans = new int[array.length];
        for(int i = 0; i < array.length; i++){
            int span = 1;
            int j = i - 1;
            while(j >=0 && array[j] <= array[j+1]){ //finding increasing pairs starting from i - 1 to 0 and for each
                                                    // such pair increasing the span count
                span++;
                j--;
            }
            spans[i] = span;
        }
        return spans;
    }
}

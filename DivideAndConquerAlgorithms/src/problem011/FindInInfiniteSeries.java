package problem011;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an infinite array in which the first n cells contain integers in sorted order and the rest of the
 * cells are filled with some special symbols (say,$). Assume we do not know the n value. Given an algorithm that takes
 * an integer K as input and finds a position in the array containing K, if such as position exists in O(log n) time.
 * Description: In the given scenario we cannot use binary search as we do not know the end of the list. Our first
 * problem is to find the end of the list. To do that we can start at the first element and keep searching with
 * doubled index. That means we first search at index 1 then 2,4,8,...
 */

public class FindInInfiniteSeries {
    public static void main(String[] args) {

    }

    public static int findInInfiniteSeries(int[] A){
        int mid = 0,l,r;
        l = r = 1;
        while(A[r] != '$'){
            l = r;
            r = r * 2;
        }
        while(r - l > 1){
            mid = (r-l)/2 + l;
            if(A[mid] == '$')
                r = mid;
            else
                l = mid;
        }
        return mid;
    }
}

package problem012;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a sorted array of non repeated integers A[1..n], check whether there is an index i for which A[i] = i.
 * Give a divide and conquer algorithm that runs in time O(log n)
 */
public class IndexSearcher {
    public static void main(String[] args) {

    }

    public static int indexSearcher(int[] A,int l, int r){
        int mid = (r - l)/2 + l;
        if(r - l <= 1){
            if(A[l] == l || A[r] == r)
                return 1;
            else
                return 0;
        }
        if(A[mid] < mid)
            return indexSearcher(A,mid + 1, r);
        if(A[mid] > mid)
            return indexSearcher(A,l,mid - 1);
        return mid;
    }
}

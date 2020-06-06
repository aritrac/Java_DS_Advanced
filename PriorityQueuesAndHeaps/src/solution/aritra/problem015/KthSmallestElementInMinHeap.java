package solution.aritra.problem015;

import solution.aritra.util.Heap;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for finding the kth smallest element in min-heap
 * Description: One simple solution to this problem is: perform deletion k times from min-heap
 */
public class KthSmallestElementInMinHeap {
    public int findKthLargestEle(Heap h, int k){
        //Just delete first k-1 elements and return the kth element
        for(int i =0; i < k-1; i++)
            h.deleteMax();
        return h.deleteMin();
    }
}

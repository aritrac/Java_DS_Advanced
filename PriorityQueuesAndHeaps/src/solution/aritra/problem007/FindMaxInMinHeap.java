package solution.aritra.problem007;

import solution.aritra.util.Heap;

/**
 * Author: Aritra Chatterjee
 * Problem: given a min heap, give an algorithm for finding the maximum element
 * Solution: For a given min heap, the max element will always be at leaf only. Now, the next question is how to find
 * the leaf nodes in the tree. If we carefully observer, the next node of the last elements parent is the
 * first leaf node. Since the last element is always at the h.count - 1 position, the next node of its parent(parent
 * is at location (h.count-1)/2) can be calculated as
 *  (h.count-1)/2 + 1
 * Now the only step remaining is scanning the leaf nodes and finding the maximum among them
 */
public class FindMaxInMinHeap {
    public int findMaxInMinHeap(Heap h){
        int max = -1;
        for(int i = (h.count + 1)/2; i < h.count; i++){
            if(h.array[i] > max)
                max = h.array[i];
        }
        return max;
    }
}

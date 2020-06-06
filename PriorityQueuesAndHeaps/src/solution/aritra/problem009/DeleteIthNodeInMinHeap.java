package solution.aritra.problem009;

import solution.aritra.util.Heap;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for deleting the ith indexed element in a given min heap
 * Description:
 */
public class DeleteIthNodeInMinHeap {
    public int delete(Heap h, int i){
        int key;
        if(h.count < i){
            System.out.println("Wrong position");
            return -1;
        }
        key = h.array[i];
        h.array[i] = h.array[h.count - 1];
        h.count--;
        h.percolateDown(i);
        return key;
    }
}

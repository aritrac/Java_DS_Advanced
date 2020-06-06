package solution.aritra.problem016;

import solution.aritra.util.Heap;

/**
 * Author: Aritra Chatterjee
 * Problem: For problem 15 can we improve the time complexity?
 * Description: Assume that the original min-heap is called HOrig and the auxiliary min heap is called HAux.
 * Initially, the element at the top of HOrig, the minimum one, is inserted into HAux. Here we dont do the operation
 * of DeleteMin with HOrig. Every while loop iteration gives the kth smallest element and we need k loops to get the
 * kth smallest element. Because the size of the auxiliary heap is always less than k, every while loop iteration,
 * increases the size of the auxiliary head by one, and the original heap HOrig has no operations during the
 * finding.
 */
public class FindKthLargestElement {
    Heap HOrig, HAux;
    public int findKthLargest(int k){
        int heapElement; //Assuming heap data is of integers
        int count = 1;
        HAux.insert(HOrig.deleteMin());
        while(true){
            //return the minimum element and delete it from the HAux heap
            heapElement = HAux.deleteMin();
            if(++count == k){
                return heapElement;
            }else{ //insert the left and right children into HOrig into the HAux
                int hOrigIndex = HOrig.getLocation(heapElement);
                HAux.insert(HOrig.array[(hOrigIndex * 2) + 1]); //Inserting the left child of the heapElement
                HAux.insert(HOrig.array[(hOrigIndex * 2) + 2]); //Inserting the right child of the heapElement
            }
        }
    }
}

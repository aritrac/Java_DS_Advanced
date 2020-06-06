package solution.aritra.problem030;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an array and an integer K, find the maximum sum for each and every contiguous subarray of size k
 * Description:
 * Create a deque to store k elements.
 *
 * Run a loop and insert first k elements in the deque. While inserting the element if the element at the back of the
 * queue is smaller than the current element remove all those elements and then insert the element.
 *
 * Now, run a loop from k to end of the array.
 *
 * Print the front element of the array
 *
 * Remove the element from the front of the queue if they are out of the current window.
 *
 * Insert the next element in the deque. While inserting the element if the element at the back of the queue is smaller
 * than the current element remove all those elements and then insert the element.
 *
 * Print the maximum sum of the last window
 */
public class MaximumSlidingWindow {

    // A Dequeue (Double ended queue) based method for printing maximum element of
    // all subarrays of size k
    static void printMax(int arr[], int n, int k)
    {
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window) elements of array */
        int i;
        for (i = 0; i < k; ++i) {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast(); // Remove from rear

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            // The element at the front of the queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");

            // Remove the elements which are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements)
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 3;
        printMax(arr, arr.length, k);
    }
}

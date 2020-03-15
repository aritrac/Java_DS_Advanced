package solution.aritra.problem001;

import solution.aritra.queue.implementation.FixedSizeArrayQueue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for reversing the queue using a stack.
 * Description: See the code below
 */
public class ReverseQueue {
    public static void main(String[] args) {
        FixedSizeArrayQueue q1 = new FixedSizeArrayQueue();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.enqueue(5);
        q1.enqueue(6);

        System.out.println(q1);
        FixedSizeArrayQueue q2 = reverseQueue(q1);
        System.out.println(q2);
    }

    public static FixedSizeArrayQueue reverseQueue(FixedSizeArrayQueue queue){
        Stack<Integer> stack = new Stack();
        while(!queue.isEmpty()){
            stack.push(queue.dequeue());
        }
        while(!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }
        return queue;
    }
}

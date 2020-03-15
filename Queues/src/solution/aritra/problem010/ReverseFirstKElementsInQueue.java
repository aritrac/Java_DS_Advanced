package solution.aritra.problem010;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an integer k and a queue of integers, how do you reverse the order of the first k elements
 * of the queue, leaving the other elements in the same relative order?
 * Description: For example, if k = 4 and queue has the elements [10,20,30,40,50,60,70,80,90], the output should be
 * [40,30,20,10,50,60,70,80,90]
 */
public class ReverseFirstKElementsInQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);
        q.offer(7);
        q.offer(8);
        q.offer(9);
        q.offer(10);
        System.out.println("Initially");
        System.out.println(q);
        //lets reverse the first 4 elements, so k = 4
        reverseQueueFirstKElements(4,q);
        System.out.println("After reversal");
        System.out.println(q);

    }

    public static void reverseQueueFirstKElements(int k, Queue<Integer> q){
        if(q == null || k > q.size()){
            throw new IllegalArgumentException();
        }else if(k > 0){
            Stack<Integer> s = new Stack<>();
            //removing first k elements and putting them on stack
            for(int i =0; i<k; i++){
                s.push(q.remove());
            }
            //putting the stack elements at the end of queue
            while(!s.isEmpty()){
                q.add(s.pop());
            }
            //removing the remaining elements from the queue which was not pushed onto the stack, to the end of queue
            //to achieve the intended distribution
            for(int i =0; i<q.size() -k;i++){
                q.offer(q.poll());
            }
        }
    }
}

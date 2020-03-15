package solution.aritra.problem009;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a queue of integers, rearrange the elements by interleaving the first half of the list with
 * the second half of the list.
 * Description: For example, suppose a queue stores the following sequence of values: [11,12,13,14,15,16,17,18,19,20]
 * Consider the two halves of this list: first half: [11,12,13,14,15] and second half: [16,17,18,19,20]. These are
 * combined in an alternating fashion to form a sequence of interleaving pairs to result in [11,16,12,17,13,18,14,19,15,20]
 */

public class InterleavedListFromQueueHalves {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(11);
        q.offer(12);
        q.offer(13);
        q.offer(14);
        q.offer(15);
        q.offer(16);
        q.offer(17);
        q.offer(18);
        q.offer(19);
        q.offer(20);

        System.out.println("Initial queue");
        System.out.println(q);

        System.out.println("After interleaving");
        interLeavingQueue(q);
        System.out.println(q);
    }

    public static void interLeavingQueue(Queue<Integer> q){
        if(q.size() % 2 != 0)
            throw new IllegalArgumentException();
        Stack<Integer> s = new Stack<>();
        int halfSize = q.size() / 2;
        for(int i = 0; i < halfSize; i++){
            s.push(q.poll());
        }
        //insert the first half in reverse order at the end of queue
        while(!s.isEmpty())
            q.offer(s.pop());
        //remove the remaining elements till half size and add it to the same queue
        for(int i = 0; i< halfSize; i++){
            q.offer(q.poll());
        }
        //now put the first half of queue into stack
        for(int i = 0; i < halfSize; i++){
            s.push(q.poll());
        }
        //now remove one element from top of stack and one element from front of queue and keep adding to the queue.
        //that will give you the ordering
        while(!s.isEmpty()){
            q.offer(s.pop());
            q.offer(q.poll());
        }
    }
}

package solution.aritra.problem003;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Implement a stack with two queues
 * Description: offer methods add at the tail of the list
 *              poll methods remove element at the head of the list
 */
public class StackWithTwoQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public static void main(String[] args) {
        StackWithTwoQueues stack = new StackWithTwoQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Deleting " + stack.pop());
        System.out.println("Deleting " + stack.pop());
        System.out.println("Deleting " + stack.pop());
        System.out.println("Deleting " + stack.pop());
        System.out.println("Deleting " + stack.pop());
    }

    public void push(Integer data){
        if(q1.isEmpty())
            q2.offer(data);
        else
            q1.offer(data);
    }

    public int pop(){
        int i=0, size;
        if(q2.isEmpty()){
            size = q1.size();
            while(i < size-1){
                q2.offer(q1.poll());
                i++;
            }
            return q1.poll();
        }else{
            size = q2.size();
            while(i < size-1){
                q1.offer(q2.poll());
                i++;
            }
            return q2.poll();
        }
    }
}

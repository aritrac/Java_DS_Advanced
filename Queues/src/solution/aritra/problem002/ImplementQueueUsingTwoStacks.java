package solution.aritra.problem002;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Implement a queue using two stacks
 * Description: Let S1 and S2 be the two stacks to be used in the implementation of queue. All we have to do is to
 * define the enQueue and deQueue operations for the queue.
 * Algorithm:
 * If stack S2 is not empty then pop from S2 and return that element
 * If stack is empty, then transfer all elements from S1 to S2 and pop the top element from S2 and return that
 * popped element.
 * If stack S1 is also empty then throw error.
 */
public class ImplementQueueUsingTwoStacks {
    private Stack<Integer> st1 = new Stack<>();
    private Stack<Integer> st2 = new Stack<>();

    public static void main(String[] args) {
        //add 4 elements to queue
        ImplementQueueUsingTwoStacks queue1 = new ImplementQueueUsingTwoStacks();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        queue1.enqueue(4);

        //removing 2 elements
        queue1.dequeue();
        queue1.dequeue();

    }

    public void enqueue(int data){
        st1.push(data);
    }

    public int dequeue(){
        if(!st2.isEmpty()){
            return st2.pop();
        }else{
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            return st2.pop();
        }
    }
}

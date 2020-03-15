package solution.aritra.queue.implementation;

/**
 * Author: Aritra Chatterjee
 * This is the tester class for FixedSizeArrayQueue
 */
public class Tester {
    public static void main(String[] args) {
        FixedSizeArrayQueue queue = new FixedSizeArrayQueue();
        DynamicCircularArrayQueue queue2 = new DynamicCircularArrayQueue();

        //Dynamic Circular Array Queue Test
        //inserting 17 elements
        for(int i = 1; i <= 17; i++){
            queue.enqueue(i);
        }

        //printing out the queue
        System.out.println(queue);

        //deleting 15 elements from the queue
        for(int i = 1; i <= 15; i++){
            System.out.println("Deleted " + queue.dequeue());
        }

        //printing out the queue again
        System.out.println(queue);

        //Dynamic Circular Array Queue Test
        //inserting 17 elements
        for(int i = 1; i <= 17; i++){
            queue2.enQueue(i);
        }

        //printing out the queue
        System.out.println(queue2);

        //deleting 15 elements from the queue
        for(int i = 1; i <= 15; i++){
            System.out.println("Deleted " + queue2.deQueue());
        }

        //printing out the queue again
        System.out.println(queue2);
    }
}

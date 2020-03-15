package solution.aritra.queue.implementation;

/**
 * Author: Aritra Chatterjee
 * Problem: Implement a queue using a fixed sized array, but should behave like a circular queue
 */
public class FixedSizeArrayQueue {
    //Array used to implement the queue
    private int[] queueRep;
    private int size, front, rear;

    //Length of the array used to implement the queue
    private static final int CAPACITY = 16; //Default queue size

    //Initializes the queue to use an array of default length
    public FixedSizeArrayQueue(){
        queueRep = new int[CAPACITY];
        size = 0; front = 0; rear = 0;
    }

    //Initializes the queue to use an array of given length
    public FixedSizeArrayQueue(int cap){
        queueRep = new int[cap];
        size = 0; front = 0; rear = 0;
    }

    //Inserts an element at the rear of the queue. This method runs in O(1) time.
    public void enqueue(int data) throws NullPointerException{
        if(size == CAPACITY) {
            System.out.println("The queue is full");
            return;
        }else{
            size++;
            queueRep[rear] = data;
            rear = (rear + 1) % CAPACITY; //if capacity is not reached,but rear is at the end of the array,
                                          //rear points to the front of the array
        }
    }

    //Removes the front element from the queue. This method runs in O(1) time.
    public int dequeue() throws IllegalStateException{
        //Effects: if queue is empty, throw IllegalStateException
        //else remove and return oldest statement of this
        if(size == 0) {
            System.out.println("The queue is empty");
            return Integer.MIN_VALUE;
        }else{
            size--;
            int data = queueRep[front];
            queueRep[front] = Integer.MIN_VALUE;
            front = (front + 1) % CAPACITY;
            return data;
        }
    }

    //Checks whether the queue is empty. This method runs in O(1) time.
    public boolean isEmpty(){
        return (size == 0);
    }

    //Checks whether the queue is full. This method runs in O(1) time
    public boolean isFull(){
        return (size == CAPACITY);
    }

    //Returns the number of elements in the queue. This method runs in O(1) time
    public int size(){
        return size;
    }

    //Returns a string representation of the queue as a list of elements, with
    //the front element at the end.
    public String toString(){
        String result = "[";
        for(int i = 0; i < size; i++){
            result += Integer.toString(queueRep[(front + i) % CAPACITY]);
            if(i < size - 1){
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}

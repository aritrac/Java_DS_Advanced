package solution.aritra.queue.implementation;

/**
 * Author: Aritra Chatterjee
 * Problem: Design a dynamic circular array queue
 * Description: It should have better efficiency over the FixedSizeArrayQueue implementation.
 */
public class DynamicCircularArrayQueue {
    //Array used to implement the queue
    private int[] queueRep;
    private int size, front, rear;

    //length of the array used to implement the queue
    private static int CAPACITY = 16;

    public static int MINCAPACITY = 1 << 15;

    //Initializes the queue to use an array of default length
    public DynamicCircularArrayQueue(){
        queueRep = new int[CAPACITY];
        size = 0; front = 0; rear = 0;
    }

    //Initializes the queue to use an array of given length
    public DynamicCircularArrayQueue(int cap){
        queueRep = new int[CAPACITY];
        size = 0; front = 0; rear = 0;
    }

    //Inserts an element at the rear of the queue. This method runs in O(1) time.
    public void enQueue(int data) throws NullPointerException, IllegalStateException{
        if(size == CAPACITY)
            expand();
        size++;
        rear = (rear + 1) % CAPACITY;
        queueRep[rear] = data;
    }

    //Removes the front element from the queue. This method runs in O(1) time.
    public int deQueue() throws IllegalStateException{
        //Effects: If queue is empty, throw IllegalStateException
        //else remove and return oldest element of this
        if(size == 0)
            throw new IllegalStateException();
        else{
            size--;
            int data = queueRep[(front)];
            queueRep[front] = Integer.MIN_VALUE;
            front = (front + 1) % CAPACITY;
            return data;
        }
    }

    //Checks whether the queue is empty. The method runs in O(1) time.
    public boolean isEmpty(){
        return (size == 0);
    }

    //Checks whether the queue is full. This method runs in O(1) time.
    public boolean isFull(){
        return (size == CAPACITY);
    }

    //Returns the number of elements in the queue. This method runs in O(1) time.
    public int size(){
        return size;
    }

    //Increases the queue size by double
    private void expand(){
        int length = size();
        int[] newQueue = new int[length << 1];
        //copy items
        int j = 0;
        //if front > rear copy first elements till the end
        if(front > rear || size == CAPACITY) {
            for (int i = front; i < CAPACITY; i++) {
                newQueue[j++] = queueRep[i];
            }
            for(int i = 0; i<= rear; i++){
                newQueue[j++] = queueRep[i];
            }
        }else{
            for(int i = front; i <= rear; i++){
                newQueue[j++] = queueRep[i % CAPACITY];
            }
        }
        queueRep = newQueue;
        front = 0;
        rear = size - 1;
        CAPACITY *= 2;
    }

    //dynamic array operation: shrinks to 1/2 if more than 3/4 empty
    private void shrink(){
        int length = size;
        if(length <= CAPACITY || length << 2 >= length)
            return;
        if(length <= MINCAPACITY)
            length = MINCAPACITY;
        int[] newQueue = new int[length];
        System.arraycopy(queueRep,0,newQueue,0,length + 1);
        queueRep = newQueue;
    }

    //Returns a string representation of the queue as a list of elements, with the front element
    //at the end.
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

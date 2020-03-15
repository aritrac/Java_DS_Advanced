package solution.aritra.stack.fixedsizearray;

/**
 * Author: Aritra Chatterjee
 * Problem: Implement a fixed size array stack with the following operations
 * +push operation
 * +pop operation
 * +size operation
 * +isEmpty operation
 * +isFull operation
 * +peek operation
 */
public class FixedSizeArrayStack {
    //Length of the array used to implement the stack
    protected int capacity;
    //Default array capacity
    public static final int CAPACITY = 10;
    //Array used to implement the stack
    protected int[] stackRep;
    //Index of the top element of the stack in the array
    protected int top = -1;
    //Initializes the stack to use an array of default length
    public FixedSizeArrayStack(){
        this(CAPACITY); //default capacity
    }
    //Initializes the stack to use an array of given length
    public FixedSizeArrayStack(int cap){
        capacity = cap;
        stackRep = new int[capacity];
    }
    //Return the number of elements in the stack
    public int size(){
        return top + 1;
    }

    //Tests whether the stack is empty.
    public boolean isEmpty(){
        return(top < 0);
    }

    //Inserts an element at the top of the stack
    public void push(int data) throws Exception{
        if(size() == capacity)
            throw new Exception("Stack is full");
        stackRep[++top] = data;
    }

    //Inspects the element at the top of the stack
    public int top() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is empty.");
        return stackRep[top];
    }

    //Removes the top element from the stack.
    public int pop() throws Exception{
        int data;
        if(isEmpty())
            throw new Exception("Stack is empty.");
        data = stackRep[top];
        stackRep[top--] = Integer.MIN_VALUE;
        return data;
    }

    //Returns a string representation of the stack as a list of elements, with the top element at the end:
    public String toString(){
        String s;
        s = "[";
        if(size() > 0)
            s += stackRep[0];
        if(size() > 1)
            for(int i = 1; i <= size() - 1; i++){
                s += ", " + stackRep[i];
            }
        return s + "]";
    }
}

package solution.aritra.stack.dynamicsizearray;

/**
 * Author: Aritra Chatterjee
 * Description: Implement a dynamic array size stack with the following operations
 * + size()
 * + isEmpty()
 * + push()
 * + top()
 * + pop()
 * + display()
 */
public class DynamicArrayStack {
    //Length of the array used to implement the stack
    protected int capacity;
    //Default array capacity
    public static final int CAPACITY = 16;  //power of 2
    public static int MINCAPACITY = 1<<15; //power of 2
    //Array used to implement the stack
    protected int[] stackRep;
    //Index of the top element of the stack in the array
    protected int top = -1;
    //Initializes the stack to use an array of default length
    public DynamicArrayStack(){
        this(CAPACITY);
    }
    //Initializes the stack to use an array of given length
    public DynamicArrayStack(int cap){
        capacity = cap;
        stackRep = new int[capacity];
    }
    //Returns the number of elements in the stack.
    public int size(){
        return (top + 1);
    }
    //Tests whether the stack is empty.
    public boolean isEmpty(){
        return top < 0;
    }
    //Inserts an element at the top of the stack.
    public void push(int data)throws Exception{
        if(size() == capacity)
            expand();
        stackRep[++top] = data;
    }

    private void expand(){
        int length = size();
        int[] newStack = new int[length << 1]; //doubling the stack size. If length is 4, then it will now be 8
        System.arraycopy(stackRep,0,newStack,0,length);
        stackRep = newStack;
        this.capacity = this.capacity << 1; //doubling the capacity. If capacity is 4, then it will now be 8
    }

    //dynamic array operation: shrinks to 1/2 if more than 3/4th is empty
    private void shrink(){
        int length = top + 1;
        if(length <= MINCAPACITY || top << 2 >= length)
            return;
        length = length + (top << 1); //still means shrink at 1/2 or less of the stack size
        if(top < MINCAPACITY)
            length = MINCAPACITY;
        int[] newStack = new int[length];
        System.arraycopy(stackRep,0,newStack,0,top+1);
        stackRep = newStack;
        this.capacity = length;
    }

    //inspects the element at the top of the stack.
    public int top() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is empty");
        return stackRep[top];
    }

    //Removes the top element from the stack. This method runs in O(1) time.
    public int pop() throws Exception{
        int data;
        if(isEmpty())
            throw new Exception("Stack is empty.");
        data = stackRep[top];
        stackRep[top--] = Integer.MIN_VALUE; //dereference S[top] for garbage collection
        shrink();
        return data;
    }

    //Returns a string representation of the stack as a list of elements with
    //the top element at the end
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

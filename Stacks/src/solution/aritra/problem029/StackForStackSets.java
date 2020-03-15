package solution.aritra.problem029;

/**
 * Author: Aritra Chatterjee
 * Problem: If the stack gets too high, it might overbalance. Therefore in real life, we would likely start a new stack
 * when the previous stack exceeds some threshold. Implement a data structure that mimics this and composed of several
 * stacks, and should create a new stack once the previous one exceeds capacity. push() and pop() of this class
 * should behave identically to a regular stack.
 */
public class StackForStackSets {
    private int top = -1;
    private int[] arr;
    //maximum size of stack
    private int capacity;

    StackForStackSets(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void push(int v){
        arr[++top] = v;
    }

    public int pop(){
        return arr[top--];
    }

    //if the stack is at capacity
    public boolean isAtCapacity(){
        return capacity == top + 1;
    }

    //return the size of the stack
    public int size(){
        return top + 1;
    }

    public String toString(){
        String s = "";
        int index = top;
        while(index >= 0){
            s += "[" + arr[index--] + "]" + "-->";
        }
        return s;
    }
}

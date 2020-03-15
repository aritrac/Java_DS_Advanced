package solution.aritra.stack.stackusinglinkedlist;

import solution.aritra.stack.utils.node.defs.ListNode;

import java.util.EmptyStackException;

/**
 * Author: Aritra Chatterjee
 * Description: Using a single linked list implement a stack
 * Push operation is implemented by inserting at the beginning of the linked list
 * Pop operation is implemented by deleting at the beginning of the linked list
 */
public class LinkedStack {
    private int length; //indicates the size of the linked list
    private ListNode top;
    //Constructor: Creates an empty stack
    public LinkedStack(){
        length = 0;
        top = null;
    }
    //Adds the specified data to the top or head of this stack
    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.setNext(top);
        top = temp;
        length++;
    }

    //Removes the data at the top of this stack and returns a
    //reference to it. Throws an EmptyStackException if the stack
    //is empty.
    public int pop() throws EmptyStackException{
        if(isEmpty())
            throw new EmptyStackException();
        int result = top.getData();
        top = top.getNext();
        length--;
        return result;
    }

    //Returns a reference to the data at the top of this stack
    //The data is not removed from this stack. Throws an
    //EmptyStackException if the stack is empty
    public int peek() throws EmptyStackException{
        if(isEmpty())
            throw new EmptyStackException();
        return top.getData();
    }

    //Returns true if this stack is empty and false otherwise
    public boolean isEmpty(){
        return (length == 0);
    }

    //Returns the number of elements in the stack
    public int size(){
        return length;
    }

    //Returns a string representation of this stack
    public String toString(){
        String result = "\n[";
        ListNode current = top;
        while(current != null){
            result = result + current.getData() + " ";
            current = current.getNext();
        }
        return result + "]";
    }
}
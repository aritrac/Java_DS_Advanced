package solution.aritra.problem014;

import java.util.EmptyStackException;

/**
 * Author: Aritra Chatterjee
 * Problem: Implement two stacks in one array. Our stack routines should not throw exception unless every slot in
 * the array is used.
 * Description:
 * ->Start two indexes one at the left end and the other at the right end.
 * ->The left index simulates the first stack and the right index simulates the second stack.
 * ->If we want to push an element into the first stack then put the element at the left index.
 * ->Similarly if we want to push an element into the second stack then put the element at the right index.
 * ->The first stack grows towards the right, and the second stack grows towards the left.
 */

public class TwoStacksUsingOneArray {
    private int[] dataArray;
    private int size, topOne, topTwo;
    public TwoStacksUsingOneArray(int size){
        if(size < 2)
            throw new IllegalStateException("size < 2 is not permissible");
        dataArray = new int[size];
        this.size = size;
        topOne = -1;
        topTwo = size;
    }

    public void push(int stackId, int data){
        if(topTwo == topOne + 1) {
            System.out.println("Stack is full.");
            return;
        }
        if(stackId == 1){
            dataArray[++topOne] = data;
        }else if(stackId == 2){
            dataArray[--topTwo] = data;
        }else
            return;
    }

    public int pop(int stackId){
        if(stackId == 1){
            if(topOne == -1) {
                System.out.println("Stack 1 is empty");
                return Integer.MIN_VALUE;
            }
            int toPop = dataArray[topOne];
            dataArray[topOne--] = Integer.MIN_VALUE;
            return toPop;
        }else if(stackId == 2){
            if(topTwo == this.size){
                System.out.println("Stack 2 is empty");
                return Integer.MIN_VALUE;
            }
            int toPop = dataArray[topTwo];
            dataArray[topTwo++] = Integer.MIN_VALUE;
            return toPop;
        }else
            return Integer.MIN_VALUE;
    }

    public int top(int stackId){
        if(stackId == 1){
            if(topOne == -1) {
                System.out.println("Stack 1 is empty");
                return Integer.MIN_VALUE;
            }
            return dataArray[topOne];
        }else if(stackId == 2){
            if(topTwo == this.size) {
                System.out.println("Stack 2 is empty");
                return Integer.MIN_VALUE;
            }
            return dataArray[topTwo];
        }else
            return Integer.MIN_VALUE;
    }

    public boolean isEmpty(int stackId){
        if(stackId == 1)
            return topOne == -1;
        else if(stackId == 2){
            return topTwo == this.size;
        }else
            return true;
    }
}
package solution.aritra.problem001;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Description: We will try to build a stack with a single linked list
 */
public class StackWithLinkedList {
    LinkedList customStack;
    ListNode head;
    int length;

    public static void main(String[] args) {
        StackWithLinkedList stack = new StackWithLinkedList(10);
        for(int i = 0; i < 12; i++){
            stack.pushToStack(i + 20);
        }
        stack.displayStackContents();
        for(int i = 0; i < 12; i++){
            int data = stack.popFromStack();
            System.out.println("deleted data: " + data);
        }
    }

    StackWithLinkedList(int size){
        //Initialize the stack
        customStack = new LinkedList();
        length = size;
    }

    public void pushToStack(int data){
        if(isStackFull()){
            System.out.println("pushToStack: stack capacity reached. Cannot insert");
            return;
        }
        //push an element onto the stack
        ListNode newDataNode = new ListNode(data);
        customStack.insertAtEnd(newDataNode);
        System.out.println("pushToStack: inserted the data successfully into stack");
    }

    public int popFromStack(){
        if(isStackEmpty()){
            System.out.println("popFromStack: stack is empty. Cannot delete");
            return Integer.MAX_VALUE;
        }
        //pop an element from the stack
        ListNode poppedDataNode = customStack.removeFromEnd();
        System.out.println("popFromStack: deleted the data successfully from stack");
        return poppedDataNode.getData();
    }

    public boolean isStackFull(){
        return customStack.length() >= length;
    }

    public boolean isStackEmpty(){
        return customStack.length() < 1;
    }

    public void displayStackContents(){
        System.out.println(customStack);
    }
}

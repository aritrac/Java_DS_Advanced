package solution.aritra.problem012;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

import java.util.Random;

/**
 * Author: Aritra Chatterjee
 * Description: Check whether the given linked list is NULL terminated or not. If there is a cycle find the start node of the loop
 */
public class GetStartOfCycleInLinkedList {
    public static void main(String[] args) {
        GenerateSLL newSLLGen = new GenerateSLL();
        LinkedList sll = newSLLGen.createSLL(10);
        System.out.println(sll);

        //generate start of cycle position
        int startOfCycleIndex = new Random().nextInt(10);

        //navigate to start of cycle node
        int index = 1;
        ListNode startOfCycleNode = sll.getHead();
        while(index < startOfCycleIndex){
            startOfCycleNode = startOfCycleNode.getNext();
            index++;
        }

        System.out.println("startOfCycleIndex = " + startOfCycleIndex);
        System.out.println("startOfCycleNode = " + startOfCycleNode.getData());
        System.out.println("Before cycle creation: isCyclePresent? " + isCyclePresent(sll));

        //get the lastnode in the SLL
        ListNode temp = sll.getHead();
        while(temp.getNext() != null)
            temp = temp.getNext();

        //create cycle
        temp.setNext(startOfCycleNode);

        //now check if cycle is present using a fast pointer slow pointer approach
        System.out.println("After cycle creation: isCyclePresent? " + isCyclePresent(sll));
        if(isCyclePresent(sll)){ //print the node data at the start of the cycle
            System.out.println("start of cycle is at " + getCycleStartNodeData(sll).getData());
        }
    }

    public static boolean isCyclePresent(LinkedList sll){
        ListNode slowPtr = sll.getHead(), fastPtr = sll.getHead();
        while(slowPtr != null && fastPtr.getNext().getNext() != null){ //making sure that atleast two nodes are infront of the first pointer
            fastPtr = fastPtr.getNext().getNext();                     //to avoid the null pointer exception
            slowPtr = slowPtr.getNext();
            if(slowPtr == fastPtr)
                return true;
        }
        return false;
    }

    public static ListNode getCycleStartNodeData(LinkedList sll){
        ListNode slowPtr = sll.getHead();
        ListNode fastPtr = sll.getHead();
        while(slowPtr != null && fastPtr.getNext().getNext() != null){
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
            if(slowPtr == fastPtr){ //cycle detected, now find the start of the cycle
                slowPtr = sll.getHead();
                while(slowPtr != fastPtr){
                    slowPtr = slowPtr.getNext();
                    fastPtr = fastPtr.getNext();
                }
                return slowPtr;
            }
        }
        return null;
    }
}

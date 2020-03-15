package solution.aritra.problem010;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;
import java.util.Random;

/**
 * Author: Aritra Chatterjee
 * Description: Check if a cycle exists in a linked list using the slow and fast pointer approach
 */
public class CheckCycleInALinkedList {
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

        //now check if cycle is present using a hash table
        System.out.println("After cycle creation: isCyclePresent? " + isCyclePresent(sll));
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
}

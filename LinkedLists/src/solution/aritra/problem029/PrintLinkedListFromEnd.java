package solution.aritra.problem029;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Description: Print a linked list from the end which is single linked list in nature
 */
public class PrintLinkedListFromEnd {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSLL(10);

        //printing out the list
        System.out.println(sll);

        //now we will print list in reverse
        printListInReverse(sll.getHead());
    }

    public static void printListInReverse(ListNode head){
        if(head == null)
            return;
        printListInReverse(head.getNext());
        System.out.print(head.getData() + " ");
    }
}

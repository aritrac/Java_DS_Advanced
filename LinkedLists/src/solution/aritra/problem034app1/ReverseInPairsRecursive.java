package solution.aritra.problem034app1;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Decription: Reverse a linked list in pairs using a recursive solution. For example if the list is
 * 1 -> 2 -> 3 -> 4 -> X then after the method it should be like
 * 2 -> 1 -> 4 -> 3 -> X
 */
public class ReverseInPairsRecursive {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSortedSLL(10);
        //printing out the initial list
        System.out.println(sll);

        //reversing in pairs
        sll.setHead(reverseListInPairs(sll.getHead()));

        //printing out the list after reversal
        System.out.println(sll);
    }

    public static ListNode reverseListInPairs(ListNode head){
        if(head == null || head.getNext() == null) //handling even and odd number of nodes
            return head;
        ListNode temp = head.getNext();
        head.setNext(temp.getNext());
        temp.setNext(head);
        head = temp;

        //call the method recursively for the rest of the list
        head.getNext().setNext(reverseListInPairs(head.getNext().getNext()));
        return head;
    }
}

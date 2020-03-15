package solution.aritra.problem057;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a list, rotate the list to the right by k places, where k is non negative. For example,
 * given 1->2->3->4->5->null and k is 2, return 4->5->1->2->3->null
 * Description: Use two different pointer rotateStart and rotateEnd, to determine the new head and tail of the list
 */

public class RotateRightLinkedList {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSLL(10);
        //lets rotate the list by 4 places
        int k = 4;
        System.out.println("Before rotation");
        System.out.println(sll);
        ListNode newHead = rotateListRight(sll.getHead(),k);
        while(newHead != null){
            System.out.print(" " + newHead.getData());
            newHead = newHead.getNext();
        }
        System.out.println();
    }

    public static ListNode rotateListRight(ListNode head, int k){
        if(head == null || head.getNext() == null)
            return head;
        ListNode rotateStart = head;
        ListNode rotateEnd = head;
        while(k-- > 0){
            rotateEnd = rotateEnd.getNext();
            if(rotateEnd == null)//end of list reached, set it to head and continue
                rotateEnd = head;
        }
        if(rotateStart == rotateEnd) //if after rotation, start and end is the same, then return head
            return head;
        while(rotateEnd.getNext() != null){ //until rotateEnd reaches the end of the list,increment both start and end
            rotateEnd = rotateEnd.getNext();
            rotateStart = rotateStart.getNext();
        }
        ListNode newHead = rotateStart.getNext();
        rotateEnd.setNext(head);
        rotateStart.setNext(null);
        return newHead;
    }
}

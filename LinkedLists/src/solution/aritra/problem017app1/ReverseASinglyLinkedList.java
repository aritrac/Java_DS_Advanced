package solution.aritra.problem017app1;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Description: Using iteration without recursion, reverse a singly linked list
 */
public class ReverseASinglyLinkedList {
    public static void main(String[] args) {
        GenerateSLL newSll = new GenerateSLL();
        LinkedList sll = newSll.createSLL(10);
        System.out.println(sll);
        ListNode head = reverseList(sll);

        //print out the reversed list
        ListNode temp = head;
        System.out.print("[");
        while(temp != null){
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.print("]\n");
    }

    public static ListNode reverseList(LinkedList sll){
        ListNode current = sll.getHead();
        ListNode prev = null;
        while(current != null){
            //save the next node
            ListNode next = current.getNext();
            //Make current node point to the previous
            current.setNext(prev);
            //update previous to point to current node
            prev = current;
            //update current to point to the next node
            current = next;
        }
        //prev will now point to the initial lists tail node, which will now serve as the head
        return prev;
    }
}

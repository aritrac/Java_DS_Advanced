package solution.aritra.problem054app2;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a singly linked list L1->L2->L3->L4->L5, reorder it to L1->L5->L2->L4->L3.
 * Description: We divide the list in two parts for instance 1->2->3->4->5 will become 1->2->3 and 4->5,we
 * have to reverse the second list and give a list that alternates both. The split is done with a slow and fast pointer.
 */
public class ReorderSinglyLinkedList {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSLL(20);
        //printing out the list
        System.out.println(sll);
        //reordering the list
        reorderList(sll.getHead());
        //printing out the reordered list
        System.out.println(sll);
    }

    public static void reorderList(ListNode head){
        if(head == null)
            return;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while(fastPointer != null && fastPointer.getNext()!= null){
            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();
        }
        ListNode head2 = slowPointer.getNext(); //start of the second list
        slowPointer.setNext(null); //split the list into two halves by disconnecting the middle node
        head2 = reverseList(head2);
        alternate(head,head2);
    }

    public static ListNode reverseList(ListNode head){
        if(head == null)
            return null;
        ListNode reversedList = head;
        ListNode pointer = head.getNext();
        reversedList.setNext(null);
        while(pointer != null){
            ListNode temp = pointer;
            pointer = pointer.getNext();
            temp.setNext(reversedList);
            reversedList = temp;
        }
        return reversedList;
    }

    public static void alternate(ListNode head1, ListNode head2){
        ListNode pointer = head1;
        head1 = head1.getNext();
        boolean nextList1 = false; //this serves as a toggle to copy alternate elements
        while(head1 != null || head2 != null) {
            if ((head2 != null && !nextList1) || head1 == null) {
                pointer.setNext(head2);
                head2 = head2.getNext();
                nextList1 = true;
                pointer = pointer.getNext();
            } else {
                pointer.setNext(head1);
                head1 = head1.getNext();
                nextList1 = false;
                pointer = pointer.getNext();
            }
        }
    }
}

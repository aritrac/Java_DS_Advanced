package solution.aritra.problem063;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a linked list with even and odd numbers, create an algorithm for making changes to the list in
 * such a way that all even numbers appear at the beginning.
 * Solution: To split the linked list, traverse the original list and move all odd nodes to a separate linked list of
 * all odd nodes. At the end of the loop, the original list will have all the even nodes and the odd node list will have
 * all the odd nodes. To keep the ordering of all nodes the same, we must insert all the odd nodes at the end of the
 * odd node list.
 */
public class PartitionEvenOddInList {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSLL(10);
        System.out.println("Before partitioning");
        System.out.println(sll);
        System.out.println("After partitioning");
        ListNode head = partitionEvenOdd(sll.getHead());
        while(head != null){
            System.out.print(" " + head.getData());
            head = head.getNext();
        }
        System.out.println();
    }
    public static ListNode partitionEvenOdd(ListNode head){
        if(head == null || head.getNext() == null)
            return head;
        ListNode oddHead = new ListNode(0);
        ListNode oddPointer = oddHead;
        ListNode curr = head;
        ListNode prev = head;
        while(curr.getNext() != null){
            ListNode next = curr.getNext();
            if(curr.getData() % 2 != 0){ //Odd node
                if(head == curr) { //first node itself has to be moved to other list
                    head = curr.getNext();
                }else {
                    prev.setNext(next);
                }
                //inserting into the other odd list
                oddPointer.setNext(curr);
                oddPointer = curr;
                oddPointer.setNext(null);
            }else {
                prev = curr; //prev should always point to even node,not to a node which will go out to odd list
            }
            curr = next;
        }
        curr.setNext(oddHead.getNext());
        return head;
    }
}

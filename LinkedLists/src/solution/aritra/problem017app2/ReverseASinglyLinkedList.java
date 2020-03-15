package solution.aritra.problem017app2;

/**
 * Author: Aritra Chatterjee
 * Description: Reversing a singly linked list using recursive approach
 */

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

import java.util.List;

public class ReverseASinglyLinkedList {
    public static void main(String[] args) {
        GenerateSLL newSll = new GenerateSLL();
        LinkedList sll = newSll.createSLL(10);
        System.out.println(sll);
        ListNode head = reverseList(null, sll.getHead()); //using the recursive version

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

    public static ListNode reverseList(ListNode prev, ListNode current){
        if(current == null){
            return null;
        }
        ListNode next = current.getNext();
        if(next == null){ //the sentinel condition from which recursion ends
            current.setNext(prev);
            prev = current;
            return prev;
        }
        current.setNext(prev); //make current point to prev
        //make prev = current and current = next for the next recursive call
        return reverseList(current,next);
    }
}

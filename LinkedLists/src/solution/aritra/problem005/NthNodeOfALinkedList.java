package solution.aritra.problem005;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.ListNode;

import java.util.List;

/**
 * Author: Aritra Chatterjee
 * Problem: Find the nth node from the last of a linked list using two pointers
 */
public class NthNodeOfALinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtBegin(new ListNode(24));
        list.insertAtBegin(new ListNode(25));
        list.insertAtBegin(new ListNode(26));
        list.insertAtBegin(new ListNode(27));
        list.insertAtBegin(new ListNode(28));
        list.insertAtBegin(new ListNode(29));
        list.insertAtBegin(new ListNode(30));
        int N = 3;
        System.out.println("The Nth node from the end contains " + NthNodeFromEnd(list.getHead(),N).getData());
    }

    public static ListNode NthNodeFromEnd(ListNode head, int NthNode){
        ListNode pTemp = head, pNthNode = null;
        //advancing the first pointer N places to the right
        for(int count = 1; count < NthNode; count++){
            if(pTemp != null)
                pTemp = pTemp.getNext();
        }
        while(pTemp != null){
            //now advance the second pointer, till the first one reaches the end
            if(pNthNode == null)
                pNthNode = head;
            else
                pNthNode = pNthNode.getNext();
            pTemp = pTemp.getNext();
        }
        if(pNthNode != null)
            return pNthNode; //this is the Nth node from the end
        return null;
    }
}

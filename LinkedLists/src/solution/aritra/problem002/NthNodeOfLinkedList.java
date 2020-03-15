package solution.aritra.problem002;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Find nth node from the end of the list
 */
public class NthNodeOfLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtBegin(new ListNode(23));
        linkedList.insertAtBegin(new ListNode(24));
        linkedList.insertAtBegin(new ListNode(33));
        linkedList.insertAtBegin(new ListNode(45));
        linkedList.insertAtBegin(new ListNode(10));
        linkedList.insertAtBegin(new ListNode(89));
        linkedList.insertAtBegin(new ListNode(100));

        int lengthOfList = linkedList.length();
        int N = 2; //find the 2nd node from the end
        System.out.println(lengthOfList);
        if(N > lengthOfList) {
            System.out.println("The list contains fewer nodes");
            return;
        }

        ListNode head = linkedList.getHead();
        for(int i = 0; i < lengthOfList - N; i++){
            head = head.getNext();
        }
        System.out.println("The Nth node contains " + head.getData());
    }
}

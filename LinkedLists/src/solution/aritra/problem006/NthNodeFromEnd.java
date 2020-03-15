package solution.aritra.problem006;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Find the Nth node from the end of the list using recursion and 2 pointers
 */
public class NthNodeFromEnd {
    public static int counter = 0;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtBegin(new ListNode(20));
        list.insertAtBegin(new ListNode(21));
        list.insertAtBegin(new ListNode(22));
        list.insertAtBegin(new ListNode(23));
        list.insertAtBegin(new ListNode(24));
        list.insertAtBegin(new ListNode(25));
        list.insertAtBegin(new ListNode(26));

        int N = 3;
        NthNodeFromEnd(list.getHead(),N);
    }

    public static void NthNodeFromEnd(ListNode head, int Nth){
        if(head != null){
            NthNodeFromEnd(head.getNext(), Nth); //go to the last node recursively
            //count is increased while returning back from the last node
            counter++;
            if(Nth == counter){
                System.out.println("The nth node from the last = " + head.getData());
            }
        }
    }
}

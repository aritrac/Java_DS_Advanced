package solution.aritra.problem048;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a singly linked list, find the kth node from the end of the list. The value of length of list is
 * unknown. If the value of k = 3 in a list of length 19, then the method returns the 16th node
 */
public class FindKthNodeFromTheEndInList {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSLL(19);
        int k = 3;
        //printing out the list
        System.out.println(sll);
        System.out.println("The kth node from the last is " + findKthNodeFromLast(sll.getHead(),k).getData());
    }

    public static ListNode findKthNodeFromLast(ListNode head, int k){
        if(k <= 0)
            return null;
        ListNode modularNode = head;
        //advancing head pointer k steps to the right
        for(int i = 0; i < k; i++){
            if(head != null)
                head = head.getNext();
        }

        //now advancing both head and modular node pointer 1 step at a time
        while(head != null){
            modularNode = modularNode.getNext();
            head = head.getNext();
        }
        return modularNode;
    }
}

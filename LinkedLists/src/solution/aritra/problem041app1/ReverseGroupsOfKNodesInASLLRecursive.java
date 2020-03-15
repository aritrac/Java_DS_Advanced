package solution.aritra.problem041app1;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: For a given K value, reverse blocks of K nodes in a list
 * Description: This is an extension of swapping nodes in a linked list
 * 1)Check if remaining list has k nodes
 *      a)if yes get the pointer for the k+1 node
 *      b)else return
 * 2)Reverse first K nodes
 * 3)Set next of last node (after reversal) to K + 1 node.
 * 4)Move to K + 1 node
 * 5)Goto step1
 * 6)K-1 node of first K nodes becomes the new head if available,Otherwise we can return the head
 */
public class ReverseGroupsOfKNodesInASLLRecursive {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSLL(10);
        System.out.println("Before reversal:");
        System.out.println(sll);
        ListNode newHead = reverseKNodesRecursive(sll.getHead(),3);
        ListNode newTmp = newHead;
        System.out.println("After reversal:");
        while(newTmp != null){
            System.out.print(newTmp.getData() + " ");
            newTmp = newTmp.getNext();
        }
    }

    public static ListNode reverseKNodesRecursive(ListNode head, int k){
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        int count = k;
        //Reverse K nodes
        while(current != null && count > 0){ //if list has sufficient nodes and has not ended
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count--;
        }
        //Now next points to K+1th node, returns the pointer to the head node
        if(next != null){
            head.setNext(reverseKNodesRecursive(next,k));
        }
        //return head node
        return prev;
    }
}

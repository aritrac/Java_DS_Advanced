package solution.aritra.problem040;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Exchange the adjacent elements in a linked list
 * Description:
 */
public class ExchangeAdjacentNodes {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSLL(10);
        System.out.println(sll);
        ListNode newHead = exchangeAdjacentNodes(sll.getHead());
        //printing out the new list
        ListNode tempHead = newHead;
        while(tempHead != null){
            System.out.print(tempHead.getData() + " ");
            tempHead = tempHead.getNext();
        }
    }

    public static ListNode exchangeAdjacentNodes(ListNode head){
        ListNode temp = new ListNode(0);
        temp.setNext(head);
        ListNode prev = temp;
        ListNode curr = head;
        while(curr != null && curr.getNext() != null){ //For even and odd list check
            ListNode tmp = curr.getNext().getNext();
            curr.getNext().setNext(prev.getNext());
            prev.setNext(curr.getNext());//this is where the new head of the list gets assigned
            curr.setNext(tmp);
            prev = curr;
            curr = prev.getNext();
        }
        return temp.getNext();
    }
}

package solution.aritra.problem054app1;

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
        reorderList(sll.getHead());
        //printing out the new list
        System.out.println(sll);
    }

    public static void reorderList(ListNode head){
        if(head == null)
            return ;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        //finding the middle of the list
        while(fastPointer != null && fastPointer.getNext().getNext() != null){
            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();
        }
        //printing the middle of the list
        //System.out.println("Middle of list = " + slowPointer.getData());
        ListNode head2 = slowPointer.getNext(); //this is the start of the second list
        slowPointer.setNext(null); //split the list in half by disconnecting at middle

        //now reversing the second list pointed by head2
        java.util.LinkedList<ListNode> queue = new java.util.LinkedList<ListNode>(); //creating a stack for list reversal
        while(head2 != null){
            ListNode temp = head2;
            head2 = head2.getNext();
            temp.setNext(null);
            queue.push(temp);
        }

        //now reading the elements in reverse order and putting it as alternating sequence into list1
        while(!queue.isEmpty()){
            ListNode temp = queue.pop();
            temp.setNext(head.getNext());
            head.setNext(temp);
            head = temp.getNext();
        }
    }
}

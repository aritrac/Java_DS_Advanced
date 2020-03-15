package solution.aritra.problem032;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Description: Given two sorted linked lists, we need to merge them into the third list in sorted order
 * using recursion
 */
public class MergeSortedLinkedLists {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll1 = listGen.createSortedSLL(10);
        LinkedList sll2 = listGen.createSortedSLL(12);

        //print out the first list
        System.out.println(sll1);
        //print out the second list
        System.out.println(sll2);

        //now merge the two lists above
        ListNode head3 = mergeTwoLists(sll1.getHead(),sll2.getHead());

        while(head3 != null){
            System.out.print(head3.getData() + " ");
            head3 = head3.getNext();
        }
    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2){
        if(head1 == null)
            return head2; //remaining portion of head2 becomes the remaining part of the merged list
        if(head2 == null)
            return head1; //remaining portion of head1 becomes the remaining part of the merged list
        ListNode head3 = null;
        if(head1.getData() < head2.getData()){
            head3 = head1;
            head3.setNext(mergeTwoLists(head1.getNext(),head2)); //progress the head1 list to move to the next element
        }else{
            head3 = head2;
            head3.setNext(mergeTwoLists(head2.getNext(),head1)); //progress the head2 list to move to the next element
        }
        return head3;
    }
}

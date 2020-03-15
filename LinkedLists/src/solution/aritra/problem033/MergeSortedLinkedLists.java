package solution.aritra.problem033;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Description: Merge two sorted linked lists using iterative approach
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
        ListNode head3 = new ListNode(0);
        ListNode curr = head3;
        while(head1 != null && head2 != null){
            if(head1.getData() <= head2.getData()){
                curr.setNext(head1);
                head1 = head1.getNext();
            }else{
                curr.setNext(head2);
                head2 = head2.getNext();
            }
            curr = curr.getNext();
        }
        if(head1 != null)
            curr.setNext(head1);
        else if(head2 != null)
            curr.setNext(head2);
        return head3;
    }
}

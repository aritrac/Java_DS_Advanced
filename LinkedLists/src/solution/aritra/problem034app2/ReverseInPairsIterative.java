package solution.aritra.problem034app2;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

public class ReverseInPairsIterative {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSortedSLL(10);
        //printing out the initial list
        System.out.println(sll);

        //reversing in pairs
        sll.setHead(reverseListInPairs(sll.getHead()));

        //printing out the list after reversal
        System.out.println(sll);
    }

    public static ListNode reverseListInPairs(ListNode head){
        ListNode temp1 = null;
        ListNode temp2 = null;
        while(head != null && head.getNext() != null){ //check for odd and even length list
            if(temp1 != null){
                temp1.getNext().setNext(head.getNext()); //making the nth node point to n+2 node for maintaining proper
                                                         //node links between every two nodes groups like group1 (1,2) and group2 (3,4)
                                                         //group1 -> group2
            }
            temp1 = head.getNext();
            head.setNext(temp1.getNext());
            temp1.setNext(head);
            if(temp2 == null) //keeping the new start of the list in temp2, this will only run once
                temp2 = temp1;
            head = head.getNext();
        }
        return temp2;
    }
}

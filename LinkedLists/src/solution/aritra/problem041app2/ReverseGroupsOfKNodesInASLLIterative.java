package solution.aritra.problem041app2;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

public class ReverseGroupsOfKNodesInASLLIterative {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSLL(10);
        System.out.println("Before reversal:");
        System.out.println(sll);
        ListNode newHead = reverseKNodesIterative(sll.getHead(),3);
        ListNode newTmp = newHead;
        System.out.println("After reversal:");
        while(newTmp != null){
            System.out.print(newTmp.getData() + " ");
            newTmp = newTmp.getNext();
        }
    }

    public static ListNode reverseKNodesIterative(ListNode head, int k){
        //Start with head
        ListNode current = head;
        //last node after reverse
        ListNode prevTail = null; //last value of previous node for the previous block
        //first node before reverse
        ListNode prevCurrent = head; //last value of current node for the previous block
        while(current != null){
            //loop for reversing K nodes
            int count = k;
            ListNode tail = null; //the previous node while reversal
            while(current != null && count > 0){
                ListNode next = current.getNext();
                current.setNext(tail); //here tail represents the previous node
                tail = current;
                current = next;
                count--;
            }
            //reversed K nodes
            if(prevTail != null){
                //Link this set and previous set
                prevTail.setNext(tail); //attach the previous block with this newly reversed block
            }else{
                //We just reversed first set of k nodes, update head point to the kth node
                head = tail;
            }
            //save the last node after reverse since we need to connect to the next set
            prevTail = prevCurrent;
            //save the current node, which will become the last node after reverse
            prevCurrent = current;
        }
        return head;
    }
}

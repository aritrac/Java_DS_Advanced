package solution.aritra.problem030;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Description: Check whether the given linked list length is even or odd
 */
public class FindEvenOrOddLengthOfLinkedList {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sllEven = listGen.createSLL(10); //even length list
        LinkedList sllOdd = listGen.createSLL(9);   //odd length list

        if(isEvenLengthList(sllEven.getHead())){
            System.out.println("The list is of even length");
        }else{
            System.out.println("The list is of odd length");
        }

        if(isEvenLengthList(sllOdd.getHead())){
            System.out.println("The list is of even length");
        }else{
            System.out.println("The list is of odd length");
        }
    }

    public static boolean isEvenLengthList(ListNode head){
        while(head != null && head.getNext() != null){ //taking care of both even and odd scenario
            head = head.getNext().getNext();
            if(head == null)
                return true;
        }
        return false;
    }
}

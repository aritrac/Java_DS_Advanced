package solution.aritra.problem038;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Split a circular linked list into two equal parts. If the number of nodes in the list are odd, then
 * make the first list one node extra than second list
 * Solution: Store the mid and last pointers of the circular linked list using Floyd cycle finding algorithm.
 * Make the second half circular
 * Make the first half circular
 * Set head pointers of the two linked lists
 */
public class SplitCircularLinkedList {
    private static ListNode head1;
    private static ListNode head2;

    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        //Creating a single linked list
        LinkedList sll = listGen.createSLL(11); //change this number while running for odd and even length list
                                                   //test
        System.out.println(sll);
        //making the SLL to CLL

        ListNode temp = sll.getHead();
        //go till the last node
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(sll.getHead()); //making the last node point to the start node
        splitList(sll.getHead());
        //print list1
        ListNode tempNode = head1;
        while(tempNode.getNext() != head1){
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.getNext();
        }
        System.out.println(tempNode.getData()); //printing the last element in the list
        //print list2
        tempNode = head2;
        while(tempNode.getNext() != head2){
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.getNext();
        }
        System.out.println(tempNode.getData()); //printing the last element in the list
    }

    public static void splitList(ListNode head){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        if(head == null)
            return;
        //If there are odd nodes in the circular list then fastPtr.getNext() becomes
        //head and for even nodes fastPtr.getNext().getNext() becomes head
        while(fastPtr.getNext() != head && fastPtr.getNext().getNext() != head){
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
        }
        //if there are even elements in the list then move fastPtr
        if(fastPtr.getNext().getNext() == head)
            fastPtr = fastPtr.getNext();
        //set the head pointer of the first half
        head1 = head;
        //set the head pointer of the second half
        if(head.getNext() != head) //if there are more than 1 element in the list
            head2 = slowPtr.getNext();
        //make second half circular
        fastPtr.setNext(head2);
        //make first half circular
        slowPtr.setNext(head);
    }
}

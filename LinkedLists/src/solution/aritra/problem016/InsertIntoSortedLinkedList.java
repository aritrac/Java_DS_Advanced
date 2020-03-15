package solution.aritra.problem016;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Description: We will try to insert a node into a sorted linked list
 */
public class InsertIntoSortedLinkedList {
    public static void main(String[] args) {
        GenerateSLL sll = new GenerateSLL();
        LinkedList sllList = sll.createSortedSLL(10);
        System.out.println(sllList); //print out the sorted SLL before insertion

        int newData = 57;
        ListNode newNode = new ListNode(57);
        insertIntoSortedList(newNode, sllList);

        System.out.println("Node to be inserted = " + newNode.getData());

        System.out.println(sllList); //print out the sorted SLL after insertion
    }

    public static void insertIntoSortedList(ListNode newNode, LinkedList sll){
        ListNode temp = sll.getHead();
        ListNode prev = sll.getHead();
        while(temp.getNext() != null){
            if(temp.getData() >= newNode.getData()) { //insert the new node before the temp node
                prev.setNext(newNode);
                newNode.setNext(temp);
                break;
            }
            prev = temp;
            temp = temp.getNext();
        }
    }
}

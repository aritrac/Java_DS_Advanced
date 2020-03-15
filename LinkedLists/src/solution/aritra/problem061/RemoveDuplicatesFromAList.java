package solution.aritra.problem061;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an unordered linked list, remove the duplicates from the list
 */
public class RemoveDuplicatesFromAList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(new ListNode(2));
        list.insertAtEnd(new ListNode(8));
        list.insertAtEnd(new ListNode(1));
        list.insertAtEnd(new ListNode(1));
        list.insertAtEnd(new ListNode(2));
        list.insertAtEnd(new ListNode(8));
        list.insertAtEnd(new ListNode(2));
        list.insertAtEnd(new ListNode(8));
        list.insertAtEnd(new ListNode(2));
        System.out.println("Before duplicate removal");
        System.out.println(list);
        removeDuplicates(list.getHead());
        System.out.println("After duplicate removal");
        System.out.println(list);
    }

    public static void removeDuplicates(ListNode head){
        ListNode curr = head;
        if(curr == null || curr.getNext() == null){
            return; //0 or 1 nodes in the list so no duplicates
        }
        ListNode curr2;
        ListNode prev;
        while(curr != null){
            curr2 = curr.getNext();
            prev = curr;
            while(curr2 != null){ //go till the end deleting duplicates starting from node pointed by curr
                //check and see if curr and curr2 values are the same, if they are then delete curr2
                if(curr.getData() == curr2.getData()){
                    prev.setNext(curr2.getNext()); //deleting curr2
                }else{
                    prev = curr2;
                }
                curr2 = curr2.getNext();
            }
            curr = curr.getNext();
        }
    }
}

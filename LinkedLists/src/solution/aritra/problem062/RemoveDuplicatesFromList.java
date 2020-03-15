package solution.aritra.problem062;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a linked list remove duplicates from it by using a hash table
 * Description: We can simple use a hashtable and check whether an element already exist.
 */
public class RemoveDuplicatesFromList {
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
        list.insertAtEnd(new ListNode(1));
        System.out.println("Before duplicate removal");
        System.out.println(list);
        removeDuplicates(list.getHead());
        System.out.println("After duplicate removal");
        System.out.println(list);
    }

    public static void removeDuplicates(ListNode head){
        Map<Integer,Boolean> mapper = new HashMap<Integer,Boolean>();
        ListNode curr = head;
        ListNode next;
        mapper.put(head.getData(),true);//putting the first node data into map as the loop does it from second place
        while(curr.getNext() != null){ //loop till the second last node in the list
            next = curr.getNext();
            if(mapper.get(next.getData()) != null){
                //already seen it, so delete
                curr.setNext(next.getNext());
            }else{
                mapper.put(next.getData(), true);
                curr = curr.getNext();
            }
        }
    }
}

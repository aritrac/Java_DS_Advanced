package solution.aritra.problem056;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Implement insertion sort for linked lists
 */
public class LinkedListInsertionSort {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSLL(10);
        System.out.println("Before insertion sort:");
        System.out.println(sll);
        ListNode newHead = insertionSortList(sll.getHead());
        System.out.println("After insertion sort:");
        while(newHead != null){
            System.out.print(newHead.getData() + " ");
            newHead = newHead.getNext();
        }
        System.out.println();
    }

    public static ListNode insertionSortList(ListNode head){
        if(head == null || head.getNext() == null) //if there is no node or only one node
            return head;
        ListNode newHead = new ListNode(head.getData());
        ListNode pointer = head.getNext();
        //Loop through each element in the list
        while(pointer != null){
            //insert this element to the new list
            ListNode innerPointer = newHead;
            ListNode next = pointer.getNext();
            if(pointer.getData() <= newHead.getData()){ //newHead is the pivot, so if element is less than pivot, add it at the front of the newList
                ListNode oldHead = newHead;
                newHead = pointer;
                newHead.setNext(oldHead);
            }else{ //if element is more than the pivot, then either add it at the end of new list or at the location
                //which is more than the innerPointer and less than the node next to innerPointer
                while(innerPointer.getNext() != null){
                    if(pointer.getData() > innerPointer.getData() && pointer.getData() <= innerPointer.getNext().getData()){
                        ListNode oldNext = innerPointer.getNext();//oldNext is the element to the right of the innerPointer before the insertion
                        innerPointer.setNext(pointer);
                        pointer.setNext(oldNext);
                    }
                    innerPointer = innerPointer.getNext();
                }
                if(innerPointer.getNext() == null && pointer.getData() > innerPointer.getData()){
                    innerPointer.setNext(pointer);
                    pointer.setNext(null);
                }
            }
            pointer = next;
        }
        return newHead;
    }
}

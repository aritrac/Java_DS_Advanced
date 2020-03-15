package solution.aritra.problem058;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order
 * and each of their nodes contain a single digit. Add the two numbers and return it as a linked list. For example
 * with input: (3->4->3) + (5->6->4); the output should be 8->0->8
 * The actual numbers are
 * 465
 * 343
 * 808
 */
public class AddTwoNumbersAsList {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertAtEnd(new ListNode(3));
        list1.insertAtEnd(new ListNode(4));
        list1.insertAtEnd(new ListNode(3));
        System.out.println(list1);

        LinkedList list2 = new LinkedList();
        list2.insertAtEnd(new ListNode(5));
        list2.insertAtEnd(new ListNode(6));
        list2.insertAtEnd(new ListNode(4));
        System.out.println(list2);

        ListNode result = addTwoNumbers(list1.getHead(),list2.getHead());

        while(result != null){
            System.out.print(" " + result.getData());
            result = result.getNext();
        }
        System.out.println();
    }
    public static ListNode addTwoNumbers(ListNode list1, ListNode list2){
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode head = new ListNode(0); //This will store the result
        ListNode curr = head;
        int advance = 0; //This is the carry from each step
        while(list1 != null && list2 != null){
            int sum = list1.getData() + list2.getData() + advance;
            advance = sum / 10; //finding the carry for next step
            sum = sum % 10; //finding out the digit to add to the result
            curr.setNext(new ListNode(sum));
            curr = curr.getNext(); //move to the next position in the result list
            list1 = list1.getNext();//advance both the lists
            list2 = list2.getNext();
        }
        if(list1 != null){
            if(advance != 0)//if there is an existing carry
                curr.setNext(addTwoNumbers(list1, new ListNode(advance)));
            else
                curr.setNext(list1);
        }else if(list2 != null){
            if(advance != 0)//if there is an existing carry
                curr.setNext(addTwoNumbers(list2, new ListNode(advance)));
            else
                curr.setNext(list2);
        }else if(advance != 0) { //both list1 and list2 exhausted but carry remains
            curr.setNext(new ListNode(advance));
        }
        return head.getNext();
    }
}

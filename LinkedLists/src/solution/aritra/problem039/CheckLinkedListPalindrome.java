package solution.aritra.problem039;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Check if a linked list is a palindrome or not
 * Description:
 * 1)Get the middle of the linked list
 * 2)Reverse the second half of the linked list
 * 3)Compare the first half and the second half
 */
public class CheckLinkedListPalindrome {
    public static void main(String[] args) {
        //TESTING REVERSAL
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSLL(10);
        System.out.println("Before reversal");
        System.out.println(sll);
        System.out.println("After reversal");
        ListNode reversedHead = reverseList(sll.getHead());
        while(reversedHead != null){
            System.out.print(" " + reversedHead.getData());
            reversedHead = reversedHead.getNext();
        }
        //TESTING PALINDROME FOR EVEN LIST
        LinkedList list = new LinkedList();
        list.insertAtEnd(new ListNode(1));
        list.insertAtEnd(new ListNode(2));
        list.insertAtEnd(new ListNode(3));
        list.insertAtEnd(new ListNode(4));
        list.insertAtEnd(new ListNode(5));
        list.insertAtEnd(new ListNode(5));
        list.insertAtEnd(new ListNode(4));
        list.insertAtEnd(new ListNode(3));
        list.insertAtEnd(new ListNode(2));
        list.insertAtEnd(new ListNode(1));

        //printing the original list for palindrome checking
        displayList(list.getHead());

        System.out.println("\nIs this list a palindrome? " + checkPalindrome(list.getHead()));
    }

    public static boolean checkPalindrome(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        ListNode prev = null;
        while(fastPtr != null){
            fastPtr = fastPtr.getNext().getNext();
            prev = slowPtr;
            slowPtr = slowPtr.getNext();
        }
        //reversing second half and attaching the reversed part with the first part
        prev.setNext(reverseList(slowPtr));

        //now checking first and second half for equality
        ListNode secondHalfIter = prev.getNext();
        ListNode firstHalfIter = head;
        while(secondHalfIter != null){
            if(firstHalfIter.getData() != secondHalfIter.getData())
                return false;
            firstHalfIter = firstHalfIter.getNext();
            secondHalfIter = secondHalfIter.getNext();
        }
        return true;
    }

    public static void displayList(ListNode head){
        System.out.println();
        while(head != null){
            System.out.print(" " + head.getData());
            head = head.getNext();
        }
    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.getNext() == null)
            return head;
        ListNode temp = head.getNext();
        ListNode prev = head;
        //iterate the entire list
        while(temp.getNext() != null){
            ListNode next = temp.getNext();
            temp.setNext(prev);
            if(prev == head)
                prev.setNext(null);
            prev = temp;
            temp = next;
        }
        temp.setNext(prev);
        return temp;
    }
}

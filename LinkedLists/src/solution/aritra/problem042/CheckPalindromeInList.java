package solution.aritra.problem042;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Check if a linked list is a palindrome or not
 * Description: We will use K group reversal to find the linked list is palindrome or not
 */
public class CheckPalindromeInList {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        int MAX_SIZE = 10;
        //create a palindromic list
        //LinkedList sll = listGen.createPalindromicSLL(MAX_SIZE);
        //create a non palindromic list
        LinkedList sll = listGen.createSLL(MAX_SIZE);
        //palindromic array display
        System.out.println(sll);
        //create a copy or clone of the palindromic list
        ListNode tempHead = listGen.createListCopy(sll.getHead());
        //reversing the cloned list
        tempHead = reverseKNodesRecursive(tempHead,MAX_SIZE);
        //displaying the reversed list
        displayList(tempHead);
        if(checkIsPalindrome(sll.getHead(), tempHead, 10)){
            System.out.println("The list is a palindrome");
        }else{
            System.out.println("The list is not a palindrome");
        }
    }

    public static void displayList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public static boolean checkIsPalindrome(ListNode head1, ListNode head2, int size){
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while(temp1 != null){
            if(temp1.getData() != temp2.getData())
                return false;
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }
        return true;
    }

    public static ListNode reverseKNodesRecursive(ListNode head, int k){
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        int count = k;
        //Reverse K nodes
        while(current != null && count > 0){ //if list has sufficient nodes and has not ended
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count--;
        }
        //Now next points to K+1th node, returns the pointer to the head node
        if(next != null){
            head.setNext(reverseKNodesRecursive(next,k));
        }
        //return head node
        return prev;
    }
}

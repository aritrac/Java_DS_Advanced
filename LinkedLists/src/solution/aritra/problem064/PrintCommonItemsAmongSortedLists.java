package solution.aritra.problem064;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given two sorted linked lists, give an algorithm for printing common elements of them.
 * Description: The solution is based on merge sort logic. Assume the given two lists are list1 and list2. Since
 * the elements are in sorted order, we run a loop till we reach the end of either of the list. We compare the values
 * of list1 and list2. If the values are equal, we add it to the common list.We move list1/list2/both nodes ahead to
 * the next pointer if the values pointed by list 1 was less/more/equal to the value pointed by list2.
 */
public class PrintCommonItemsAmongSortedLists {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSortedSLL(10);
        LinkedList sll2 = listGen.createSortedSLL(5);
        System.out.println("List1 contents");
        System.out.println(sll);
        System.out.println("List2 contents");
        System.out.println(sll2);
        ListNode commonList = commonElements(sll.getHead(),sll2.getHead());
        System.out.println("Common Elements");
        while (commonList != null){
            System.out.print(commonList.getData() + " ");
            commonList = commonList.getNext();
        }
        System.out.println();
    }

    public static ListNode commonElements(ListNode head1, ListNode head2){
        ListNode temp = new ListNode(0);
        ListNode head = temp;
        while(head1 != null && head2 != null){
            if(head1.getData() == head2.getData()){
                head.setNext(new ListNode(head1.getData())); //copy common element
                head1 = head1.getNext();
                head2 = head2.getNext();
                head = head.getNext();
            }else if(head1.getData() > head2.getData()){
                head2 = head2.getNext();
            }else{
                head1 = head1.getNext();
            }
        }
        return temp.getNext();
    }
}

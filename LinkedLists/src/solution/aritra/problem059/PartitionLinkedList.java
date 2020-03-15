package solution.aritra.problem059;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a linked list and a value K, partition it such that all nodes less than K come before nodes greater
 * than or equal to K. You should preserve the original relative order of the nodes in each of the two partitions.
 * For example, given 1-4-4-2-5-2 and K=3, return 1-2-3-4-3-5
 */
public class PartitionLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(new ListNode(1));
        list.insertAtEnd(new ListNode(4));
        list.insertAtEnd(new ListNode(4));
        list.insertAtEnd(new ListNode(2));
        list.insertAtEnd(new ListNode(5));
        list.insertAtEnd(new ListNode(2));

        int K = 3;
        System.out.println("Before partition");
        System.out.println(list);

        ListNode newPartitionedHead = partition(list.getHead(),K);

        System.out.println("After partition");
        while(newPartitionedHead != null){
            System.out.print(" " + newPartitionedHead.getData());
            newPartitionedHead = newPartitionedHead.getNext();
        }
        System.out.println();
    }

    public static ListNode partition(ListNode head, int K){
        ListNode root = new ListNode(0);
        ListNode pivot = new ListNode(K);
        ListNode rootNext = root;
        ListNode pivotNext = pivot;
        ListNode currentNode = head;
        while(currentNode != null){
            ListNode next = currentNode.getNext();
            if(currentNode.getData() >= K){
                pivotNext.setNext(currentNode);
                pivotNext = currentNode;
                pivotNext.setNext(null);
            }else{
                rootNext.setNext(currentNode);
                rootNext = currentNode;
            }
            currentNode = next;
        }
        rootNext.setNext(pivot.getNext()); //as the pivot element is not actually existing in the list
        return root.getNext(); //skipping the zero element which is at the start of the root
    }
}

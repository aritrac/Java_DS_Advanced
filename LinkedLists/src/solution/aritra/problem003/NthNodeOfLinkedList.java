package solution.aritra.problem003;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.ListNode;

import java.util.Hashtable;
import java.util.Map;

/**
 * Author: Aritra Chatterjee
 * Problem: Find nth node from the end of the list (bettering the complexity from the previous approach)
 */
public class NthNodeOfLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int cnt = 1;
        Map<Integer,ListNode> index = new Hashtable<Integer, ListNode>();
        ListNode node1 = new ListNode(20);
        ListNode node2 = new ListNode(21);
        ListNode node3 = new ListNode(22);
        ListNode node4 = new ListNode(23);
        ListNode node5 = new ListNode(24);
        ListNode node6 = new ListNode(25);
        ListNode node7 = new ListNode(26);
        index.put(cnt++,node1);
        index.put(cnt++,node2);
        index.put(cnt++,node3);
        index.put(cnt++,node4);
        index.put(cnt++,node5);
        index.put(cnt++,node6);
        index.put(cnt++,node7);
        list.insertAtBegin(node1);
        list.insertAtBegin(node2);
        list.insertAtBegin(node3);
        list.insertAtBegin(node4);
        list.insertAtBegin(node5);
        list.insertAtBegin(node6);
        list.insertAtBegin(node7);

        int N = 2; //Find the 2nd node from the last
        System.out.println(index.get(list.length() - N + 1).getData());
    }
}

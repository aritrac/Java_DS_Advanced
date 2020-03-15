package solution.aritra.problem049;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: In a list of length n, find the data at n/k node where k is a random integer between 0 to n.
 * Description: We will traverse the list 1 step at a time, when we hit a node where its position % k = 0, we will
 * advance the modular node pointer by one node. Like this when we reach the end, modular node pointer would point
 * to the fractional node n/k.
 */
public class FindFractionalNodeInAList {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSLL(21);
        int k = 3;
        //so if k is 3, then we need the 21/3 = 7th node
        //printing out the original list
        System.out.println(sll);
        System.out.println("The n/kth fractional node contains " + findNByKFractionalNode(sll.getHead(),k).getData());
    }

    public static ListNode findNByKFractionalNode(ListNode head, int k){
        ListNode fractionalNode = null;
        int i = 0;
        while(head != null){
            if(i % k == 0){
                if(fractionalNode == null)
                    fractionalNode = head;
                else
                    fractionalNode = fractionalNode.getNext();
            }
            i++;
            head = head.getNext();
        }
        return fractionalNode;
    }
}

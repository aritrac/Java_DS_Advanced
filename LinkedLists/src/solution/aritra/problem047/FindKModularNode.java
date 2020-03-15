package solution.aritra.problem047;

import solution.aritra.linkedlist.singlelinklist.operations.LinkedList;
import solution.aritra.utils.node.defs.GenerateSLL;
import solution.aritra.utils.node.defs.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a singly linked list, write a function to find the last element from the beginning whose n%k == 0,
 * where n is the number of elements in the list and k is an integer constant. For example, if n = 19 and k = 3
 * then we should return 18th node. The value of n is not known in advance.
 */
public class FindKModularNode {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList sll = listGen.createSLL(10);
        //printing out the list
        System.out.println(sll);
        //taking k as 3
        int k = 4;
        ListNode modularNode = findModularNode(sll.getHead(),k);
        System.out.println("The modular node data = " + modularNode.getData());
    }

    public static ListNode findModularNode(ListNode head, int k){
        if(k <= 0)
            return null;
        ListNode modularNode = null;
        int i = 0;
        for(;head != null; head = head.getNext()){
            if(i % k == 0)
                modularNode = head;
            i++;
        }
        return modularNode;
    }
}

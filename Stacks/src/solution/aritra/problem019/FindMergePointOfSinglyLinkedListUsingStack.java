package solution.aritra.problem019;

import solution.aritra.linkedlists.operations.LinkedList;
import solution.aritra.utils.nodes.defs.GenerateSLL;
import solution.aritra.utils.nodes.defs.ListNode;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Considering 2 SLLs which merge into a single list after few nodes, you need to find the node
 * at which the merge happens
 * Description: We will traverse each list and put the content of each list into two separate stacks, then we will
 * continue popping both the stacks at the same time and keep a reference to the matched nodes between both. Once the
 * match fails, we will return the reference to the last matched similar nodes.
 */
public class FindMergePointOfSinglyLinkedListUsingStack {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        //first list is (values will be random but size will be same)
        //1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
        LinkedList sll1 = listGen.createSLL(9);
        System.out.println(sll1);
        //second list is(values will be random but size will be same)
        //11 -> 12 -> 13
        LinkedList sll2 = listGen.createSLL(3);
        System.out.println(sll2);
        //and merging it at 6th node in the first list
        ListNode head1 = sll1.getHead();
        ListNode head2 = sll2.getHead();
        int i = 1;
        while(i++ <= 6){
            head1 = head1.getNext();
        }
        head2.getNext().getNext().setNext(head1);
        ListNode mergeStartNode = getMergeStartNode(sll1.getHead(),sll2.getHead());

        System.out.println("The merge start node contains " + mergeStartNode.getData());
    }

    public static ListNode getMergeStartNode(ListNode head1, ListNode head2){
        Stack<ListNode> st1 = new Stack<>();
        Stack<ListNode> st2 = new Stack<>();
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        //insert all the nodes of list1 into stack1
        while(temp1 != null){
            st1.push(temp1);
            temp1 = temp1.getNext();
        }
        //inserting all the nodes of list2 into stack2
        while(temp2 != null){
            st2.push(temp2);
            temp2 = temp2.getNext();
        }

        //popping from both the stacks until we find the merge start node
        ListNode mergeStartNode = null;
        while(!st1.isEmpty() && !st2.isEmpty()){
            ListNode node1 = st1.pop();
            ListNode node2 = st2.pop();
            if(node1 == node2)
                mergeStartNode = node1;
        }
        return mergeStartNode;
    }
}

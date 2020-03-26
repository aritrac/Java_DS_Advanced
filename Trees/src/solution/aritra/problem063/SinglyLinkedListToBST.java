package solution.aritra.problem063;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.utils.BinarySearchTree;
import solution.aritra.utils.GenerateSLL;
import solution.aritra.utils.LinkedList;
import solution.aritra.utils.ListNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a singly linked list where elements are sorted in ascending order, convert it to a balanced
 * BST
 * Description: Since it is a singly linked list, we will do away with the overhead of calculating the mid and then
 * traversing to the mid location and then set it in the BST. This is the top-down approach. Now what if we dont
 * calculate and traverse to the mid element but continue inserting elements in the BST from left to right. This
 * can be done in a bottom up approach. The algorithm below creates a BST using bottom up approach while the previous
 * problem dealt with top down approach.
 */
public class SinglyLinkedListToBST {
    public static void main(String[] args) {
        GenerateSLL listGen = new GenerateSLL();
        LinkedList list = listGen.createSortedSLL(8);
        System.out.println(list);

        BinarySearchTreeNode root = sortedListToBSTBottomUp(list.getHead(),0,list.length());

        BinarySearchTree.displayTree(root);
    }

    public static BinarySearchTreeNode sortedListToBSTBottomUp(ListNode head, int start, int end){
        if(start > end)
            return null;
        int mid = start + (end - start)/2;
        BinarySearchTreeNode leftChild = sortedListToBSTBottomUp(head,start,mid-1);
        BinarySearchTreeNode parent = new BinarySearchTreeNode(0);
        parent.setData(head.getData());
        parent.setLeft(leftChild);
        head = head.getNext();
        parent.setRight(sortedListToBSTBottomUp(head,mid + 1, end));
        return parent;
    }
}

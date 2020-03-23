package solution.aritra.problem060;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.utils.BinarySearchTree;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a sorted doubly linked list, give an algorithm for converting it into balanced binary search tree.
 * Description: Find the list length and construct the tree bottom up first
 */
public class ConvertSortedDLLToBalancedBST {
    public static void main(String[] args) {
        BinarySearchTreeNode head = new BinarySearchTreeNode(1);
        BinarySearchTreeNode node1 = new BinarySearchTreeNode(2);
        BinarySearchTreeNode node2 = new BinarySearchTreeNode(3);
        BinarySearchTreeNode node3 = new BinarySearchTreeNode(4);
        BinarySearchTreeNode node4 = new BinarySearchTreeNode(5);
        BinarySearchTreeNode node5 = new BinarySearchTreeNode(6);

        head.setLeft(null);
        head.setRight(node1);

        node1.setLeft(head);
        node1.setRight(node2);

        node2.setLeft(node1);
        node2.setRight(node3);

        node3.setLeft(node2);
        node3.setRight(node4);

        node4.setLeft(node3);
        node4.setRight(node5);

        node5.setLeft(node4);
        node5.setRight(null);

        BinarySearchTree.displayTree(sortedListToBST(head));
    }

    //finding the length of the DLL and calling the tree creator method
    public static BinarySearchTreeNode sortedListToBST(BinarySearchTreeNode head){
        int len = 0;
        BinarySearchTreeNode currentNode = head;
        while(currentNode != null){
            len++;
            currentNode = currentNode.getRight();
        }
        return construct(head,0,len -1);
    }

    public static BinarySearchTreeNode construct(BinarySearchTreeNode head, int start, int end){
        if(start > end)
            return null;
        int mid = start + (end - start)/2;
        //build left first as it is bottom up approach
        BinarySearchTreeNode left = construct(head,start,mid - 1);
        BinarySearchTreeNode root = new BinarySearchTreeNode(head.getData());
        root.setLeft(left);
        if(head.getRight() != null){ //traversing the DLL using the head node
            head.setData(head.getRight().getData());
            head.setRight(head.getRight().getRight());
        }
        root.setRight(construct(head,mid+1,end));
        return root;
    }
}

package solution.aritra.problem065;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.utils.BinarySearchTree;

/**
 * Author: Aritra Chatterjee
 * Problem: Find the floor and ceil value of a key in BST
 * Description: For example with input array {1,2,8,10,10,12,19}, then
 * For x = 0: floor doesnt exist in the array
 * For x = 5: floor = 2, ceil = 8
 * For x = 1: floor = 1, ceil = 1
 * For x = 20: floor = 19, ceil doesn't exist in array
 */
public class FloorAndCeilInBST {
    public static void main(String[] args) {
        BinarySearchTreeNode root = BinarySearchTree.createTree();
        System.out.println("The initial tree ");
        BinarySearchTree.displayTree(root);
        System.out.println("floor of 11 = " + floorInBST(root,11).getData());
        System.out.println("ceil of 11 = " + ceilInBST(root,11).getData());
    }

    public static BinarySearchTreeNode floorInBST(BinarySearchTreeNode root, int data){
        BinarySearchTreeNode prev = null;
        return floorInBSTUtil(root,prev,data);
    }

    public static BinarySearchTreeNode floorInBSTUtil(BinarySearchTreeNode root, BinarySearchTreeNode prev, int data){
        if(root == null)
            return null;
        if(floorInBSTUtil(root.getLeft(),prev,data) == null)
            return null;
        if(root.getData() == data)
            return root;
        if(root.getData() > data)
            return prev;
        prev = root;
        return floorInBSTUtil(root.getRight(), prev,data);
    }

    public static BinarySearchTreeNode ceilInBST(BinarySearchTreeNode root, int data){
        BinarySearchTreeNode prev = null;
        return ceilInBSTUtil(root,prev,data);
    }

    public static BinarySearchTreeNode ceilInBSTUtil(BinarySearchTreeNode root, BinarySearchTreeNode prev, int data){
        if(root == null)
            return null;
        if(ceilInBSTUtil(root.getRight(),prev,data) == null)
            return null;
        if(root.getData() == data)
            return root;
        if(root.getData() < data)
            return prev;
        prev = root;
        return ceilInBSTUtil(root.getLeft(),prev,data);
    }
}

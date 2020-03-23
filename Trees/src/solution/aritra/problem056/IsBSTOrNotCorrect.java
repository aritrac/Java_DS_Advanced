package solution.aritra.problem056;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.utils.BinarySearchTree;

/**
 * Author: Aritra Chatterjee
 * Problem: Check if a given binary tree is a BST or not (CORRECT APPROACH)
 * Description:For each node, check if max value in left subtree is smaller than the current node data and min value
 * in right subtree greater than the node data.
 */
public class IsBSTOrNotCorrect {
    public static void main(String[] args) {
        BinarySearchTreeNode bstRoot = BinarySearchTree.createTree();
        System.out.println("tree initially");
        BinarySearchTree.displayTree(bstRoot);
        System.out.println("Is the above tree a BST? " + isBST(bstRoot));
    }

    public static boolean isBST(BinarySearchTreeNode root){
        if(root == null)
            return true;
        //false if the max of the left is > than root
        if(root.getLeft() != null && BinarySearchTree.findMaximumRecursive(root.getLeft()).getData() > root.getData())
            return false;
        //false if the min of the right is < than root
        if(root.getRight() != null && BinarySearchTree.findMinimumRecursive(root.getRight()).getData() < root.getData())
            return false;
        //false, if recursively the left or right is not a BST
        if(!isBST(root.getLeft()) || !isBST(root.getRight()))
            return false;
        //passing all that, its a BST
        return true;
    }
}

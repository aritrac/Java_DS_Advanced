package solution.aritra.problem086;

import solution.aritra.tree.defs.BinarySearchTreeNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a BST and two integers (minimum and maximum integers) as parameters, how do you remove (prune)
 * elements that are not within that range?
 * Solution: Do a post order bottom-up traversal and check if root is >=A and root <= B, if so return root otherwise
 * return root.right or root.left to keep the sub tree values with the {A,B} range.
 */
public class PruneBSTBasedOnRange {
    public static BinarySearchTreeNode pruneBST(BinarySearchTreeNode root, int A, int B){
        if(root == null)
            return null;
        root.setLeft(pruneBST(root.getLeft(),A,B));
        root.setRight(pruneBST(root.getRight(),A,B));

        if(A <= root.getData() && root.getData() <= B)
            return root;
        if(root.getData() < A)
            return root.getRight();
        if(root.getData() > B)
            return  root.getLeft();
        return null;
    }
}

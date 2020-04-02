package solution.aritra.problem084;

import solution.aritra.tree.defs.BinarySearchTreeNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a binary tree, how do you remove all the half nodes(which have only one child). We should not touch
 * leaves.
 * Description:By using post order traversal we can solve this problem efficiently. We first process the left children
 * then the right children and finally the node itself. So we form the new tree bottom up starting from the leaves
 * towards the root. By the time we process the current node, both its left and right subtrees have already been
 * processed.
 */
public class HalfNodeRemovalBinaryTree {
    public static BinarySearchTreeNode removeHalfNodes(BinarySearchTreeNode root){
        if(root == null)
            return null;
        root.setLeft(removeHalfNodes(root.getLeft()));
        root.setRight(removeHalfNodes(root.getRight()));
        if(root.getLeft() == null && root.getRight() == null)
            return root;
        if(root.getLeft() == null)
            return root.getRight();
        if(root.getRight() == null)
            return root.getLeft();
        return root;
    }
}

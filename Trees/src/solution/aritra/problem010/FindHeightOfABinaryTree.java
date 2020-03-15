package solution.aritra.problem010;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for finding the height of the binary tree
 * Description: Recursively calculate height of left and right subtrees of a node and assign height to the node as max
 * of heights of two children plus one.
 */
public class FindHeightOfABinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("Height of the tree = " + maxDepthRecursive(root));
    }
    /*
    Returns the depth of this binary tree. The depth of a binary tree is the
    length of the longest path from this node to a leaf. The depth of a binary tree with no descendants
    (that is, just a leaf) is zero.
     */
    public static int maxDepthRecursive(BinaryTreeNode root){
        if(root == null)
            return 0;
        //compute the depth of each subtree
        int leftDepth = maxDepthRecursive(root.getLeft());
        int rightDepth = maxDepthRecursive(root.getRight());
        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }
}

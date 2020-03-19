package solution.aritra.problem025;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for finding the sum of all elements in binary tree
 * Description: Recurslively all the left subtree sum, right subtree sum, and add their values to current nodes data
 */

public class SumAllNodesBinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("The tree is as follows");
        tc.displayTree(root);
        System.out.println("The sum of all nodes = " + addAllNodes(root));
    }

    public static int addAllNodes(BinaryTreeNode root){
        if(root == null)
            return 0;
        else
            return root.getData() + addAllNodes(root.getLeft()) + addAllNodes(root.getRight());
    }
}

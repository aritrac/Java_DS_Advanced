package solution.aritra.problem001;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm to find maximum element in binary tree
 * Description: Find the max element in the left subtree, find the max element in the right subtree,
 * compare them with the root data and select the one which is giving the maximum value.
 */
public class MaxElementInBinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("The biggest element = " + maxInBinaryTree(root));
    }

    public static int maxInBinaryTree(BinaryTreeNode root){
        int maxValue = Integer.MIN_VALUE;
        if(root != null){
            int leftMax = maxInBinaryTree(root.getLeft());
            int rightMax = maxInBinaryTree(root.getRight());
            if(leftMax > rightMax)
                maxValue = leftMax;
            else
                maxValue = rightMax;
            if(root.getData() > maxValue)
                maxValue = root.getData();
        }
        return maxValue;
    }
}

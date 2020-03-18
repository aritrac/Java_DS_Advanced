package solution.aritra.problem020;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: The diameter of a tree(sometimes called the width) is the number of nodes on the longest path between
 * two leaves in the tree
 * Description: To find the diameter of a tree, first calculate the diameter of left subtree and right subtree
 * recursively. Among these two values, we need to send maximum value along with current level + 1
 */

public class FindDiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("The tree looks like");
        tc.displayTree(root);
        System.out.println("The diameter of the above tree = " + diameterOfATree(root));
        System.out.println("The height of the above tree = " + heightOfTree(root));
    }

    private static int diameter = 0;

    public static int diameterOfATree(BinaryTreeNode root){
        int left,right;
        if(root == null)
            return 0;
        left = diameterOfATree(root.getLeft());
        right = diameterOfATree(root.getRight());
        if(left + right > diameter)
            diameter = left + right;
        return Math.max(left,right) + 1;
    }

    //calculate height of a tree
    public static int heightOfTree(BinaryTreeNode root){
        if(root == null)
            return 0;
        //compute the depth of each subtree
        int leftDepth = heightOfTree(root.getLeft());
        int rightDepth = heightOfTree(root.getRight());
        return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
    }
}

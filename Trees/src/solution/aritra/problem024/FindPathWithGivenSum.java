package solution.aritra.problem024;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for checking the existence of path with given sum.
 * Description: For this problem, the strategy is: subtract the node value from the sum before calling its
 * children recursively, and check to see if the sum is 0 when we run out of tree
 */

public class FindPathWithGivenSum {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("The tree is as follows");
        tc.displayTree(root);
        System.out.println("Is there a leaf path with sum 11 in the above tree? " + hasPathSum(root,11)); //1 -> 3 -> 7
    }

    public static boolean hasPathSum(BinaryTreeNode root, int sum){
        if(root == null)
            return false;
        if(root.getLeft() == null && root.getRight() == null && root.getData() == sum)
            return true;
        return hasPathSum(root.getLeft(),sum - root.getData()) || hasPathSum(root.getRight(), sum - root.getData());
    }
}

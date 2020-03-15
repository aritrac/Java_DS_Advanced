package solution.aritra.problem006;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm to find the size of a binary tree
 * Description: Calculate the size of the left and right subtree recursively, add 1 (current node) and return
 * to its parent
 */
public class FindSizeOfABinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("The size of the binary tree is " + longerImplementation(root));
    }

    public static int longerImplementation(BinaryTreeNode root){
        int leftCount = 0;
        int rightCount = 0;
        if(root.getLeft() != null){
            leftCount += longerImplementation(root.getLeft());
        }
        if(root.getRight() != null){
            rightCount += longerImplementation(root.getRight());
        }
        return 1 + leftCount + rightCount;
    }

    public static int shorterImplementation(BinaryTreeNode root){
        int leftCount = root.getLeft() == null ? 0 : shorterImplementation(root.getLeft());
        int rightCount = root.getRight() == null ? 0 : shorterImplementation(root.getRight());
        return 1 + leftCount + rightCount;
    }
}

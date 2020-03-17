package solution.aritra.problem019;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Given two binary trees, return true if they are structurally same.
 * Description:
 */
public class StructurallySimilarOrNot {

    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root1 = new BinaryTreeNode(10);
        BinaryTreeNode root2 = new BinaryTreeNode(100);
        root1.left = new BinaryTreeNode(7);
        root1.right = new BinaryTreeNode(15);
        root1.left.left = new BinaryTreeNode(4);
        root1.left.right = new BinaryTreeNode(9);
        root1.right.right = new BinaryTreeNode(20);
        System.out.println("Tree 1");
        tc.displayTree(root1);

        root2.left = new BinaryTreeNode(70);
        root2.right = new BinaryTreeNode(150);
        root2.left.left = new BinaryTreeNode(40);
        root2.left.right = new BinaryTreeNode(90);
        root2.right.right = new BinaryTreeNode(200);
        System.out.println("Tree 2");
        tc.displayTree(root2);

        if (isSameStructure(root1, root2))
            System.out.printf("Both trees have same structure");
        else
            System.out.printf("Trees do not have same structure");
    }

    public static boolean isSameStructure(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;

        return isSameStructure(root1.getLeft(), root2.getLeft()) && isSameStructure(root1.getRight(),root2.getRight());
    }
}

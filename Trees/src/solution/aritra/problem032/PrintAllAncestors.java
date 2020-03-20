package solution.aritra.problem032;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for printing all the ancestors of a node in a binary tree. For example, print the
 * ancestor of 7 in the following tree
 *                   1
 *                 /  \
 *                2    3
 *               / \  / \
 *              4  5 6  7
 * Description: We can use the following recursive way to print the ancestors
 */
public class PrintAllAncestors {
    private static BinaryTreeNode testNode = null;

    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        System.out.println("The example tree is as follows");
        BinaryTreeNode root = createExampleTree();
        tc.displayTree(root);
        System.out.println("Printing all ancestors of node 7");
        printAllAncestors(root, testNode);
    }

    public static boolean printAllAncestors(BinaryTreeNode root, BinaryTreeNode node){
        if(root == null)
            return false;
        if(root.getLeft() == node || root.getRight() == node || printAllAncestors(root.getLeft(),node) || printAllAncestors(root.getRight(),node)){
            System.out.println(root.getData());
            return true;
        }
        return false;
    }

    public static BinaryTreeNode createExampleTree(){
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        testNode = node7;
        return root;
    }
}

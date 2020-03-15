package solution.aritra.problem003;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for searching an element in a binary tree
 * Description: Given a binary tree, return true if a node with data is found in the tree. Recurse down the tree
 * choose the left or right branch by comparing data with each other.
 */
public class FindInBinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("Does the tree contain 6? " + findInBinaryTree(root,6));
        System.out.println("Does the tree contain 10? " + findInBinaryTree(root,10));
    }
    //Tests whether the root argument contains within itself the data argument
    public static boolean findInBinaryTree(BinaryTreeNode root, int data){
        if(root == null)
            return false;
        if(root.getData() == data)
            return true;
        return (findInBinaryTree(root.getLeft(),data) || findInBinaryTree(root.getRight(),data));
    }
}

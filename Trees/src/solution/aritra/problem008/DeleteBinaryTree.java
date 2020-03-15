package solution.aritra.problem008;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for deleting the tree
 * Description: We can use post order traversal to delete the tree as we need to delete children first and then the parent
 */
public class DeleteBinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        tc.displayTree(root);
        deleteBinaryTree(root);
        tc.displayTree(root);
        //since 1 main root node remains, deleting that by setting root to null
        root = null;
    }

    public static void deleteBinaryTree(BinaryTreeNode root){
        if(root != null){
            deleteBinaryTree(root.getLeft());
            deleteBinaryTree(root.getRight());
            System.out.println("Deleting " + root.getData());
            root.setLeft(null);
            root.setRight(null);
        }
    }
}

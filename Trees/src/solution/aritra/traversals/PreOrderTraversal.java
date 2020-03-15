package solution.aritra.traversals;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Write code to demonstrate preorder traversal
 * Description: Algorithm is as follows
 * -> visit the root
 * -> traverse the left subtree in preorder
 * -> traverse the right subtree in preorder
 */
public class PreOrderTraversal {
    public static void preOrder(BinaryTreeNode root){
        if(root != null){
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();

        preOrder(root);
    }
}

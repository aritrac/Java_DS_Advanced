package solution.aritra.traversals;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Demonstrate Inorder Traversal
 * Description: See the code below and the algorithm
 *   -> Traverse the left subtree
 *   -> Visit the root
 *   -> Traverse the right subtree in inorder
 */

public class InorderTraversal {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        inOrderTraversal(root);
    }

    public static void inOrderTraversal(BinaryTreeNode root){
        if(root != null){
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
    }
}

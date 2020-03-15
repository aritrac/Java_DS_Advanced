package solution.aritra.traversals;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Do a post order traversal using stack
 * Description: Follow the following algorithm
 * -> Traverse the left subtree
 * -> Traverse the right subtree
 * -> Visit the root
 */

public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        preOrderTraversal(root);
    }

    public static void preOrderTraversal(BinaryTreeNode root){
        if(root != null){
            preOrderTraversal(root.getLeft());
            preOrderTraversal(root.getRight());
            System.out.println(root.getData());
        }
    }
}

package solution.aritra.problem027;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Convert a tree to its mirror representation
 * Description: Mirror of a tree is another tree with left and right children of all non-leaf nodes interchanged.
 */
public class CreateMirrorOfBinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("The tree is as follows");
        tc.displayTree(root);
        root = mirrorOfBinaryTree(root);
        System.out.println("The mirror tree is as follows");
        tc.displayTree(root);
    }

    public static BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root){
        BinaryTreeNode temp;
        if(root != null){
            mirrorOfBinaryTree(root.getLeft());
            mirrorOfBinaryTree(root.getRight());
            //swap the pointers in this node
            temp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(temp);
        }
        return root;
    }
}

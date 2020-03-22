package solution.aritra.problem055;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.utils.BinarySearchTree;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm to check whether the given binary tree is a BST or not
 * Description: For each node check if the node on its left is smaller and check if the node on its right is greater.
 */
public class FindBSTOrNot {
    public static void main(String[] args) {
        BinarySearchTreeNode bstRoot = BinarySearchTree.createTree();
        System.out.println("tree initially");
        BinarySearchTree.displayTree(bstRoot);
        System.out.println("Is the above tree a BST? " + isBST(bstRoot));
    }

    public static boolean isBST(BinarySearchTreeNode root){
        if(root == null)
            return true;
        //false if left is > than root
        if(root.getLeft() != null && root.getLeft().getData() > root.getData())
            return false;
        //false if right is < than root
        if(root.getRight() != null && root.getRight().getData() < root.getData())
            return false;
        //false if recursively the left or right is not a BST
        if(!isBST(root.getLeft()) || !isBST(root.getRight()))
            return false;
        //passing all that, its a BST
        return true;
    }
}

package solution.aritra.problem028;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Given two trees, give an algorithm for checking whether they are mirrors of each other.
 * Description: See the code below
 */
public class IsMirrorOfEachOtherBT {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        BinaryTreeNode mirrorRoot = mirrorOfBinaryTree(root);
        System.out.println("The mirror tree is as follows");
        tc.displayTree(mirrorRoot);
        BinaryTreeNode origRoot = tc.createTree();
        System.out.println("The original tree is as follows");
        tc.displayTree(origRoot);
        //Now checking if origRoot and mirrorRoot is mirror of each other or not
        System.out.println("Are origRoot and mirrorRoot mirrors of each other? " + areMirrors(origRoot,mirrorRoot));
    }

    public static boolean areMirrors(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null && root2 != null)
            return false;
        if(root1.getData() != root2.getData())
            return false;
        else
            return (areMirrors(root1.getLeft(),root2.getRight()) && areMirrors(root1.getRight(), root2.getLeft()));
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

package solution.aritra.problem047;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Given two trees how do we check whether they are quasi-isomorphic to each other or not.
 * Description: Two trees root1 and root2 are quasi isomorphic if root1 can be transformed into root2 by swapping the
 * left and right children of some of the nodes of root1. Data in the nodes are not important in determining quasi-
 * isomorphism, only the shape is important.
 */
public class IsQuasiIsomorphicTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root1 = tc.createTree();
        BinaryTreeNode root2 = tc.createTree();
        System.out.println("Is root1 and root2 quasi isomorphic? " + isQuasiIsomorphic(root1,root2));
    }

    public static boolean isQuasiIsomorphic(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;
        return  ((isQuasiIsomorphic(root1.getLeft(),root2.getLeft()) && isQuasiIsomorphic(root1.getRight(),root2.getLeft()))
                ||(isQuasiIsomorphic(root1.getLeft(),root2.getRight()) && isQuasiIsomorphic(root1.getRight(), root2.getLeft())));
    }
}

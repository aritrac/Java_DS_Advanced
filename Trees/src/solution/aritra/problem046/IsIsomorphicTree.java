package solution.aritra.problem046;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Given two trees, how do we check whether the trees are isomorphic to each other or not?
 * Description: Two binary trees are isomorphic if they have the same structure. The values of the nodes does not
 * affect whether two trees are isomorphic or not. Structurally the trees should be similar
 */
public class IsIsomorphicTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root1 = tc.createTree();
        BinaryTreeNode root2 = tc.createTree();
        System.out.println("Is root1 and root2 isomorphic? " + isIsomorphic(root1,root2));
    }

    public static boolean isIsomorphic(BinaryTreeNode root1, BinaryTreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        if((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;
        return isIsomorphic(root1.getLeft(),root2.getLeft()) && isIsomorphic(root1.getRight(), root2.getRight());
    }
}

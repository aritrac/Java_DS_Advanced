package solution.aritra.problem080;

import solution.aritra.tree.defs.BinarySearchTreeNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a binary search tree, check whether it is an AVL tree or not.
 * Description: During the checks each node sends its height to the parent
 */
public class FindIfAVLBSTOrNot {
    public static boolean isAVL(BinarySearchTreeNode root){
        if(root == null)
            return true;
        return isAVL(root.getLeft()) && isAVL(root.getRight()) && Math.abs(getHeight(root.getLeft()) - getHeight(root.getRight())) <= 1;
    }

    public static int getHeight(BinarySearchTreeNode root){
        int leftHeight,rightHeight;
        if(root == null)
            return 0;
        else{
            leftHeight = getHeight(root.getLeft());
            rightHeight = getHeight(root.getRight());
            if(leftHeight > rightHeight)
                return leftHeight + 1;
            else
                return  rightHeight + 1;
        }
    }
}

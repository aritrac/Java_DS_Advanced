package solution.aritra.problem082;

import solution.aritra.tree.defs.AVLTreeNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given an AVL tree with n integer items and two integers a and b, where a and b can be any integer with a <= b,
 * implement an algorithm to count the number of nodes in the range [a,b]
 * Description: There are three cases to consider. Whether the current node is in the range [a,b],on the left side of
 * the range [a,b] or on the right side of the range [a,b]. Only subtrees that possibly contain the nodes will be
 * processed under each of the three cases.
 */
public class RangeCountAVL {
    public static int rangeCount(AVLTreeNode root, int a, int b){
        if(root == null)
            return 0;
        else if(root.getData() > b)
            return rangeCount(root.getLeft(),a,b);
        else if(root.getData() < a)
            return rangeCount(root.getRight(),a,b);
        else if(root.getData() >= a && root.getData() <= b)
            return rangeCount(root.getLeft(),a,b) + rangeCount(root.getRight(),a,b) + 1;
        return 0;
    }
}

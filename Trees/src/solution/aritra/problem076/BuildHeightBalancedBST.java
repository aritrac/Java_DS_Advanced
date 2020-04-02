package solution.aritra.problem076;

import solution.aritra.tree.defs.BinarySearchTreeNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a height h, give an algorithm for generating the height balanced tree
 * Description: As we have discussed height balanced with h = 0 is nothing but a full binary tree. In a full binary
 * tree, the number of nodes with height h is 2^(h+1) - 1. As a result the nodes can be numbered as 1 to 2^(h+1) - 1
 */
public class BuildHeightBalancedBST {
    private static int count = 0;
    public static BinarySearchTreeNode buildHeightBalanced(int h){
        BinarySearchTreeNode temp;
        if(h == 0)
            return null;
        temp = new BinarySearchTreeNode(0);
        temp.setLeft(buildHeightBalanced(h -1));
        temp.setData(count++);
        temp.setRight(buildHeightBalanced(h-1));
        return temp;
    }
}

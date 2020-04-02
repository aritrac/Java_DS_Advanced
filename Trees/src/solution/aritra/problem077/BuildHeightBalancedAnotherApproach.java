package solution.aritra.problem077;

import solution.aritra.tree.defs.BinarySearchTreeNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Is there any other approach for problem 76?
 * Description: We can solve it using the merge sort logic. That means, instead of working with height, we can take
 * the range. With this approach we dont need any global counter to be maintained.
 */
public class BuildHeightBalancedAnotherApproach {

    public static BinarySearchTreeNode buildHeightBalanced(int l, int r){
        BinarySearchTreeNode temp;
        int mid = l + (r - l)/2;
        if(l > r)
            return null;
        temp = new BinarySearchTreeNode(0);
        temp.setData(mid);
        temp.setLeft(buildHeightBalanced(l,mid-1));
        temp.setRight(buildHeightBalanced(mid+1,r));
        return temp;
    }
}

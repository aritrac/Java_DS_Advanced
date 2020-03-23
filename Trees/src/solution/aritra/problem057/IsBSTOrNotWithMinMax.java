package solution.aritra.problem057;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.utils.BinarySearchTree;

/**
 * Author: Aritra Chatterjee
 * Problem: Can we improve on the complexity of problem 56?
 * Solution: A better solution is to look at each node only once. The trick is to write a utility helper function
 * isBST(BinarySearchTreeNode root, int min, int max) that traverses down the tree keeping track of the narrowing
 * min and max allowed values as it goes, looking at each node only once. The initial values for min and max
 * should be INT_MIN and INT_MAX, and they narrow from there
 */
public class IsBSTOrNotWithMinMax {
    public static void main(String[] args) {
        BinarySearchTreeNode bstRoot = BinarySearchTree.createTree();
        System.out.println("tree initially");
        BinarySearchTree.displayTree(bstRoot);
        System.out.println("Is the above tree a BST? " + isBST(bstRoot,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }

    public static boolean isBST(BinarySearchTreeNode root,int min,int max){
        if(root == null)
            return true;
        return(root.getData() > min && root.getData() < max && isBST(root.getLeft(),min,root.getData()) && isBST(root.getRight(),root.getData(),max));
    }
}

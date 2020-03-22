package solution.aritra.problem054;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.utils.BinarySearchTree;

/**
 * Author: Aritra Chatterjee
 * Problem: Given two pointers in a binary search tree, find the lowest common ancestor. Assume that bot the values
 * exist in the tree.
 * Description: We just have to traverse the BST in preorder, and if we find a node with value in between a and b
 * then that node is the LCA. If its value is greater than both a and b, then the LCA lies on the left side of the node
 * and if its value is smaller than both a and b then the LCA lies on the right side.
 */
public class LCAInBST {
    public static void main(String[] args) {
        BinarySearchTreeNode root = BinarySearchTree.createTree();
        BinarySearchTreeNode node1 = BinarySearchTree.find(root,9);
        BinarySearchTreeNode node2 = BinarySearchTree.find(root,2);
        System.out.println("The initial tree");
        BinarySearchTree.displayTree(root);

        System.out.println("Finding lowest common ancestor of 9 and 2 in the above tree");
        System.out.println(lowestCommonAncestor(root,node1,node2).getData());
    }

    public static BinarySearchTreeNode lowestCommonAncestor(BinarySearchTreeNode root, BinarySearchTreeNode a, BinarySearchTreeNode b){
        if(root == null)
            return null;
        if(root == a || root == b)
            return root;
        if(a.getData() < root.getData() && b.getData() < root.getData())
            return lowestCommonAncestor(root.getLeft(),a,b);
        else if(a.getData() > root.getData() && b.getData() > root.getData())
            return lowestCommonAncestor(root.getRight(),a,b);
        else
            return root;
    }
}

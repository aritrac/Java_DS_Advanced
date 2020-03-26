package solution.aritra.problem064;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.utils.BinarySearchTree;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for finding the kth smallest element in BST.
 * Description: The idea behind this solution is that, inorder traversal of BST produces sorted lists. While
 * traversing the BST in inorder, keep track of the number of elements visited.
 */
public class KthSmallestInBST {
    public static void main(String[] args) {
        BinarySearchTreeNode root = BinarySearchTree.createTree();

        System.out.println("The tree is as follows");
        BinarySearchTree.displayTree(root);

        BinarySearchTreeNode kthSmallestNode = kthSmallestInBST(root,4,0);
    }
    public static BinarySearchTreeNode kthSmallestInBST(BinarySearchTreeNode root, int k, int count){
        if(root == null)
            return null;
        BinarySearchTreeNode left = kthSmallestInBST(root.getLeft(),k,count);
        if(left != null)
            return left;
        if(count++ == k-2) {
            System.out.println("kth smallest element = " + root.getData());
            return root;
        }
        return kthSmallestInBST(root.getRight(),k,count);
    }
}

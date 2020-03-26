package solution.aritra.problem069;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.utils.BinarySearchTree;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a BST and two numbers k1 and k2, give an algorithm for printing all the elements of BST in that
 * range k1 and k2
 * Description:
 */
public class PrintElementsInRangeK1K2InBST {
    public static void main(String[] args) {
        BinarySearchTreeNode root = BinarySearchTree.createTree();
        System.out.println("Initial tree");
        BinarySearchTree.displayTree(root);
        rangePrinter(root,4,9);
    }

    public static void rangePrinter(BinarySearchTreeNode root, int k1, int k2){
        if(root == null)
            return;
        rangePrinter(root.getLeft(),k1,k2);
        if(root.getData() >= k1 && root.getData() <= k2)
            System.out.println(root.getData());
        rangePrinter(root.getRight(),k1,k2);
    }
}

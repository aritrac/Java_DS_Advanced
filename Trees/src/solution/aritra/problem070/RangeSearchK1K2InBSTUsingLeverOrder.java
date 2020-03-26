package solution.aritra.problem070;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.utils.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a BST and two numbers k1 and k2, give an algorithm for printing all the elements of BST in the range
 * K1 and K2
 * Description: We can use level order traversal: while adding the elements to queue check for the range.
 */
public class RangeSearchK1K2InBSTUsingLeverOrder {
    public static void main(String[] args) {
        BinarySearchTreeNode root = BinarySearchTree.createTree();
        System.out.println("Initial tree ");
        BinarySearchTree.displayTree(root);
        rangeSearchLevelOrder(root,4,9);
    }

    public static void rangeSearchLevelOrder(BinarySearchTreeNode root, int k1, int k2){
        BinarySearchTreeNode temp;
        Queue<BinarySearchTreeNode> q = new LinkedList<BinarySearchTreeNode>();
        if(root == null)
            return;
        q.offer(root);
        while(!q.isEmpty()){
            temp = q.poll();
            if(temp.getData() >= k1 && temp.getData() <= k2)
                System.out.println(temp.getData());
            if(temp.getLeft() != null && temp.getData() >= k1)
                q.offer(temp.getLeft());
            if(temp.getRight() != null && temp.getData() <= k2)
                q.offer(temp.getRight());
        }
        q.clear();
        return;
    }
}

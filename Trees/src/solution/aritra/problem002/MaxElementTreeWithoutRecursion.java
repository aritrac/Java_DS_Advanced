package solution.aritra.problem002;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for finding maximum element in binary tree without recursion.
 * Solution: Using level order traversal, just observe the element's data while deleting
 */
public class MaxElementTreeWithoutRecursion {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("Max element = " + maxBinaryTreeLevelOrder(root));
    }

    public static int maxBinaryTreeLevelOrder(BinaryTreeNode root){
        if(root == null)
            return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(tmp.getData() > max){
                max = tmp.getData();
            }
            if(tmp != null){
                if(tmp.getLeft()!= null)
                    q.offer(tmp.getLeft());
                if(tmp.getRight() != null)
                    q.offer(tmp.getRight());
            }
        }
        return max;
    }
}

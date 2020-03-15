package solution.aritra.problem014;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for finding the deepest node of the binary tree.
 * Description: The last node processed from queue in level order traversal is the deepest node in binary tree.
 */
public class DeepestNodeInABinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("Deepest node data = " + deepestNodeInBinaryTree(root).getData());
    }

    public static BinaryTreeNode deepestNodeInBinaryTree(BinaryTreeNode root){
        BinaryTreeNode tmp = null;
        if(root == null)
            return null;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            tmp = q.poll();
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.getRight() != null)
                q.offer(tmp.getRight());
        }
        return tmp;
    }
}

package solution.aritra.problem016;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for finding the number of leaves in the binary tree without using recursion
 * Description: See the code below which uses level order traversal to count the leaf nodes
 */

public class FindLeafCountNonRecursive {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        tc.displayTree(root);
        System.out.println("The number of leaf nodes in the above tree = " + countNumberOfLeaves(root));
    }

    public static int countNumberOfLeaves(BinaryTreeNode root){
        int count = 0;
        if(root == null)
            return 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(tmp.getLeft() == null && tmp.getRight() == null)
                count++;
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.getRight() != null)
                q.offer(tmp.getRight());
        }
        return count;
    }
}

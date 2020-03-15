package solution.aritra.problem007;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Find the size of the binary tree without using recursion
 * Description: We can use level order traversal to do the same.
 */
public class FindSizeUsingLevelOrderTraversal {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("The size of the tree is " + findSize(root));
    }

    public static int findSize(BinaryTreeNode root){
        int count = 0;
        if(root == null)
            return 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            count++;
            if(tmp.getLeft() != null){
                q.offer(tmp.getLeft());
            }
            if(tmp.getRight() != null){
                q.offer(tmp.getRight());
            }
        }
        return count;
    }
}

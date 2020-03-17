package solution.aritra.problem017;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Find the number of full nodes in the binary tree without using recursion
 * Description: The solution below uses level order traversal to count the number of full nodes non recursively.
 */
public class CountFullNodesNonRecursive {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        tc.displayTree(root);
        System.out.println("The number of full nodes in the above tree = " + countFullNodesNonRecursive(root));
    }

    public static int countFullNodesNonRecursive(BinaryTreeNode root){
        int count = 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(tmp.getLeft() != null && tmp.getRight() != null){
                count++;
            }
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.getRight() != null)
                q.offer(tmp.getRight());
        }
        return count;
    }
}

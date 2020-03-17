package solution.aritra.problem018;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Count the number of half nodes (nodes with only 1 child) in a tree non recursively.
 * Description: We use level order traversal to count the half nodes as shown below
 */
public class CountHalfNodesNonRecursive {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        tc.displayTree(root);
        System.out.println("The number of half nodes = " + countHalfNodes(root));
    }

    public static int countHalfNodes(BinaryTreeNode root){
        int count = 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if((tmp.getLeft() == null && tmp.getRight() != null) || (tmp.getLeft() != null && tmp.getRight() == null))
                count++;
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.getRight() != null)
                q.offer(tmp.getRight());
        }
        return count;
    }
}

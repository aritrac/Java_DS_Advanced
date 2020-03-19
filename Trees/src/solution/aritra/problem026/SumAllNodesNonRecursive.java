package solution.aritra.problem026;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Can we sum all nodes in a binary tree without recursion?
 * Description: Yes, we can use level order traversal to sum them as shown below
 */
public class SumAllNodesNonRecursive {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("The tree is as follows");
        tc.displayTree(root);
        System.out.println("The summation of all nodes = " + sumAllNodes(root));
    }

    public static int sumAllNodes(BinaryTreeNode root){
        int sum = 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            sum += tmp.getData();
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.getRight() != null)
                q.offer(tmp.getRight());
        }
        return sum;
    }
}

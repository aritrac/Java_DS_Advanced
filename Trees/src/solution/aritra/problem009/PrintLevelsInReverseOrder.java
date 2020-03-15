package solution.aritra.problem009;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Print each level of a binary tree from bottom to top i.e. in reverse order.
 * Description: See the code below
 */
public class PrintLevelsInReverseOrder {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode node = tc.createTree();
        System.out.println("Initial Ordering");
        tc.displayTree(node);
        System.out.println("In level reverse order");
        levelOrderTraversalInReverse(node);
    }

    public static void levelOrderTraversalInReverse(BinaryTreeNode root){
        if(root == null)
            return;
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.getRight() != null)
                q.offer(tmp.getRight());
            s.push(tmp);
        }
        while(!s.isEmpty()){
            System.out.print(" " + s.pop().getData());
        }
    }
}

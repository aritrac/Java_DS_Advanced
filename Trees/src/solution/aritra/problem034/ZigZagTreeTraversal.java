package solution.aritra.problem034;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm to traverse a binary tree in zigzag order.For example, if following is the binary tree
 *                1
 *             /    \
 *            2      3
 *          /  \   /  \
 *         4   5  6    7
 * The output should be like 1-3-2-4-5-6-7
 * Description: The problem can be solved easily using two stacks. Assume the two stacks are: currentLevel and
 * nextLevel. We would also need a variable to keep track of the current level order (whether it is left to right
 * or right to left). We pop from current level stack and print the nodes value. Whenever the current level order
 * is from left to right push the node's left child, then its right child, to stack nextLevel. Since a stack
 * is a last in first out structure, the next time the nodes are popped off nextLevel, it will be in reverse order
 * On the other hand, when the current level order is from right to left, we would push the nodes right child first,
 * then its left child. Finally we have to swap those two stacks at the end of each level
 */
public class ZigZagTreeTraversal {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("Initial tree");
        tc.displayTree(root);
        ArrayList<ArrayList<Integer>> lists = zigzagLevelOrder(root);
        for(ArrayList<Integer> list : lists){
            for(int data : list){
                System.out.print(" " + data);
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(BinaryTreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return res;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        boolean leftToRight = true;
        ArrayList<Integer> curr = new ArrayList<Integer>();
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(tmp != null){
                curr.add(tmp.data);
                if(tmp.getLeft() != null)
                    q.offer(tmp.getLeft());
                if(tmp.getRight() != null)
                    q.offer(tmp.getRight());
            }else{
                if(leftToRight){
                    ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
                    res.add(c_curr);
                    curr.clear();
                }else{
                    Stack<Integer> s = new Stack<Integer>();
                    s.addAll(curr);
                    ArrayList<Integer> c_curr = new ArrayList<Integer>();
                    while(!s.isEmpty()){
                        c_curr.add(s.pop());
                    }
                    res.add(c_curr);
                    curr.clear();
                }
                if(!q.isEmpty()){
                    q.offer(null);
                    leftToRight = !leftToRight;
                }
            }
        }
        return res;
    }
}

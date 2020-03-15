package solution.aritra.traversals;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Without using recursion, do post order traversal
 */
public class PostOrderTraversalNonRecursive {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        List<Integer> res = doPostTraversal(root);
        System.out.println(res);
    }

    public static List<Integer> doPostTraversal(BinaryTreeNode root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        s.push(root);
        BinaryTreeNode prev = null;
        while(!s.isEmpty()){
            BinaryTreeNode curr = s.peek();
            if(prev == null || prev.getLeft() == curr || prev.getRight() == curr){ //checking if curr is now a child of prev
                //traverse from top to bottom and if curr has left child or right child,
                //push into the stack otherwise pop out
                if(curr.getLeft() != null)
                    s.push(curr.getLeft());
                else if(curr.getRight() != null)
                    s.push(curr.getRight());
            }else if(curr.getLeft() == prev){
                if(curr.getRight() != null)
                    s.push(curr.getRight());
            }else{
                res.add(curr.getData());
                s.pop();
            }
            prev = curr;
        }
        return res;
    }
}

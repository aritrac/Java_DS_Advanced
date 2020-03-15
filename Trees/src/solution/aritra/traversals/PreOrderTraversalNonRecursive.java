package solution.aritra.traversals;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Without using recursion, do a preorder traversal on a binary tree
 * Description: See the problem below
 */
public class PreOrderTraversalNonRecursive {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();

        List<Integer> result = preorderTraversal(tc.createTree());
        Iterator<Integer> iter = result.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

    public static ArrayList<Integer> preorderTraversal(BinaryTreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            BinaryTreeNode tmp = stack.pop();
            result.add(tmp.data);
            //here we are pushing the right node and then the left node, so left node will get precedence
            if(tmp.getRight() != null)
                stack.push(tmp.getRight());
            if(tmp.getLeft() != null)
                stack.push(tmp.getLeft());
        }
        return result;
    }
}

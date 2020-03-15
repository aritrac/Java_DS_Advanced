package solution.aritra.problem011;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem:
 */
public class FindHeightOfTreeUsingStack {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("Max depth of the tree = " + maxDepthIterative(root));
    }

    //Returns the depth of this binary tree. The depth of a binary tree is the
    //length of the longest path from this node to a leaf. The depth of a binary
    //tree with no descendants (that is, just a leaf) is zero.
    public static int maxDepthIterative(BinaryTreeNode root){
        if(root == null)
            return 0;
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        s.push(root);
        int maxDepth = 0;
        BinaryTreeNode prev = null;
        while(!s.isEmpty()){
            BinaryTreeNode curr = s.peek();
            if(prev == null || prev.getLeft() == curr || prev.getRight() == curr){
                if(curr.getLeft() != null)
                    s.push(curr.getLeft());
                else if(curr.getRight() != null)
                    s.push(curr.getRight());
            }else if(curr.getLeft() == prev){
                if(curr.getRight() != null)
                    s.push(curr.getRight());
            }else
                s.pop();
            prev = curr;
            if(s.size() > maxDepth)
                maxDepth = s.size();
        }
        return maxDepth;
    }
}

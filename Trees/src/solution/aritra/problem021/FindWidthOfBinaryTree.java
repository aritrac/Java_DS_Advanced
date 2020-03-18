package solution.aritra.problem021;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Find the width of the binary tree. The width of a tree is the maximum number of nodes at any level
 * or depth in the tree.
 * Description: See the code below
 */
public class FindWidthOfBinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("The tree is");
        tc.displayTree(root);
        System.out.println("The width of the tree is " + widthOfTree(root));
    }

    public static int widthOfTree(BinaryTreeNode root){
        int max = 0;
        int height = heightOfTree(root);
        for(int k = 0; k <= height; k++){
            int tmp = width(root,k); //get the number of nodes at level k
            if(tmp > max)
                max = tmp;
        }
        return max;
    }

    //returns the number of nodes in a given level
    public static int width(BinaryTreeNode root, int depth){
        if(root == null)
            return 0;
        else{
            if(depth == 0)
                return 1;
            else
                return width(root.getLeft(), depth - 1) + width(root.getRight(), depth - 1);
        }
    }
    //calculates height of the tree
    public static int heightOfTree(BinaryTreeNode root){
        if(root == null)
            return 0;
        //compute the depth of each subtree
        int leftDepth = heightOfTree(root.getLeft());
        int rightDepth = heightOfTree(root.getRight());
        return (leftDepth > rightDepth)?leftDepth + 1: rightDepth + 1;
    }
}

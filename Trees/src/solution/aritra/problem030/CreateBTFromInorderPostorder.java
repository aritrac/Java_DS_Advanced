package solution.aritra.problem030;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for constructing binary tree from given Inorder and Postorder traversals
 * Description: See the code below
 */
public class CreateBTFromInorderPostorder {

    public static void main(String[] args) {
        int[] postorder = {4,5,2,6,3,1};
        int[] inorder = {4,2,5,1,6,3};
        //Above representation is for the following tree
        //      1
        //    /   \
        //   2     3
        //  / \   / \
        // 4   5 6  NULL
        BinaryTreeNode root = buildBinaryTree(postorder, inorder);
        System.out.println("The tree looks like the following");
        TreeCreator tc = new TreeCreator();
        tc.displayTree(root);
    }

    public static BinaryTreeNode buildBinaryTree(int[] postorder, int[] inorder){
        if(postorder.length == 0 || inorder.length != postorder.length)
            return null;
        return buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }

    public static BinaryTreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd){
        if(postStart > postEnd || inStart > inEnd)
            return null;
        int data = postorder[postEnd];
        BinaryTreeNode cur = new BinaryTreeNode(data); //This is the root
        //now finding the range of left subtree nodes
        int offset = inStart;
        for(; offset < inEnd; offset++){
            if(inorder[offset] == data)
                break;
        }
        cur.setLeft(buildTree(postorder,postStart, postStart + offset - inStart - 1, inorder, inStart, offset - 1));
        cur.setRight(buildTree(postorder,postStart + offset - inStart, postEnd - 1, inorder, offset + 1, inEnd));
        return cur;
    }
}

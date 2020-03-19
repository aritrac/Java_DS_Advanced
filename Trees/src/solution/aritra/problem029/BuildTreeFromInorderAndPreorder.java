package solution.aritra.problem029;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for constructing binary tree from given inorder and preorder traversals
 * Inorder Sequence: DBEAFC
 * Preorder Sequence: ABDECF
 * Description: In a preorder sequence, leftmost element denotes the root of the tree. So we know 'A' is the root for
 * given sequences. By searching 'A' in inorder sequence we can find out all elements on the left side of 'A', which
 * come under the left subtree, and elements on the right side of 'A', which comes under the right subtree.
 * Algorithm:
 * ->Select an element from preorder. Increment a preorder index variable to pick next element in the recursive call.
 * ->Create a new tree node with the data as the selected element
 * ->Find the selected elements index in Inorder.
 * ->Call buildBinaryTree for elements before the inorder index and make the built subtree as left subtree of newNode
 * ->Call buildBinaryTree for element after the inorder index and make the built subtree as right subtree of newNode
 * ->Return newNode
 */
public class BuildTreeFromInorderAndPreorder {
    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3,6};
        int[] inorder = {4,2,5,1,6,3};
        //Above representation is for the following tree
        //      1
        //    /   \
        //   2     3
        //  / \   / \
        // 4   5 6  NULL
        BinaryTreeNode root = buildBinaryTree(preorder, inorder);
        System.out.println("The tree looks like the following");
        TreeCreator tc = new TreeCreator();
        tc.displayTree(root);
    }

    public static BinaryTreeNode buildBinaryTree(int[] preorder, int[] inorder){
        if(preorder.length == 0 || inorder.length != preorder.length)
            return null;
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public static BinaryTreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd)
            return null;
        int data = preorder[preStart];
        BinaryTreeNode cur = new BinaryTreeNode(data); //This is the root
        //now finding the range of left subtree nodes
        int offset = inStart;
        for(; offset < inEnd; offset++){
            if(inorder[offset] == data)
                break;
        }
        cur.setLeft(buildTree(preorder,preStart + 1, preStart + offset - inStart, inorder, inStart, offset - 1));
        cur.setRight(buildTree(preorder,preStart + offset - inStart + 1, preEnd, inorder, offset + 1, inEnd));
        return cur;
    }
}

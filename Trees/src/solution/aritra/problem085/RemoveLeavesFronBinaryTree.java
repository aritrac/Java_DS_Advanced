package solution.aritra.problem085;

import solution.aritra.tree.defs.BinaryTreeNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a binary tree, how do you remove its leaves
 * Description: By using post order traversal we can solve this problem.
 */
public class RemoveLeavesFronBinaryTree {
    public static BinaryTreeNode removeLeaves(BinaryTreeNode root){
        if(root != null){
            if(root.getLeft() == null && root.getRight() == null){
                root = null;
            }else{
                root.setLeft(removeLeaves(root.getLeft()));
                root.setRight(removeLeaves(root.getRight()));
            }
        }
        return root;
    }
}

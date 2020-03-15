package solution.aritra.problem005;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for inserting an element into binary tree
 * Description: Since the given tree is a binary tree, we can insert the element wherever we want. To
 * insert an element, we can use the level order traversal and insert the element wherever we find the node whose
 * left or right child is null
 */
public class InsertInBinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        tc.displayTree(root);
        insertInBinaryTreeLevelOrder(root,8);
        insertInBinaryTreeLevelOrder(root,9);
        insertInBinaryTreeLevelOrder(root,10);
        System.out.println("\n\n");
        tc.displayTree(root);
    }
    public static void insertInBinaryTreeLevelOrder(BinaryTreeNode root, int data){
        if(root == null)
            return;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(tmp != null){
                if(tmp.getLeft() != null) {
                    q.offer(tmp.getLeft());
                }else{
                    tmp.setLeft(new BinaryTreeNode(data));
                    return;
                }
                if(tmp.getRight() != null){
                    q.offer(tmp.getRight());
                }else{
                    tmp.setRight(new BinaryTreeNode(data));
                    return;
                }
            }
        }
        return;
    }
}

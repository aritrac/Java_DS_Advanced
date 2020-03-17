package solution.aritra.problem015;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Delete an element from a binary tree
 * Description: The deletion can be done as follows:
 * -> Starting at root, find the node which we want to delete
 * -> Find the deepest node in the tree
 * -> Replace the deepest nodes data with node to be deleted
 * -> Then delete the deepest node
 */

public class DeleteNodeFromBinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("Deepest node data = " + deepestNodeInBinaryTree(root).getData());
        System.out.println("Before deletion");
        tc.displayTree(root);
        BinaryTreeNode deepestRoot = deepestNodeInBinaryTree(root);
        BinaryTreeNode nodeToDelete = deleteNode(root, 3);
        nodeToDelete.setData(deepestRoot.getData());
        deepestRoot.setData(-1);
        System.out.println("After deletion");
        tc.displayTree(root);
    }

    public static BinaryTreeNode deleteNode(BinaryTreeNode root, int data){
        if(root == null || root.getData() == data)
            return root;
        else {
            BinaryTreeNode res = deleteNode(root.getLeft(),data);
            return res == null ? deleteNode(root.getRight(), data) : res;
        }
    }

    public static BinaryTreeNode deepestNodeInBinaryTree(BinaryTreeNode root){
        BinaryTreeNode tmp = null;
        if(root == null)
            return null;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            tmp = q.poll();
            if(tmp.getLeft() != null)
                q.offer(tmp.getLeft());
            if(tmp.getRight() != null)
                q.offer(tmp.getRight());
        }
        return tmp;
    }
}

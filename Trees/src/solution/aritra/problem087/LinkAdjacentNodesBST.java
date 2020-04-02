package solution.aritra.problem087;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.tree.defs.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a binary tree, how do you connect all the adjacent nodes at the same level? Assume that the given
 * binary tree has next pointer along with left and right pointers
 * Description: One simple approach is to use level order traversal and keep updating  the next pointers. While
 * traversing we will link the nodes on the next level. If the node has left and right node, we will link left to right.
 * If node has next node, then link rightmost child of current node to leftmost child of next node.
 */
public class LinkAdjacentNodesBST {
    public static void linkAdjacentNodesInSameLevel(BinarySearchTreeNode root){
        Queue<BinarySearchTreeNode> q = new LinkedList();
        BinarySearchTreeNode prev; //pointer to the previous node of the current level
        BinarySearchTreeNode temp;
        int currentLevelNodeCount;
        int nextLevelNodeCount;

        if(root == null)
            return;
        q.offer(root);
        currentLevelNodeCount = 1;
        nextLevelNodeCount = 0;
        prev = null;
        while(!q.isEmpty()){
            temp = q.poll();
            if(temp.getLeft() != null){
                q.offer(temp.getLeft());
                nextLevelNodeCount++;
            }
            if(temp.getRight() != null){
                q.offer(temp.getRight());
                nextLevelNodeCount++;
            }
            //link the previous node of the current level to this node
            if(prev != null)
                prev.setNext(temp);
            //set the previous node to the current
            prev = temp;
            currentLevelNodeCount--;
            if(currentLevelNodeCount == 0){ //if this is the last node of the current level
                currentLevelNodeCount = nextLevelNodeCount;
                nextLevelNodeCount = 0;
                prev = null;
            }
        }
    }
}
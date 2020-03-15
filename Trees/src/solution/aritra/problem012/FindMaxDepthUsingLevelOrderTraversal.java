package solution.aritra.problem012;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Find min depth of a binary tree using level order traversal
 * Description: See the code below
 */
public class FindMaxDepthUsingLevelOrderTraversal {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        tc.displayTree(root);
        System.out.println("The min depth of the tree = " + findMinDepthOfTree(root));
    }

    public static int findMinDepthOfTree(BinaryTreeNode root){
        if(root == null)
            return 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        int count = 1;
        while(!q.isEmpty()){
            BinaryTreeNode currentNode = q.poll();
            if(currentNode != null){
                if(currentNode.getLeft() == null && currentNode.getRight() == null){ //we discovered the place where there is a leaf node
                    return count;                                                    //hence no need to process further for min depth
                }
                if(currentNode.getLeft() != null){
                    q.offer(currentNode.getLeft());
                }
                if(currentNode.getRight() != null){
                    q.offer(currentNode.getRight());
                }
            }else{
                if(!q.isEmpty()) {
                    count++;
                    q.offer(null);
                }
            }
        }
        return count;
    }
}

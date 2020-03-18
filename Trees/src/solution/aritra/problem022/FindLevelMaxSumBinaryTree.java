package solution.aritra.problem022;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for finding the level that has the maximum sum in the binary tree
 * Description: The logic is very much similar to finding the number of levels. The only change is,we need to keep
 * track of the sums as well.
 */

public class FindLevelMaxSumBinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("The initial tree is");
        tc.displayTree(root);
        System.out.println("The max level sum in the above tree is " + findLevelWithMaxSum(root));
    }

    public static int findLevelWithMaxSum(BinaryTreeNode root){
        int maxSum = 0, currentSum = 0;
        if(root == null)
            return 0;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null); //serves as the end of a level
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(tmp != null){
                if(tmp.getLeft() != null)
                    q.offer(tmp.getLeft());
                if(tmp.getRight() != null)
                    q.offer(tmp.getRight());
                currentSum += tmp.getData();
            }else{
                if(currentSum > maxSum){
                    maxSum = currentSum;
                }
                currentSum = 0; //completion of a level
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
        return maxSum;
    }
}

package solution.aritra.problem004;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for searching an element in binary tree without recursion
 * Description: We can use level order traversal for solving this problem. The only change required in level order
 * traversal is, instead of printing the data, we just need to check whether the root data is equal to the element
 * we want to search.
 */
public class FindElementInTreeWithoutRecursion {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("Is 6 present in tree? " + findInBinaryTree(root,6));
        System.out.println("Is 10 present in tree? " + findInBinaryTree(root,10));
    }

    //Tests whether the root argument contains within itself the data argument
    public static boolean findInBinaryTree(BinaryTreeNode root, int data){
        if(root == null)
            return false;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(tmp.getData() == data){
                return true;
            }
            if(tmp != null){
                if(tmp.getLeft() != null)
                    q.offer(tmp.getLeft());
                if(tmp.getRight() != null)
                    q.offer(tmp.getRight());
            }
        }
        return false;
    }
}

package solution.aritra.problem035;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

import java.util.HashMap;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for finding the vertical sum of a binary tree.
 * Description: We need to check the Horizontal Distances from the root for all nodes. If two nodes have the same
 * Horizontal Distance (HD), then they are on the same vertical line. The idea of HD is simple. HD for root is 0,
 * a right edge (edge connecting to right subtree) is considered as +1 horizontal distance and a left edge is
 * considered as -1 horizontal distance. We can do an in-order traversal of the given Binary Tree. While traversing
 * the tree, we can recursively calculate HDs. We initially pass the horizontal distance as 0 for root. For left
 * subtree, we pass the Horizontal Distance as Horizontal distance of root minus 1. For right subtree, we pass the
 * Horizontal Distance as Horizontal Distance of root plus 1
 */

public class VerticalSumBinaryTree {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        System.out.println("Initial tree");
        tc.displayTree(root);
        verticalSum(root);
    }

    public static void vSum(HashMap<Integer,Integer> hash, BinaryTreeNode root, int c){
        if(root.getLeft() != null)
            vSum(hash,root.getLeft(),c-1);
        if(root.getRight() != null)
            vSum(hash,root.getRight(), c+1);
        int data = 0;
        if(hash.containsKey(c))
            data = hash.get(c);
        hash.put(c,root.getData() + data);
    }

    public static void verticalSum(BinaryTreeNode root){
        HashMap<Integer, Integer> hash = new HashMap<Integer,Integer>();
        vSum(hash,root,0);
        System.out.println();
        for(int k : hash.keySet()){
            System.out.println("key(pos): " + k + " sum: " + hash.get(k) + " ");
        }
    }
}

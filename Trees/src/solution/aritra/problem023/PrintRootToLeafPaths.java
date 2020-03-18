package solution.aritra.problem023;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a binary tree, print out all its root to leaf paths
 * Description: See the code below and refer to the comments
 */
public class PrintRootToLeafPaths {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        tc.displayTree(root);
        System.out.println("The various paths are:");
        printPaths(root);
    }

    public static void printPaths(BinaryTreeNode root){
        int[] path = new int[256];
        printPaths(root,path,0);
    }

    private static void printPaths(BinaryTreeNode root, int[] path ,int pathLen){
        if(root == null)
            return;
        //append this node to the path array
        path[pathLen] = root.getData();
        pathLen++;
        //its a leaf, so print the path that led to here
        if(root.getLeft() == null && root.getRight() == null){
            printArray(path,pathLen);
        }else{
            //otherwise try both subtrees
            printPaths(root.getLeft(),path,pathLen);
            printPaths(root.getRight(),path,pathLen);
        }
    }

    private static void printArray(int[] ints, int len){
        for(int i = 0;i<len;i++){
            System.out.print(ints[i] + " ");
        }
        System.out.println();
    }

}

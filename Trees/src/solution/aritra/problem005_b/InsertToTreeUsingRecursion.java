package solution.aritra.problem005_b;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Insert an element into a binary tree using recursion
 * Description: See the solution below and compare with the previous approach of LOT
 */
public class InsertToTreeUsingRecursion {
    public static void main(String[] args) {
        TreeCreator tc = new TreeCreator();
        BinaryTreeNode root = tc.createTree();
        //tc.displayTree(root);
        //Testing unbalanced insert
        //insertUnbalanced(root,8);
        //insertUnbalanced(root,9);
        //insertUnbalanced(root,10);
        //System.out.println("\n\n");
        //tc.displayTree(root);

        //Testing balanced insert
        insertBalanced(root,8);
        insertBalanced(root,9);
        insertBalanced(root,10);
        System.out.println("\n\n");
        tc.displayTree(root);
    }
    public static void insertUnbalanced(BinaryTreeNode root, int data){
        if(root == null) {
            root = new BinaryTreeNode(data);
            return;
        }
        else { //will insert only as left nodes which will skew the binary tree
            if (root.getLeft() == null) {
                root.setLeft(new BinaryTreeNode(data));
                return;
            }else
                insertUnbalanced(root.getLeft(),data);
            }
    }

    public static void insertBalanced(BinaryTreeNode root, int data){
        if(root == null)
            return;
        if(root.getData() >= data){ //insert to the left
            if(root.getLeft() == null){
                root.setLeft(new BinaryTreeNode(data));
            }else{//keep going right
                insertBalanced(root.getRight(),data);
            }
        }else{ //insert to the right
            if(root.getRight() == null){
                root.setRight(new BinaryTreeNode(data));
            }else{ //keep going left
                insertBalanced(root.getRight(), data);
            }
        }
    }
}

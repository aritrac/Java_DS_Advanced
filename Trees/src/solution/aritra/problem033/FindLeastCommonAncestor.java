package solution.aritra.problem033;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for finding least common ancestor of two nodes in a binary tree.
 * Description: See the code below
 */
public class FindLeastCommonAncestor {

    private static BinaryTreeNode testNode1, testNode2;
    public static void main(String[] args) {
        BinaryTreeNode root = createExampleTree();
        TreeCreator tc = new TreeCreator();
        System.out.println("The tree is as follows");
        tc.displayTree(root);
        System.out.println("Finding the common ancestor of 7 and 5");
        BinaryTreeNode commonAncestor = findLCA(root, testNode1,testNode2);
        System.out.println(commonAncestor.getData());
    }

    public static BinaryTreeNode createExampleTree(){
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        testNode1 = node7;
        testNode2 = node5;
        return root;
    }

    public static BinaryTreeNode findLCA(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b){
        BinaryTreeNode left, right;
        if(root == null)
            return null;
        if(root == a || root == b)
            return root;
        left = findLCA(root.getLeft(),a,b);
        right = findLCA(root.getRight(),a,b);
        if(left != null && right != null) //nodes are each on a separate branch
            return root;
        else
            return (left != null? left:right); //either one node is on one branch or none was found in any of the branches
    }
}

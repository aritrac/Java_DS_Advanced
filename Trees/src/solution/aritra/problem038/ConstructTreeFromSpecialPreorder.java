package solution.aritra.problem038;

import solution.aritra.tree.defs.BinaryTreeNode;
import solution.aritra.utils.TreeCreator;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a tree with a special property where leaves are represented with 'L' and internal node with
 * 'I'. Also assume that each node has either 0 or 2 children. Given preorder traversal of this tree, construct the
 * tree
 * Description: For example ILILL and the tree should be
 *                  I
 *                 / \
 *                L   I
 *                   / \
 *                  L   L
 * First we should see how preorder traversal is arranged. Preorder traversal means first put root node,
 * then pre-order traversal of left subtree and then pre-order traversal of right subtree. In a normal scenario,
 * its not possible to detect where left subtree ends and right subtree starts using only pre-order traversal.
 * Since every node has either 2 children or no child, we can surely say that is a node exists then its sibling
 * also exists. So everytime when we are computing a subtree, we need to compute its sibling subtree as well.
 * Secondly whenever we get L in the input string, that is a leaf and we can stop for a particular subtree at that
 * point. After this 'L' node its sibling starts. If 'L' node is right child of its parent, then
 * we need to go up in the hierarchy to find the next subtree to compute.
 */
public class ConstructTreeFromSpecialPreorder {
    public static void main(String[] args) {
        char[] arr = {'I','L','I','L','L'};
        BinaryTreeNode root = buildTreeFromSpecialPreorder(arr,0);
        TreeCreator tc = new TreeCreator();
        tc.displayTree(root);
    }

    public static BinaryTreeNode buildTreeFromSpecialPreorder(char[] nodes,int i){
        if(nodes == null)
            return null;
        if(nodes.length == i)
            return null;
        BinaryTreeNode newNode = new BinaryTreeNode(nodes[i]);
        newNode.setLeft(null);
        newNode.setRight(null);
        if(nodes[i] == 'L') //on reaching leaf node
            return newNode;
        i++; //populate left subtree
        newNode.setLeft(buildTreeFromSpecialPreorder(nodes,i));
        i++;
        newNode.setRight(buildTreeFromSpecialPreorder(nodes,i));
        return newNode;
    }
}

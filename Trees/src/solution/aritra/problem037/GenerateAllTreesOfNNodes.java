package solution.aritra.problem037;

import solution.aritra.tree.defs.BinaryTreeNode;

import java.util.ArrayList;

/**
 * Author: Aritra Chatterjee
 * Problem: How do we generate all BSTs with n nodes?
 * Description: The idea is to maintain a list of roots of all BSTs. Recursively construct all possible left and
 * right subtrees. Create a tree for every pair of left and right subtree and add the tree to list. Below is
 * detailed algorithm.
 *
 * 1) Initialize list of BSTs as empty.
 * 2) For every number i where i varies from 1 to N, do following
 *  a)  Create a new node with key as 'i', let this node be 'node'
 *  b)  Recursively construct list of all left subtrees.
 *  c)  Recursively construct list of all right subtrees.
 * 3) Iterate for all left subtrees
 *  a) For current leftsubtree, iterate for all right subtrees
 *     Add current left and right subtrees to 'node' and add
 *     'node' to list.
 */
public class GenerateAllTreesOfNNodes {
    public static void main(String args[])
    {
        ArrayList<BinaryTreeNode> totalTreesFrom1toN = constructTrees(1, 5);
        /*  Printing preorder traversal of all constructed BSTs   */
        System.out.println("Preorder traversals of all constructed BSTs are ");
        for (BinaryTreeNode root : totalTreesFrom1toN)
        {
            preorder(root);
            System.out.println();
        }
    }

    static ArrayList<BinaryTreeNode> constructTrees(int start, int end)
    {
        ArrayList<BinaryTreeNode> list=new ArrayList<>();
        /*  if start > end   then subtree will be empty so returning NULL
            in the list */
        if (start > end)
        {
            list.add(null);
            return list;
        }

        /*  iterating through all values from start to end  for constructing\
            left and right subtree recursively  */
        for (int i = start; i <= end; i++)
        {
            /*  constructing left subtree   */
            ArrayList<BinaryTreeNode> leftSubtree  = constructTrees(start, i - 1);

            /*  constructing right subtree  */
            ArrayList<BinaryTreeNode> rightSubtree = constructTrees(i + 1, end);

            /*  now looping through all left and right subtrees and connecting
                them to ith root  below  */
            for (int j = 0; j < leftSubtree.size(); j++)
            {
                BinaryTreeNode left = leftSubtree.get(j);
                for (int k = 0; k < rightSubtree.size(); k++)
                {
                    BinaryTreeNode right = rightSubtree.get(k);
                    BinaryTreeNode node = new BinaryTreeNode(i);        // making value i as root
                    node.setLeft(left);              // connect left subtree
                    node.setRight(right);            // connect right subtree
                    list.add(node);                // add this tree to list
                }
            }
        }
        return list;
    }

    // A utility function to do preorder traversal of BST
    static void preorder(BinaryTreeNode root)
    {
        if (root != null)
        {
            System.out.print(root.getData()+" ") ;
            preorder(root.left);
            preorder(root.right);
        }
    }
}

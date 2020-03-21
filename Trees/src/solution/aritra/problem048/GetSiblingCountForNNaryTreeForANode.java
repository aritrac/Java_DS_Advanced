package solution.aritra.problem048;

import solution.aritra.tree.defs.NNaryTreeNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a node in a generic N-ary tree, give an algorithm for counting the number of children for that node.
 * Solution: For a given node in the tree, we just need to point to its first child and keep traversing all its
 * next siblings.
 */

public class GetSiblingCountForNNaryTreeForANode {
    public static void main(String[] args) {
        /*
        A NNary Tree
                          1
                      /   |  \
                     2 -> 3 -> 4
                          |  /  \ \
                          6  1->2->3
         */
        NNaryTreeNode root = new NNaryTreeNode(1);
        NNaryTreeNode level1Node1 = new NNaryTreeNode(2);
        NNaryTreeNode level1Node2 = new NNaryTreeNode(3);
        NNaryTreeNode level1Node3 = new NNaryTreeNode(4);

        NNaryTreeNode level2Node1 = new NNaryTreeNode(6);
        NNaryTreeNode level2Node2 = new NNaryTreeNode(1);
        NNaryTreeNode level2Node3 = new NNaryTreeNode(2);
        NNaryTreeNode level2Node4 = new NNaryTreeNode(3);

        root.setFirstChild(level1Node1);
        level1Node1.setNextSibling(level1Node2);
        level1Node2.setNextSibling(level1Node3);

        level1Node2.setFirstChild(level2Node1);
        level1Node3.setFirstChild(level2Node2);

        level2Node2.setNextSibling(level2Node3);
        level2Node3.setNextSibling(level2Node4);

        System.out.println("The sibling count of node with data 1 in last level is " + getChildCount(level1Node3));
    }

    public static int getChildCount(NNaryTreeNode node){
        int count = 0;
        NNaryTreeNode current = node.getFirstChild();
        while(current != null){
            count++;
            current = current.getNextSibling();
        }
        return count;
    }
}

package solution.aritra.problem041;

import solution.aritra.tree.defs.NNaryTreeNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Sum all elements of an N-Nary Tree
 * Description: The solution is similar to what we have done for simple binary trees. That means traverse the complete
 * list and keep on adding the values. We can either use level order traversal or simple recursion.
 */
public class SumAllElementsNNaryTree {
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

        System.out.println("The sum of the N-nary tree = " + findSum(root));
    }

    public static int findSum(NNaryTreeNode root){
        if(root == null)
            return 0;
        return root.getData() + findSum(root.getFirstChild()) + findSum(root.getNextSibling());
    }
}

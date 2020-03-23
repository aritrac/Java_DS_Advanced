package solution.aritra.problem058;

import solution.aritra.tree.defs.BinarySearchTreeNode;
import solution.aritra.utils.BinarySearchTree;

/**
 * Author: Aritra Chatterjee
 * Problem: Can we improve further on the complexity of problem 56?
 * Solution: By using inorder traversal. The idea behind this solution is that inorder traversal of BST produces
 * sorted lists. While traversing the BST in inorder, at each node check the condition that its key value
 * should be greater than the key value of its previous visited node. Also we need to initialize the prev with
 * minimum integer value Integer.MIN_VALUE
 */
public class IsBSTUsingInorderTraversal {
    public static void main(String[] args) {
        BinarySearchTreeNode bstRoot = BinarySearchTree.createTree();
        System.out.println("tree initially");
        BinarySearchTree.displayTree(bstRoot);
        System.out.println("Is the above tree a BST? " + isBST(bstRoot));
    }

    public static int prev = Integer.MIN_VALUE;

    public static boolean isBST(BinarySearchTreeNode root){
        if(root == null)
            return true;
        if(!isBST(root.getLeft()))
            return false;
        if(root.getData() < prev)
            return false;
        prev = root.getData();
        return isBST(root.getRight());
    }
}

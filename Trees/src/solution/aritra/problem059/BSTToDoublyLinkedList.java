package solution.aritra.problem059;

import solution.aritra.tree.defs.BinarySearchTreeNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Give an algorithm for converting BST to circular doubly linked list
 * Description: Convert left and right subtrees to DLLs and maintain end of those lists. Then adjust the pointers.
 */
public class BSTToDoublyLinkedList {

    //root --> Root of the BST
    static BinarySearchTreeNode root;

    // head --> Pointer to head node of created doubly linked list
    static BinarySearchTreeNode head;

    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static BinarySearchTreeNode prev = null;

    public static void main(String[] args) {
        // Let us create the tree as shown in above diagram
        BinarySearchTreeNode root = new BinarySearchTreeNode(10);

        root.setLeft(new BinarySearchTreeNode(12));
        root.setRight(new BinarySearchTreeNode(15));
        root.getLeft().setLeft(new BinarySearchTreeNode(25));
        root.getLeft().setRight(new BinarySearchTreeNode(30));
        root.getRight().setLeft(new BinarySearchTreeNode(36));

        // convert to DLL
        BinaryTree2DoubleLinkedList(root);

        // Print the converted List
        printList(head);
    }

    // A simple recursive function to convert a given Binary tree
    // to Doubly Linked List
    // root --> Root of Binary Tree
    public  static void BinaryTree2DoubleLinkedList(BinarySearchTreeNode root)
    {
        // Base case
        if (root == null)
            return;

        // Recursively convert left subtree
        BinaryTree2DoubleLinkedList(root.getLeft());

        // Now convert this node
        if (prev == null)
            head = root;
        else
        {
            root.setLeft(prev);
            prev.setRight(root);
        }
        prev = root;

        // Finally convert right subtree
        BinaryTree2DoubleLinkedList(root.getRight());
    }

    /* print nodes in a given doubly linked list */
    public static void printList(BinarySearchTreeNode node)
    {
        while (node != null)
        {
            System.out.print(node.getData()+ " ");
            node = node.getRight();
        }
    }

}

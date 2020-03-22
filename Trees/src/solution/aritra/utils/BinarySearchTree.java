package solution.aritra.utils;

import solution.aritra.tree.defs.BinarySearchTreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Perform the following on a binary search tree
 * -> Find element
 * -> Find min element
 * -> Find max element
 * -> Insert an element
 * -> Delete an element
 * -> Check if its a BST or not
 * -> Find kth smallest
 * -> Sort elements
 */

public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTreeNode root = createTree();
        System.out.println("Initial tree");
        displayTree(root);
        BinarySearchTreeNode foundNode = find(root,11);
        BinarySearchTreeNode foundNode2 = findNonRecursive(root,11);
        if(null != foundNode)
            System.out.println(foundNode.getData());
        if(null != foundNode2)
            System.out.println(foundNode2.getData());

        System.out.println("The minimum element in the above tree = " + findMinimumRecursive(root).getData());

        System.out.println("The minimum element in the above tree = " + findMinimumNonRecursive(root).getData());

        System.out.println("The maximum element in the above tree = " + findMaximumRecursive(root).getData());

        System.out.println("The maximum element in the above tree = " + findMaximumNonRecursive(root).getData());

        System.out.println("Inserting 8 in the above tree");

        root = insert(root,8);

        System.out.println("After insertion the tree is");

        displayTree(root);

        System.out.println("Deleting 8 from the tree");

        root = delete(root,8);

        displayTree(root);
    }

    //deletion is based on the following algorithm
    //-> If the element to be deleted is a leaf node, return null to its parent. That means make the corresponding
    //   child pointer NULL.
    //-> If the element to be deleted has one child, we just need to send the current node's child to its parent.
    //-> If the element to be deleted has both children, then the key is to replace the key of this node with the
    //   largest node in the left subtree and then delete that node from the left subtree. The largest node in the
    //   left subtree cannot have a right child otherwise it is not BST anyway.
    public static BinarySearchTreeNode delete(BinarySearchTreeNode root, int data){
        BinarySearchTreeNode temp;
        if(root == null)
            System.out.println("Element not found");
        else if(data < root.getData())
            root.setLeft(delete(root.getLeft(),data));
        else if(data > root.getData())
            root.setRight(delete(root.getRight(),data));
        else{ //found element
            if(root.getLeft() != null && root.getRight() != null){
                //replace with largest in the left subtree
                temp = findMaximumRecursive(root.getLeft());
                root.setData(temp.getData());
                root.setLeft(delete(root.getLeft(),root.getData()));
            }else{ //one child
                temp = root;
                if(root.getLeft() == null)
                    root = root.getRight();
                else if(root.getRight() == null)
                    root = root.getLeft();
            }
        }
        return root;
    }

    //insert data into the BST
    public static BinarySearchTreeNode insert(BinarySearchTreeNode root, int data){
        if(root == null){
            root = new BinarySearchTreeNode(data);
        }else{
            if(data < root.getData())
                root.setLeft(insert(root.getLeft(),data));
            else if(data > root.getData())
                root.setRight(insert(root.getRight(),data));
        }
        return root;
    }

    //recursive
    public static BinarySearchTreeNode find(BinarySearchTreeNode root, int data){
        if(root == null)
            return null;
        if(data < root.getData())
            return find(root.getLeft(),data);
        else if(data > root.getData())
            return find(root.getRight(),data);
        return root;
    }

    //non recursive
    public static BinarySearchTreeNode findNonRecursive(BinarySearchTreeNode root, int data){
        if(root == null)
            return null;
        while(root != null){
            if(data == root.getData())
                return root;
            else if(data > root.getData())
                root = root.getRight();
            else
                root = root.getLeft();
        }
        return null;
    }
    //recursive
    //min is the leftmost node with no left child
    public static BinarySearchTreeNode findMinimumRecursive(BinarySearchTreeNode root){
        if(root == null)
            return null;
        else
            if(root.getLeft() == null)
                return root;
            else return findMinimumRecursive(root.getLeft());
    }
    //non recursive
    //min is the leftmost node with no left child
    public static BinarySearchTreeNode findMinimumNonRecursive(BinarySearchTreeNode root){
        if(root == null)
            return null;
        while(root.getLeft() != null)
            root = root.getLeft();
        return root;
    }

    //recursive
    //max is the rightmost node with no right child
    public static BinarySearchTreeNode findMaximumRecursive(BinarySearchTreeNode root){
        if(root == null)
            return null;
        else
            if(root.getRight() == null)
                return root;
            else
                return findMaximumRecursive(root.getRight());
    }

    //non recursive
    //max is the rightmost node with no right child
    public static BinarySearchTreeNode findMaximumNonRecursive(BinarySearchTreeNode root){
        if(root == null)
            return null;
        while(root.getRight() != null)
            root = root.getRight();
        return root;
    }

    public static BinarySearchTreeNode createTree(){
        /*
        BST Looks like following:
                            7
                          /   \
                         4    11
                        / \   / \
                       2   5 9  13
         */
        BinarySearchTreeNode nodeSeven = new BinarySearchTreeNode(7);
        BinarySearchTreeNode nodeFour = new BinarySearchTreeNode(4);
        BinarySearchTreeNode nodeNine = new BinarySearchTreeNode(9);
        BinarySearchTreeNode nodeTwo = new BinarySearchTreeNode(2);
        BinarySearchTreeNode nodeFive = new BinarySearchTreeNode(5);
        BinarySearchTreeNode nodeEleven = new BinarySearchTreeNode(11);
        BinarySearchTreeNode nodeThirteen = new BinarySearchTreeNode(13);


        nodeSeven.setLeft(nodeFour);
        nodeSeven.setRight(nodeEleven);

        nodeFour.setLeft(nodeTwo);
        nodeFour.setRight(nodeFive);

        nodeEleven.setLeft(nodeNine);
        nodeEleven.setRight(nodeThirteen);
        return nodeSeven;
    }

    public static void displayTree(BinarySearchTreeNode root){
        Queue<BinarySearchTreeNode> q = new LinkedList<BinarySearchTreeNode>();
        q.offer(root);
        q.offer(null);
        ArrayList<Integer> row = new ArrayList<Integer>();
        while(!q.isEmpty()){
            BinarySearchTreeNode tmp = q.poll();
            if(tmp != null){
                row.add(tmp.getData());
                if(tmp.getLeft() != null){
                    q.offer(tmp.getLeft());
                }
                if(tmp.getRight() != null){
                    q.offer(tmp.getRight());
                }
            }else{ //this means row finished, now print it out
                Iterator<Integer> iter = row.iterator();
                while(iter.hasNext()){
                    System.out.print(" " + iter.next());
                }
                System.out.println();
                row.clear();
                if(!q.isEmpty()){
                    q.offer(null); //put marker for the next row
                }
            }
        }
    }
}

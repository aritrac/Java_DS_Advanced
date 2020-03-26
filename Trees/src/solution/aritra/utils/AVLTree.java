package solution.aritra.utils;

import solution.aritra.tree.defs.AVLTreeNode;

/**
 * Author: Aritra Chatterjee
 * Problem: Perform the following operations on AVL tree
 * -> Height of AVL tree
 * -> LL Rotation
 * -> RR Rotation
 * -> LR Rotation
 * -> RL Rotation
 * -> Insertion into AVL
 * Description:
 */
public class AVLTree {
    public static void main(String[] args) {

    }

    public static int height(AVLTreeNode root){
        if(root == null)
            return -1;
        else
            return root.getHeight(); //as the parent root contains its height which is the height of the tree
    }
    /*                          LL Rotation (two trees from left will shift to right)
                            X                W
                           / \              / \
                          W   C  ==>       A   X
                         / \                  / \
                        A   B                B   C
     */

    public static AVLTreeNode singleRotateLeft(AVLTreeNode X){
        AVLTreeNode W = X.getLeft();
        X.setLeft(W.getRight());
        W.setRight(X);
        X.setHeight(Math.max(height(X.getLeft()), height(X.getRight())) + 1);
        W.setHeight(Math.max(height(W.getLeft()),X.getHeight()) + 1);
        return W; //new root
    }

    /*
             RR Rotation (2 trees from right will shift to left)
                        W              X
                       / \            / \
                      A   X    =>    W   C
                         / \        / \
                        B   C      A   B
     */
    public static AVLTreeNode singleRotateRight(AVLTreeNode W){
        AVLTreeNode X = W.getRight();
        W.setRight(X.getLeft());
        X.setLeft(W);
        W.setHeight(Math.max(height(W.getRight()), height(W.getLeft())) + 1);
        X.setHeight(Math.max(height(X.getRight()),W.getHeight()) + 1);
        return X;
    }

    /*
            LR Rotation (Perform Right rotation at X, then perform Left rotation at Z)
                            Z                                             Z
                           / \                                           / \
                          /   \     ==> Right rotation @X ==>           /   \
                         X     D                                       Y     D
                        / \                                           / \
                       A   Y                                         X   C
                          / \                                       / \
                         B   C                                     A   B

                                                                         || Left rotation @Z

                                                                         Y
                                                                        / \
                                                                       /   \
                                                                      X     Z
                                                                     / \   / \
                                                                    A   B  C  D
     */
    public static AVLTreeNode doubleRotateWithLeft(AVLTreeNode Z){
        Z.setLeft(singleRotateRight(Z.getLeft()));
        return singleRotateLeft(Z);
    }

    /*
            RL Rotation (Perform left rotation at Z, then perform right rotation at X)
                        X                                                X
                       / \                                              / \
                      /   \                                            /   \
                     A     Z        ==> Left rotation @Z ==>          A     Y
                          / \                                              / \
                         Y   D                                            B   Z
                        / \                                                  / \
                       B   C                                                C   D
                                                                         || Right rotation @X

                                                                         Y
                                                                        / \
                                                                       /   \
                                                                      X     Z
                                                                     / \   / \
                                                                    A   B C   D
     */
    public static AVLTreeNode doubleRotateWithRight(AVLTreeNode X){
        X.setRight(singleRotateLeft(X.getRight()));
        return singleRotateRight(X);
    }

    public static AVLTreeNode insert(AVLTreeNode root, AVLTreeNode parent, int data){
        if(root == null){
            root = new AVLTreeNode();
            root.setData(data);
            root.setHeight(0);
            root.setLeft(null);
            root.setRight(null);
        }else if(data < root.getData()){
            root.setLeft(insert(root.getLeft(),root,data));
            if(height(root.getLeft()) - height(root.getRight()) == 2){
                if(data < root.getLeft().getData())
                    root = singleRotateLeft(root);
                else
                    root = doubleRotateWithLeft(root);
            }
        }else if(data > root.getData()){
            root.setRight(insert(root.getRight(),root,data));
            if(height(root.getRight()) - height(root.getLeft()) == 2){
                if(data < root.getRight().getData())
                    root =singleRotateRight(root);
                else
                    root=doubleRotateWithRight(root);
            }
        }
        //else data is in the tree already. We will do nothing
        root.setHeight(Math.max(height(root.getLeft()),height(root.getRight())) + 1);
        return root;
    }
}

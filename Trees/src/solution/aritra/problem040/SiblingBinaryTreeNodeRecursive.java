package solution.aritra.problem040;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a binary tree with three pointers (left, right and nextSibling) give an algorithm for filling
 * the nextSibling pointers assuming they are NULL initially. Preferably use a recursive solution.
 * Description: We will use preorder traversal to fill the next sibling pointer to point to the adjacent node
 * on the same level to the right of the current node.Before we pass the left and right to the recursion function
 * itself, we connect the right child's nextSibling to the current node's nextSibling left child. In order for this
 * to work, the current node nextSibling pointer must be populated, which is true in this case.
 */
public class SiblingBinaryTreeNodeRecursive {
    public int data;
    public SiblingBinaryTreeNodeRecursive left;
    public SiblingBinaryTreeNodeRecursive right;
    public SiblingBinaryTreeNodeRecursive nextSibling;

    public SiblingBinaryTreeNodeRecursive(int data){
        this.data = data;
        left = null;
        right = null;
        nextSibling = null;
    }

    public SiblingBinaryTreeNodeRecursive(int data, SiblingBinaryTreeNodeRecursive left, SiblingBinaryTreeNodeRecursive right, SiblingBinaryTreeNodeRecursive nextSibling){
        this.data = data;
        this.left = left;
        this.right = right;
        this.nextSibling = nextSibling;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }

    public SiblingBinaryTreeNodeRecursive getLeft(){
        return left;
    }

    public void setLeft(SiblingBinaryTreeNodeRecursive left){
        this.left = left;
    }

    public SiblingBinaryTreeNodeRecursive getRight(){
        return right;
    }

    public void setRight(SiblingBinaryTreeNodeRecursive right){
        this.right = right;
    }

    public SiblingBinaryTreeNodeRecursive getNextSibling(){
        return nextSibling;
    }

    public void setNextSibling(SiblingBinaryTreeNodeRecursive nextSibling){
        this.nextSibling = nextSibling;
    }

    //Sets the data in this BinaryTreeNode node.
    public void setValue(int data){
        this.data = data;
    }
    //Tests whether this node is a leaf node
    public boolean isLeaf(){
        return left == null && right == null;
    }

    public static void fillNextSiblings(SiblingBinaryTreeNodeRecursive root){
        if(root == null)
            return;
        if(root.getLeft() != null)
            root.getLeft().setNextSibling(root.getRight());
        if(root.getRight() != null){
            if(root.getNextSibling() != null)
                root.getRight().setNextSibling(root.getNextSibling().getLeft());
            else
                root.getRight().setNextSibling(null);
        }
        fillNextSiblings(root.getLeft());
        fillNextSiblings(root.getRight());
    }
}

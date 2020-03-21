package solution.aritra.problem039;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Given a binary tree with three pointers (left, right and nextSibling) give an algorithm for filling
 * the nextSibling pointers assuming they are NULL initially.
 * Description: We will use level order traversal to fill the next sibling pointer to point to the adjacent node
 * on the same level to the right of the current node.
 */
public class SiblingBinaryTreeNodeNonRecursive {
    public int data;
    public SiblingBinaryTreeNodeNonRecursive left;
    public SiblingBinaryTreeNodeNonRecursive right;
    public SiblingBinaryTreeNodeNonRecursive nextSibling;
    public SiblingBinaryTreeNodeNonRecursive(int data){
        this.data = data;
        left = null;
        right = null;
        nextSibling = null;
    }

    public SiblingBinaryTreeNodeNonRecursive(int data, SiblingBinaryTreeNodeNonRecursive left, SiblingBinaryTreeNodeNonRecursive right, SiblingBinaryTreeNodeNonRecursive nextSibling){
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

    public SiblingBinaryTreeNodeNonRecursive getLeft(){
        return left;
    }

    public void setLeft(SiblingBinaryTreeNodeNonRecursive left){
        this.left = left;
    }

    public SiblingBinaryTreeNodeNonRecursive getRight(){
        return right;
    }

    public void setRight(SiblingBinaryTreeNodeNonRecursive right){
        this.right = right;
    }

    public SiblingBinaryTreeNodeNonRecursive getNextSibling(){
        return nextSibling;
    }

    public void setNextSibling(SiblingBinaryTreeNodeNonRecursive nextSibling){
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

    public static void fillNextSiblings(SiblingBinaryTreeNodeNonRecursive root){
        SiblingBinaryTreeNodeNonRecursive tmp = null;
        if(root == null)
            return;
        //Initialization
        Queue<SiblingBinaryTreeNodeNonRecursive> q = new LinkedList<SiblingBinaryTreeNodeNonRecursive>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            tmp = q.poll();
            if(tmp != null){
                tmp.setNextSibling(q.peek());
                if(tmp.getLeft() != null)
                    q.offer(tmp.getLeft());
                if(tmp.getRight() != null)
                    q.offer(tmp.getRight());
            }else{
                //completion of a level
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
    }
}

package problem030;

/**
 * Author: Aritra Chatterjee
 * Problem: Provide the definition of a binary search tree node
 * Description: See the code below
 */
public class BinarySearchTreeNode {
    private int data;
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private BinarySearchTreeNode left;
    private BinarySearchTreeNode right;
    private BinarySearchTreeNode next;

    public BinarySearchTreeNode getNext() {
        return next;
    }

    public void setNext(BinarySearchTreeNode next) {
        this.next = next;
    }

    public BinarySearchTreeNode(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }
    public void setData(int data){
        this.data = data;
    }

    public BinarySearchTreeNode getLeft(){
        return left;
    }

    public void setLeft(BinarySearchTreeNode left){
        this.left = left;
    }

    public BinarySearchTreeNode getRight(){
        return right;
    }

    public void setRight(BinarySearchTreeNode right){
        this.right = right;
    }
}

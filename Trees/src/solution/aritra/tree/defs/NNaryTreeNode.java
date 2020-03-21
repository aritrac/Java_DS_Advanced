package solution.aritra.tree.defs;

/**
 * Author: Aritra Chatterjee
 * Problem: How to represent an N-Nary tree?
 * Description: We can do the following
 * -> At each node link children of same parent(siblings) from left to right
 * -> Remove the links from parent to all children except the first child
 */
public class NNaryTreeNode {
    public int data;
    public NNaryTreeNode firstChild;
    public NNaryTreeNode nextSibling;

    public NNaryTreeNode(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }

    public NNaryTreeNode getFirstChild(){
        return firstChild;
    }

    public void setFirstChild(NNaryTreeNode firstChild){
        this.firstChild = firstChild;
    }

    public NNaryTreeNode getNextSibling(){
        return nextSibling;
    }
    public void setNextSibling(NNaryTreeNode nextSibling){
        this.nextSibling = nextSibling;
    }
}

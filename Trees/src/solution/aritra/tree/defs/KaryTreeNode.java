package solution.aritra.tree.defs;

public class KaryTreeNode{
    public int data;
    public KaryTreeNode[] child;
    public KaryTreeNode(int k){
        child = new KaryTreeNode[k];
    }
    public void setData(int dataInput){
        data = dataInput;
    }
    public int getChild(){
        return data;
    }
    public void setChild(int i, KaryTreeNode childNode){
        child[i] = childNode;
    }
    public KaryTreeNode getChild(int i){
        return child[i];
    }
}

package solution.aritra.utils.node.defs;

/**
 * A node representing a circular linked list node
 */
public class CLLNode {
    private int data;
    private CLLNode next;

    public CLLNode(int data){
        this.data = data;
        next = null;
    }

    public CLLNode(int data, CLLNode next){
        this.data = data;
        this.next = next;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }

    public CLLNode getNext(){
        return next;
    }

    public void setNext(CLLNode where){
        next = where;
    }
}

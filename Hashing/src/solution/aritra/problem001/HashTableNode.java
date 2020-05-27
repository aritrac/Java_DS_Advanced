package solution.aritra.problem001;

/**
 * Author: Aritra Chatterjee
 */

public class HashTableNode {
    private int blockCount;
    private ListNode startNode;
    private ListNode next;

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getBlockCount(){
        return blockCount;
    }
    public void setBlockCount(int blockCount){
        this.blockCount = blockCount;
    }
    public ListNode getStartNode(){
        return startNode;
    }
    public void setStartNode(ListNode startNode){
        this.startNode = startNode;
    }
}

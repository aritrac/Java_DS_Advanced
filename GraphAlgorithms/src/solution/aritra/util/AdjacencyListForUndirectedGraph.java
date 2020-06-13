package solution.aritra.util;

import java.util.ArrayList;

/**
 * Author: Aritra Chatterjee
 * Problem: Show graph declaration for adjacency list
 * Description: See the implementation below
 */
public class AdjacencyListForUndirectedGraph {
    private ArrayList<Integer> vertices;
    private LinkedList[] edges;
    private int vertexCount = 0;
    public AdjacencyListForUndirectedGraph(int vertexCount){
        this.vertexCount = vertexCount;
        vertices = new ArrayList<Integer>();
        edges = new LinkedList[vertexCount];
        for(int i = 0; i < vertexCount; i++){
            vertices.add(i);
            edges[i].insert(0,0);
        }
    }
    public void addEdge(int source, int destination){
        int i = vertices.indexOf(source);
        int j = vertices.indexOf(destination);
        if(i != -1 || j != -1){
            edges[i].insertAtBegin(new ListNode(destination));
            edges[j].insertAtBegin(new ListNode(source));
        }
    }
}

class ListNode {
    private int data;
    private ListNode next;
    public ListNode(int data){
        this.data = data;
    }
    public void setData(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }
    public void setNext(ListNode next){
        this.next = next;
    }
    public ListNode getNext(){
        return this.next;
    }
}


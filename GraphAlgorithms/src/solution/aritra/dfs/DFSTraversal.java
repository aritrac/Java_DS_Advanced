package solution.aritra.dfs;

import java.util.Stack;

/**
 * Author: Aritra Chatterjee
 * Problem: Demonstrate the DFS traversal in a graph
 * Description: Initially all vertices are marked unvisited or false. The DFS algorithm starts at a vertex u in the graph
 * By starting at vertex u, it considers the edges from u to other vertices. If the edge leads to an aleady visited
 * vertex, then backtrack to current vertex u. If an edge leads to an unvisited vertex, then go to that vertex and
 * start processing from that vertex. That means the new vertex becomes the current vertex. Follow this process until
 * we reach the dead end. At this point, start back tracking.
 */
public class DFSTraversal {
    private final int maxVertices = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Stack<Integer> theStack;
    public DFSTraversal(){
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for(int y = 0; y < maxVertices; y++){
            for(int x = 0;x < maxVertices; x++){
                adjMatrix[x][y] = 0;
            }
        }
        theStack = new Stack();
    }
    public void addVertex(char lab){
        vertexList[vertexCount++] = new Vertex(lab);
    }
    public void addEdge(int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }
    public void displayVertex(int v){
        System.out.println(vertexList[v].label);
    }
    public void dfs(){
        vertexList[0].visited = true;
        displayVertex(0);
        theStack.push(0);
        while(!theStack.isEmpty()){
            //get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex(theStack.peek());
            if(v == -1)
                theStack.pop();
            else{
                vertexList[v].visited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        for(int j = 0;j < vertexCount; j++) //reset flags
            vertexList[j].visited = false;
    }
    public int getAdjUnvisitedVertex(int v){
        for(int j = 0;j < vertexCount; j++){
            if(adjMatrix[v][j] == 1 && vertexList[j].visited == false)
                return j;
        }
        return -1;
    }
}
class Vertex{
    public char label;
    public boolean visited;
    public Vertex(char lab){
        label = lab;
        visited = false;
    }
}

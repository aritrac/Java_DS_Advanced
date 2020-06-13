package solution.aritra.bfs;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Author: Aritra Chatterjee
 * Problem: Demonstrate BFS Traversal in a graph
 * Description: In the first stage it visits all vertices at level 1(that means, vertices whose distance is 1 from
 * the start vertex of the graph). In the second stage, it visits all vertices at second level. These new vertices
 * are the ones which are adjacent to level 1 vertices. BFS continues this process until all the levels of the graph
 * are completed. Generally queue data structure is used for storing the vertices of a level. As similar to DFS,
 * assume that initially all vertices are marked unvisited (false), Vertices that have been processed and removed
 * from the queue are marked visited (true). We use a queue to represent the visited set as it will keep the
 * vertices in the order of when they were first visited. The implementation for the above discussion can be given as
 * below:
 */
public class BFSTraversal {
    private final int maxVertices = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Queue<Integer> theQueue;

    public BFSTraversal(){
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for(int y = 0; y < maxVertices; y++){
            for(int x = 0; x < maxVertices; x++){
                adjMatrix[x][y] = 0;
            }
        }
        theQueue = new PriorityQueue<>();
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
    public void bfs(){
        vertexList[0].visited = true;
        displayVertex(0);
        theQueue.offer(0);
        int v2;
        while(!theQueue.isEmpty()){
            int v1 = theQueue.remove();
            while((v2=getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].visited = true;
                displayVertex(v2);
                theQueue.offer(v2);
            }
        }
    }
    public int getAdjUnvisitedVertex(int v){
        for(int j=0;j<vertexCount; j++){
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

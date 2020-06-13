package solution.aritra.util;

/**
 * Author: Aritra Chatterjee
 * Problem: Show the implementation of adjacency matrix for an undirected graph
 * Description: See the implementation below
 */
public class AdjacencyMatrixForUndirectedGraph {
    private boolean[][] adjMatrix;
    private int vertexCount;

    public AdjacencyMatrixForUndirectedGraph(int vertexCount){
        this.vertexCount = vertexCount;
        adjMatrix = new boolean[vertexCount][vertexCount];
    }

    public void addEdge(int i,int j){
        if(i >= 0 && i < vertexCount && j > 0 && j < vertexCount){
            adjMatrix[i][j] = true;
            adjMatrix[j][i] = true;
        }
    }

    public void removeEdge(int i, int j){
        if(i >= 0 && i < vertexCount && j > 0 && j < vertexCount){
            adjMatrix[i][j] = false;
            adjMatrix[j][i] = false;
        }
    }

    public boolean isEdge(int i, int j){
        if(i >= 0 && i < vertexCount && j > 0 && j < vertexCount)
            return adjMatrix[i][j];
        else
            return false;
    }
}

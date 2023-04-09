package course;

import java.util.*;

class Vertex {
    public int Value;
    public boolean Hit;
    public Vertex(int val)
    {
        Value = val;
        Hit = false;
    }
}

class SimpleGraph {
    Vertex[] vertex;
    int[][] m_adjacency;
    int max_vertex;
    ArrayList<Vertex> currentPath;

    public SimpleGraph(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex[size];
        currentPath = new ArrayList<>();
    }

    public void AddVertex(int value) {
        for (int i = 0; i < max_vertex; i++) {
            if (vertex[i] == null) {
                vertex[i] = new Vertex(value);
                return;
            }
        }
    }

    public void RemoveVertex(int v) {
        if (v < 0 || v >= max_vertex || vertex[v] == null) {
            return;
        }
        vertex[v] = null;
        for (int i = 0; i < max_vertex; i++) {
            m_adjacency[v][i] = 0;
            m_adjacency[i][v] = 0;
        }
    }

    public boolean IsEdge(int v1, int v2) {
        if (v1 >= 0 && v1 < max_vertex && v2 >= 0 && v2 < max_vertex) {
            return m_adjacency[v1][v2] == 1;
        }
        return false;
    }

    public void AddEdge(int v1, int v2) {
        if (v1 >= 0 && v1 < max_vertex && v2 >= 0 && v2 < max_vertex) {
            m_adjacency[v1][v2] = 1;
            m_adjacency[v2][v1] = 1;
        }
    }

    public void RemoveEdge(int v1, int v2) {
        if (v1 >= 0 && v1 < max_vertex && v2 >= 0 && v2 < max_vertex) {
            m_adjacency[v1][v2] = 0;
            m_adjacency[v2][v1] = 0;
        }
    }

    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo) {
        Queue<ArrayList<Vertex>> queue = new LinkedList<>();  // Create a queue to store paths
        ArrayList<Vertex> startPath = new ArrayList<>();  // Create the initial path
        startPath.add(vertex[VFrom]);
        queue.add(startPath);  // Add the initial path to the queue
        boolean[] visited = new boolean[max_vertex]; // Create an array to store visited vertices

        while (!queue.isEmpty()) {  // While the queue is not empty
            ArrayList<Vertex> currentPath = queue.poll();  // Dequeue the current path
            Vertex currentVertex = currentPath.get(currentPath.size() - 1);  // Get the current vertex from the end of the path
            visited[GetIndex(currentVertex)] = true;  // Mark the current vertex as visited

            if (currentVertex == vertex[VTo]) {  // If the current vertex is the destination vertex
                return currentPath;  // Return the current path
            }

            for (int i = 0; i < max_vertex; i++) {  // Loop through all vertices
                if (m_adjacency[GetIndex(currentVertex)][i] == 1 && !visited[i]) {  // If the vertex is adjacent and unvisited
                    ArrayList<Vertex> newPath = new ArrayList<>(currentPath);  // Create a new path from the current path
                    newPath.add(vertex[i]);  // Add the adjacent vertex to the new path
                    queue.add(newPath);  // Add the new path to the queue
                }
            }
        }

        return new ArrayList<>();  // Return an empty path if no path is found
    }

    private int GetIndex(Vertex vertex) {
        for (int i = 0; i < max_vertex; i++) {
            if (this.vertex[i] == vertex) {
                return i;
            }
        }
        return -1;
    }


}



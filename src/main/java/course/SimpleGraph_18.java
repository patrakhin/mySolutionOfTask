package course;

import java.util.*;

class Vertex_18 {
    public int Value;
    public boolean Hit;
    public Vertex_18(int val)
    {
        Value = val;
        Hit = false;
    }
}

class SimpleGraph_18 {
    Vertex_18[] vertex18s;
    int[][] m_adjacency;
    int max_vertex;
    ArrayList<Vertex_18> currentPath;

    public SimpleGraph_18(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex18s = new Vertex_18[size];
        currentPath = new ArrayList<>();
    }

    public void AddVertex(int value) {
        for (int i = 0; i < max_vertex; i++) {
            if (vertex18s[i] == null) {
                vertex18s[i] = new Vertex_18(value);
                return;
            }
        }
    }

    public void RemoveVertex(int v) {
        if (v < 0 || v >= max_vertex || vertex18s[v] == null) {
            return;
        }
        vertex18s[v] = null;
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

    public ArrayList<Vertex_18> BreadthFirstSearch(int VFrom, int VTo) {
        Queue<ArrayList<Vertex_18>> queue = new LinkedList<>();  // Create a queue to store paths
        ArrayList<Vertex_18> startPath = new ArrayList<>();  // Create the initial path
        startPath.add(vertex18s[VFrom]);
        queue.add(startPath);  // Add the initial path to the queue
        boolean[] visited = new boolean[max_vertex]; // Create an array to store visited vertices

        while (!queue.isEmpty()) {  // While the queue is not empty
            ArrayList<Vertex_18> currentPath = queue.poll();  // Dequeue the current path
            Vertex_18 currentVertex18 = currentPath.get(currentPath.size() - 1);  // Get the current vertex from the end of the path
            visited[GetIndex(currentVertex18)] = true;  // Mark the current vertex as visited

            if (currentVertex18 == vertex18s[VTo]) {  // If the current vertex is the destination vertex
                return currentPath;  // Return the current path
            }

            for (int i = 0; i < max_vertex; i++) {  // Loop through all vertices
                if (m_adjacency[GetIndex(currentVertex18)][i] == 1 && !visited[i]) {  // If the vertex is adjacent and unvisited
                    ArrayList<Vertex_18> newPath = new ArrayList<>(currentPath);  // Create a new path from the current path
                    newPath.add(vertex18s[i]);  // Add the adjacent vertex to the new path
                    queue.add(newPath);  // Add the new path to the queue
                }
            }
        }

        return new ArrayList<>();  // Return an empty path if no path is found
    }

    private int GetIndex(Vertex_18 vertex18) {
        for (int i = 0; i < max_vertex; i++) {
            if (this.vertex18s[i] == vertex18) {
                return i;
            }
        }
        return -1;
    }


}



package course;

import java.util.*;

class Vertex_17 {
    public int Value;
    public boolean Hit;
    public Vertex_17(int val)
    {
        Value = val;
        Hit = false;
    }
}

class SimpleGraph_17 {
    Vertex_17[] vertex;
    int[][] m_adjacency;
    int max_vertex;

    public SimpleGraph_17(int size) {
        max_vertex = size;
        m_adjacency = new int[size][size];
        vertex = new Vertex_17[size];
    }

    public void AddVertex(int value) {
        for (int i = 0; i < max_vertex; i++) {
            if (vertex[i] == null) {
                vertex[i] = new Vertex_17(value);
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

    public ArrayList<Vertex_17> DepthFirstSearch(int VFrom, int VTo) {
        Stack<Vertex_17> stack = new Stack<>();
        ArrayList<Vertex_17> path = new ArrayList<>();

        // Reset Hit flag for all vertices
        for (Vertex_17 v : vertex) {
            if (v != null) {
                v.Hit = false;
            }
        }
        if (VFrom == VTo) {
            return path;
        }

        // Push starting vertex onto stack
        Vertex_17 start = vertex[VFrom];
        stack.push(start);
        start.Hit = true;

        while (!stack.empty()) {
            Vertex_17 current = stack.peek();

            // If the current vertex is the target vertex, build and return the path
            if (current.Value == vertex[VTo].Value) {
                while (!stack.empty()) {
                    path.add(stack.pop());
                }
                Collections.reverse(path);
                return path;
            }

            // Look for an unvisited adjacent vertex
            boolean found = false;
            for (int i = 0; i < max_vertex; i++) {
                if (m_adjacency[current.Value][i] == 1 && !vertex[i].Hit) {
                    found = true;
                    Vertex_17 next = vertex[i];
                    stack.push(next);
                    next.Hit = true;
                    break;
                }
            }

            // If no unvisited adjacent vertex was found, pop the current vertex from the stack
            if (!found) {
                stack.pop();
            }
        }

        // If the target vertex was not found, return an empty path
        return path;
    }

}


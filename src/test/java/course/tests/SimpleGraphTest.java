package course.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleGraphTest {
    private SimpleGraph graph;

    @BeforeEach
    void setUp() {
        graph = new SimpleGraph(5);
    }

    @Test
    void addVertex() {
        graph.AddVertex(1);
        assertFalse(graph.IsEdge(1, 1), "Vertex should not have any edges");

    }

    @Test
    void removeVertex() {
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(1, 2);
        assertTrue(graph.IsEdge(1, 2), "Edge should exist before removing vertex 1");
        graph.RemoveVertex(1);
        assertFalse(graph.IsEdge(1, 2), "Vertex 1 should not exist after removing it");
        assertFalse(graph.IsEdge(1, 2), "Edge should not exist after removing vertex 1");
    }

    @Test
    void addEdge() {
        graph.AddVertex(1);
        graph.AddVertex(2);
        assertFalse(graph.IsEdge(1, 2), "Edge should not exist before adding it");
        graph.AddEdge(1, 2);
        assertTrue(graph.IsEdge(1, 2), "Edge should exist after adding it");
    }

    @Test
    void removeEdge() {
        graph.AddVertex(1);
        graph.AddVertex(2);
        graph.AddEdge(1, 2);
        assertTrue(graph.IsEdge(1, 2), "Edge should exist before removing it");
        graph.RemoveEdge(1, 2);
        assertFalse(graph.IsEdge(1, 2), "Edge should not exist after removing it");
    }
}
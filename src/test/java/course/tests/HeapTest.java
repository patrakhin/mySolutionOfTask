package course.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeapTest {

    private Heap heap;

    @BeforeEach
    void setUp() {
        heap = new Heap();
    }

    @Test
    void testMakeHeap() {
        int[] a = {5, 2, 9, 1, 7, 6, 8, 3, 4};
        int depth = 3;
        int[] expected = {9, 7, 8, 4, 2, 5, 6, 1, 3, -1, -1, -1, -1, -1, -1};
        heap.MakeHeap(a, depth);
        Assertions.assertArrayEquals(expected, heap.HeapArray);
    }

    @Test
    void testGetMax() {
        int[] a = {5, 2, 9, 1, 7, 6, 8, 3, 4};
        int depth = 3;
        heap.MakeHeap(a, depth);
        int max = heap.GetMax();
        Assertions.assertEquals(9, max);
    }

    @Test
    void testAdd() {
        int[] a = {5, 2, 9, 1, 7, 6, 8, 3, 4};
        int depth = 3;
        heap.MakeHeap(a, depth);
        boolean added = heap.Add(10);
        Assertions.assertTrue(added);
    }

    @Test
    void testSiftUp() {
        int[] a = {5, 2, 9, 1, 7, 6, 8, 3, 4};
        int depth = 3;
        heap.MakeHeap(a, depth);
        heap.HeapArray[9] = 10;
        heap.SiftUp(9);
        Assertions.assertArrayEquals(new int[]{10, 9, 8, 4, 7, 5, 6, 1, 3, 2, -1, -1, -1, -1, -1}, heap.HeapArray);
    }

    @Test
    void testSiftDown() {
        int[] a = {5, 2, 9, 1, 7, 6, 8, 3, 4};
        int depth = 3;
        heap.MakeHeap(a, depth);
        heap.HeapArray[0] = 1;
        heap.SiftDown(0);
        Assertions.assertArrayEquals(new int[]{8, 7, 6, 4, 2, 5, 1, 1, 3, -1, -1, -1, -1, -1, -1}, heap.HeapArray);
    }
}

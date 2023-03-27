package course;

import java.util.*;

class Heap
{
    public int [] HeapArray; // store non-negative key numbers

    public Heap() { HeapArray = null; }

    public void MakeHeap(int[] a, int depth)
    {
        int heapSize = (int) Math.pow(2, depth + 1) - 1;
        HeapArray = new int[heapSize];

        Arrays.fill(HeapArray, -1);

        for (int i = 0; i < a.length; i++) {
            HeapArray[i] = a[i];
            SiftUp(i);
        }
    }

    public int GetMax()
    {
        if (HeapArray == null || HeapArray[0] == -1) {
            return -1;
        }

        int max = HeapArray[0];
        HeapArray[0] = HeapArray[HeapArray.length - 1];
        HeapArray[HeapArray.length - 1] = -1;

        SiftDown(0);

        return max;
    }

    public boolean Add(int key)
    {
        if (HeapArray == null) {
            return false;
        }

        int i = HeapArray.length - 1;

        while (i >= 0 && HeapArray[i] != -1) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        HeapArray[i] = key;
        SiftUp(i);

        return true;
    }

    private void SiftUp(int i)
    {
        int parent = (i - 1) / 2;

        while (i > 0 && HeapArray[parent] < HeapArray[i]) {
            int tmp = HeapArray[parent];
            HeapArray[parent] = HeapArray[i];
            HeapArray[i] = tmp;

            i = parent;
            parent = (i - 1) / 2;
        }
    }

    private void SiftDown(int i)
    {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        if (leftChild < HeapArray.length && HeapArray[leftChild] > HeapArray[largest]) {
            largest = leftChild;
        }

        if (rightChild < HeapArray.length && HeapArray[rightChild] > HeapArray[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int tmp = HeapArray[i];
            HeapArray[i] = HeapArray[largest];
            HeapArray[largest] = tmp;

            SiftDown(largest);
        }
    }
}


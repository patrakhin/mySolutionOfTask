package course;

import java.util.*;

public class AlgorithmsDataStructures2 {
    public static int[] GenerateBBSTArray(int[] a) {
        // Sort the input array in ascending order
        Arrays.sort(a);

        // Create an output array of the same size as the input array
        int[] result = new int[a.length];

        // Recursively generate the BST array
        generateBBSTArray(a, result, 0, a.length - 1, 0);

        return result;
    }

    // Recursive helper function to generate the BST array
    private static void generateBBSTArray(int[] a, int[] result, int startIndex, int endIndex, int currentIndex) {
        if (startIndex > endIndex) {
            return;
        }

        // Find the midpoint index of the current range
        int midIndex = (startIndex + endIndex) / 2;

        // Add the midpoint element to the BST array
        result[currentIndex] = a[midIndex];

        // Recursively generate the left and right subtrees
        generateBBSTArray(a, result, startIndex, midIndex - 1, 2 * currentIndex + 1);
        generateBBSTArray(a, result, midIndex + 1, endIndex, 2 * currentIndex + 2);
    }
}

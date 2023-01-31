package task_general_type;

import java.util.*;

public class InitialImpulse {
    public  int[] getSortedArray(int lengthArray, int [] inputData) {
        if (inputData.length % 2 == 0) throw new AssertionError("Size's array is even!");
        List<Integer> transInputData = new ArrayList<>();
        for (int j: inputData) {
            transInputData.add(j);
        }
        Collections.sort(transInputData);
        int middleArray = (lengthArray - 1)/2;
        List<Integer> firstPat = new ArrayList<>();
        for (int k = 0; k < middleArray; k++) {
            firstPat.add(transInputData.get(k));
        }
        List<Integer> secondPat = new ArrayList<>();
        for (int j = lengthArray - 1; j >= middleArray; j--) {
            secondPat.add(transInputData.get(j));
        }
        firstPat.addAll(secondPat);
        int [] outputData = new int[firstPat.size()];
        for (int i = 0; i < firstPat.size(); i++) {
            outputData[i] = firstPat.get(i);
        }
        return outputData;
    }
}

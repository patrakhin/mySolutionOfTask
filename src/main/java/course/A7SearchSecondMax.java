package course;

import org.apache.log4j.Logger;

import java.util.*;
public class A7SearchSecondMax {
    private static final Logger logger = Logger.getLogger(A7SearchSecondMax.class);
    public static int getSecondMax (List<Integer> inputData, int firstMax, int secondMax, int indexOfList) {
        if (indexOfList >= inputData.size()) {
            return secondMax;
        }
        int nextNumber = inputData.get(indexOfList);
        if (nextNumber >= firstMax) {
            secondMax = firstMax;
            firstMax = nextNumber;
        }
        if (nextNumber < firstMax && nextNumber >=secondMax) {
            secondMax = nextNumber;
        }
        return getSecondMax(inputData, firstMax, secondMax, indexOfList + 1);
    }

    public static int findSecondMax(List<Integer> listOfSorted) {
        return getSecondMax(listOfSorted, Integer.MIN_VALUE, Integer.MIN_VALUE, 0);
    }

    public static void main(String[] args) {
        List<Integer> outPut = List.of(5, 8, 6, 4, 3, 9, 11);
        logger.debug(findSecondMax(outPut));
    }
}

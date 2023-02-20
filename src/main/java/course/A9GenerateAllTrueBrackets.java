package course;

import org.apache.log4j.Logger;

import java.util.*;

public class A9GenerateAllTrueBrackets {
    private static final Logger logger = Logger.getLogger(A9GenerateAllTrueBrackets.class);
    public static List<String> getAllTrueCombinations(int numberOfBrackets) {
        List<String> resultOfGenerations = new ArrayList<>();
        generatingCombos(numberOfBrackets, numberOfBrackets, "", resultOfGenerations);
        return resultOfGenerations;
    }

    private static void generatingCombos(int leftBracket, int rightBracket, String combination, List<String> resultOfGenerations) {
        if (leftBracket == 0 && rightBracket == 0) {
            resultOfGenerations.add(combination);
            return;
        }

        if (leftBracket > 0) {
            generatingCombos(leftBracket - 1, rightBracket, combination + "(", resultOfGenerations);
        }

        if (rightBracket > leftBracket) {
            generatingCombos(leftBracket, rightBracket - 1, combination + ")", resultOfGenerations);
        }
    }

    public static void main(String[] args) {
        int testValue = 3;
        logger.debug(getAllTrueCombinations(testValue));
    }

}

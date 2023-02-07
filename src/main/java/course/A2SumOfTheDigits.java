package course;

import org.apache.log4j.Logger;

public class A2SumOfTheDigits {
    private static final Logger logger = Logger.getLogger(A2SumOfTheDigits.class);
    public static int getSum (int inputValue) {
        String numberInput = String.valueOf(inputValue);
        Character firstElementNum = numberInput.charAt(0);
        if (firstElementNum.equals('-')) {
            numberInput = String.valueOf(inputValue * -1);
        }
        Character nextElementNum = numberInput.charAt(numberInput.length() - 1);
        int elementFromNumber = Integer.parseInt(String.valueOf(nextElementNum));
        char [] constructionString = numberInput.toCharArray();
        char [] outputConstruction = new char[constructionString.length - 1];
        int outNumber;
        if (constructionString.length == 1) {
            return elementFromNumber;
        }
        System.arraycopy(constructionString, 0, outputConstruction, 0, constructionString.length - 1);
        outNumber = Integer.parseInt(String.valueOf(outputConstruction));
        return elementFromNumber + getSum(outNumber);
    }

    public static void main(String[] args) {
        int a = -54321; // only for check logger, tests are present
        logger.debug(getSum(a));
    }
}

package course;

import org.apache.log4j.Logger;

public class A2SumOfTheDigits {
    private static final Logger logger = Logger.getLogger(A2SumOfTheDigits.class);
    public static int getSum (int inputValue) {
        if (inputValue < 0) {
            inputValue = inputValue * -1;
        }
        int nextElement = inputValue % 10;
        int nextNumber = inputValue / 10;
        if (nextNumber % 10 == 0) {
            return nextElement;
        }
        return nextElement + getSum(nextNumber);
    }

    public static void main(String[] args) {
        int a = 54321; // only for check logger, tests are present
        logger.debug(getSum(a));
    }
}

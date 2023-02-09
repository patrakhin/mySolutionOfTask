package course;

import org.apache.log4j.Logger;
import java.util.*;

public class A5PrintOnlyEvenValues {
    private static final Logger logger = Logger.getLogger(A5PrintOnlyEvenValues.class);

    public A5PrintOnlyEvenValues () {}

    public void getEventValues (List<Integer> inputData, int startIndex) {
        if (startIndex == inputData.size()) {
            return;
        }
        if (inputData.get(startIndex) % 2 == 0) {
            logger.debug(inputData.get(startIndex));
        }
        getEventValues(inputData, startIndex + 1);
    }
}

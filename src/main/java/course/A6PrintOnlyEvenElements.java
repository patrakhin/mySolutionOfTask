package course;
import org.apache.log4j.Logger;
import java.util.*;

public class A6PrintOnlyEvenElements {
    private static final Logger logger = Logger.getLogger(A6PrintOnlyEvenElements.class);
    private A6PrintOnlyEvenElements () {}
    public static void getEvenIndex (List<Integer> inputData, int startIndex) {
        if (startIndex == inputData.size()) {
            return;
        }
        if (startIndex % 2 == 0) {
            logger.debug(inputData.get(startIndex));
        }
        getEvenIndex(inputData, startIndex + 1);
    }
}

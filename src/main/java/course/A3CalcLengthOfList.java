package course;

import java.util.*;

public class A3CalcLengthOfList {
    private A3CalcLengthOfList () {}
    public static int getLengthOfList (LinkedList<Integer> inputList) {
        try {
            inputList.pop();
            return 1 + getLengthOfList(inputList);
        } catch (RuntimeException e) {
            return 0 ;
        }
    }
}

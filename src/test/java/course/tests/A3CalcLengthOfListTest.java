package course.tests;
import course.A3CalcLengthOfList;

import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class A3CalcLengthOfListTest {

    @org.junit.jupiter.api.Test
    void getLengthOfList() {
        LinkedList<Integer> build = new LinkedList<>();
        build.push(1);
        build.push(1);
        build.push(1);
        int actual = A3CalcLengthOfList.getLengthOfList(build);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getLengthOfList2() {
        LinkedList<Integer> build = new LinkedList<>();
        build.push(1);
        int actual = A3CalcLengthOfList.getLengthOfList(build);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getLengthOfList3() {
        LinkedList<Integer> build = new LinkedList<>();
        int actual = A3CalcLengthOfList.getLengthOfList(build);
        int expected = 0;
        assertEquals(expected, actual);
    }
}
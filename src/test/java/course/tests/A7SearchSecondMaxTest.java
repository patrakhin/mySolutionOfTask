package course.tests;

import course.A7SearchSecondMax;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class A7SearchSecondMaxTest {

    @Test
    void getSecondMax() {
        List<Integer> testList = List.of(1, 2, 3, 4, 4);
        int expected = 4;
        int actual = A7SearchSecondMax.findSecondMax(testList);
        assertEquals(expected, actual);
    }

    @Test
    void getSecondMax2() {
        List<Integer> testList = List.of(1, 2);
        int expected = 1;
        int actual = A7SearchSecondMax.findSecondMax(testList);
        assertEquals(expected, actual);
    }

    @Test
    void getSecondMax3() {
        List<Integer> testList = List.of(3, 2, 2);
        int expected = 2;
        int actual = A7SearchSecondMax.findSecondMax(testList);
        assertEquals(expected, actual);
    }

    @Test
    void getSecondMax4() {
        List<Integer> testList = List.of(3, 3, 3);
        int expected = 3;
        int actual = A7SearchSecondMax.findSecondMax(testList);
        assertEquals(expected, actual);
    }
}
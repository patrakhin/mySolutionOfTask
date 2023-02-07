package course.tests;

import course.A2SumOfTheDigits;

import static org.junit.jupiter.api.Assertions.assertEquals;

class A2SumOfTheDigitsTest {

    @org.junit.jupiter.api.Test
    void getSum() {
        int actual = A2SumOfTheDigits.getSum(654321);
        int expected = 21;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getSum2() {
        int actual = A2SumOfTheDigits.getSum(-54321);
        int expected = 15;
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getSum3() {
        int actual = A2SumOfTheDigits.getSum(0);
        int expected = 0;
        assertEquals(expected, actual);
    }
}
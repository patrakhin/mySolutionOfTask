package course.tests;

import course.A1Exponentiation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class A1ExponentiationTest {

    @Test
    void getPow() {
        int expected = 16;
        int actual = A1Exponentiation.getPow(2, 4);
        assertEquals(expected, actual);
    }

    @Test
    void getPow2() {
        int expected = 2;
        int actual = A1Exponentiation.getPow(2, 1);
        assertEquals(expected, actual);
    }

}
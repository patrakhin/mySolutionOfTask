package course.tests;
import course.A4CheckIfPalindrome;

import static org.junit.jupiter.api.Assertions.*;

class A4CheckIfPalindromeTest {

    @org.junit.jupiter.api.Test
    void isItPalindrome() {
        String testCheck = "abcdba";
        boolean actual = A4CheckIfPalindrome.isItPalindrome(testCheck, 0, testCheck.length() - 1);
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void isItPalindrome2() {
        String testCheck = "abba";
        boolean actual = A4CheckIfPalindrome.isItPalindrome(testCheck, 0, testCheck.length() - 1);
        assertTrue(actual);
    }

    @org.junit.jupiter.api.Test
    void isItPalindrome3() {
        String testCheck = "a";
        boolean actual = A4CheckIfPalindrome.isItPalindrome(testCheck, 0, 0);
        assertTrue(actual);
    }
}
package tasks_from_leetcode;

public class PrimePalindrome {
    public static boolean isPalindrome(String  candidateForSearch) {
        char[] charFromString = candidateForSearch.toCharArray();
        for (int i = 0; i < charFromString.length; i++) {
            if (charFromString[i] != charFromString[charFromString.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static int getPrimePalindrome(int n) {
        int secondNumber = n + 2;
        int countDivider = 0;
        boolean endNumber;
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 2;
        }
        if (n % 2 == 0) {
            n = n+1;
        }
        for ( ; n <= secondNumber; n+=2 ) {
            //this scope have not palindrome
            if (10000000 < n && n < 100000000) {
                n = 99999999;
                secondNumber = n + 2;
            }
            String exchangeFromInteger = String.valueOf(n);
            endNumber = isPalindrome(exchangeFromInteger);
            if (!endNumber) {
                secondNumber+=2;
                continue;
            }
            for (int i = 3; i < n ; i+=2) {
                if (n % i == 0) {
                    countDivider++;
                    break;
                }
            }
            if (countDivider == 0) {
                return n; //
            }
            countDivider = 0;
            secondNumber+=2;
        }
        return n;
    }
}

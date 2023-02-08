package course;

public class A4CheckIfPalindrome {
    private A4CheckIfPalindrome () {}
    public static boolean isItPalindrome (String checkWord, int startIndex, int finishIndex) {
        if (startIndex >= finishIndex) {
            return true;
        }
        if (checkWord.charAt(startIndex) != checkWord.charAt(finishIndex)) {
            return false;
        }
        return  isItPalindrome(checkWord, startIndex + 1, finishIndex - 1);
    }
}

package course;

public class A1Exponentiation {
    private A1Exponentiation () {}
    public static int getPow (int inputValue, int inputPowValue) {
        if (inputPowValue == 1) {
            return inputValue;
        }
        return inputValue * getPow(inputValue, inputPowValue - 1);
    }
}

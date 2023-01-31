package task_general_type;

import java.util.*;

public class UnlockPhone {
    static final String STRING_FOR_BREAK = "";
    static final double HORIZON_OR_FILE_DIST = 1.0;
    static final double DIAGONAL_DISTANCE = 1.414215;
    static final int [] VAL_PARIS_PHONE_KEY = {61, 16, 52, 25, 43, 34, 19, 91, 28, 82, 37, 73, 65, 56, 54, 45, 12, 21, 23, 32, 98, 89, 78, 87};
    static final int [] VAL_PARIS_DIAGONAL = new  int[] {62, 26, 51, 15, 42, 24, 35, 53, 29, 92, 18, 81, 38, 83, 27, 72};
    static final int NUMBER_OF_DECIMAL = 100000;
    static final char THIS_SYMBOL_FOR_MISS = '0';

    public static String getSeriesOfNumbLock(int lengthInputArray, int [] inputSeries) {
        ArrayList<Integer> arrayConvertedNumber = new ArrayList<>();
        StringBuilder stringConverted = new StringBuilder();
        int bufferConvertedNumber = 0;
        for (int i = 0; i < lengthInputArray; i++) {
            stringConverted.append(inputSeries[i]);
            for (int j = i+1; j < lengthInputArray; j++) {
                stringConverted.append(inputSeries[i + 1]);
                bufferConvertedNumber = Integer.parseInt(String.valueOf(stringConverted));
                arrayConvertedNumber.add(bufferConvertedNumber);
                stringConverted = new StringBuilder();
                if (stringConverted.toString().equals(STRING_FOR_BREAK))
                    break;
            }
        }
        HashMap <Integer, Double> rowMap = new HashMap<>();
        for (int rowNumber : VAL_PARIS_PHONE_KEY) {
            rowMap.put(rowNumber, HORIZON_OR_FILE_DIST);
        }
        HashMap <Integer, Double> diagonalMap = new HashMap<>();
        for (int diagonalNumber : VAL_PARIS_DIAGONAL) {
            diagonalMap.put(diagonalNumber, DIAGONAL_DISTANCE);
        }
        ArrayList<Double>  resultRow = new ArrayList<>();
        for (Integer item : arrayConvertedNumber) {
            if (rowMap.containsKey(item)) {
                resultRow.add(rowMap.get(item));
            }
        }
        ArrayList<Double> resultDiagonal = new ArrayList<>();
        for (Integer integer : arrayConvertedNumber) {
            if (diagonalMap.containsKey(integer)) {
                resultDiagonal.add(diagonalMap.get(integer));
            }
        }
        double sumRow = 0.0;
        for (Double value : resultRow) {
            sumRow = sumRow + value;
        }
        double sumDiagonal = 0.0;
        for (Double aDouble : resultDiagonal) {
            sumDiagonal = sumDiagonal + aDouble;
        }
        double allSum = sumRow + sumDiagonal;
        sumRow = - 100000.0;
        sumDiagonal = - 100000.0;
        int accurateValue = (int)(allSum * NUMBER_OF_DECIMAL);
        String cutValue = String.valueOf(accurateValue);
        char [] conversionValue = cutValue.toCharArray();
        StringBuilder bufferValue = new StringBuilder();
        for (char c : conversionValue) {
            if (c != THIS_SYMBOL_FOR_MISS) {
                bufferValue.append(c);
            }
        }
        return String.valueOf(bufferValue);
    }
}

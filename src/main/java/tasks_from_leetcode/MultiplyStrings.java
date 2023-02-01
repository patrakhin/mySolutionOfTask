package tasks_from_leetcode;

import java.util.*;

public class MultiplyStrings {
    public String getMultiply(String num1, String num2) {
        String out = "";
        if (num1.equals("0") || num2.equals("0")) {
            out = "0";
            return out;
        }
        HashMap<Character, Integer> translateMap = new HashMap<>();
        translateMap.put('0', 0);
        translateMap.put('1', 1);
        translateMap.put('2', 2);
        translateMap.put('3', 3);
        translateMap.put('4', 4);
        translateMap.put('5', 5);
        translateMap.put('6', 6);
        translateMap.put('7', 7);
        translateMap.put('8', 8);
        translateMap.put('9', 9);

        char[] arrayStartOne = num1.toCharArray();
        char[] arrayStartTwo = num2.toCharArray();
        int lengthOne = arrayStartOne.length;
        int lengthTwo = arrayStartTwo.length;
        int [] reloadDigitalOne = new int[lengthOne];
        int [] reloadDigitalTwo = new int[lengthTwo];
        int [] arrayMax = new int[lengthOne];
        int [] arrayMin = new int[lengthTwo];
        int buffer = 0;
        int [] arrayStorage = new int[400];
        int numberOne = 0;
        int numberTwo = 0;
        int lengthMax = 0;
        int lengthMin = 0;
        boolean isNewLoop = false;

        for (int i = 0; i < lengthOne; i++) {
            reloadDigitalOne[i] = translateMap.get(arrayStartOne[i]);
        }
        for (int j = 0; j < lengthTwo; j++) {
            reloadDigitalTwo[j] = translateMap.get(arrayStartTwo[j]);
        }

        if (lengthOne > lengthTwo){
            lengthMax = lengthOne;
            lengthMin = lengthTwo;
            arrayMax = new int[reloadDigitalOne.length];
            arrayMin = new int[reloadDigitalTwo.length];
            System.arraycopy(reloadDigitalOne,0,arrayMax,0, reloadDigitalOne.length);
            System.arraycopy(reloadDigitalTwo,0,arrayMin,0, reloadDigitalTwo.length);
        }
        if (lengthOne <= lengthTwo) {
            lengthMax = lengthTwo;
            lengthMin = lengthOne;
            arrayMin = new int[reloadDigitalOne.length];
            arrayMax = new int[reloadDigitalTwo.length];
            System.arraycopy(reloadDigitalTwo,0,arrayMax,0, reloadDigitalTwo.length);
            System.arraycopy(reloadDigitalOne,0,arrayMin,0, reloadDigitalOne.length);
        }

        int countLoop = 0;
        for (int i = lengthMin - 1; i >= 0; i--) {
            countLoop = (lengthMin - i) - 2;
            for (int j = lengthMax - 1; j >= 0; j--) {
                countLoop++;
                buffer = (arrayMin[i] * arrayMax[j]) + arrayStorage[countLoop];
                arrayStorage[countLoop] = 0;
                numberOne = buffer % 10;
                numberTwo = buffer / 10; //memory
                arrayStorage[countLoop] = arrayStorage[countLoop] + numberOne;
                arrayStorage[countLoop + 1] =  arrayStorage[countLoop + 1] + numberTwo;
            }
        }
        for (int i = arrayStorage.length - 1; i >= 0; i--) {
            if ((arrayStorage[i] == 0) && !isNewLoop) {
                continue;
            }
            out = out + arrayStorage[i];
            isNewLoop = true;
        }
        return out;
    }
}

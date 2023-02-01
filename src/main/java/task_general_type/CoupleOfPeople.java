package task_general_type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class CoupleOfPeople {
    public static List<String> getCoupleOfPeople (int testCaseCount, List<int[]> dataDeveloper) {
        List<String> coupleOfPeople = new ArrayList<>();
        for (int f = 0; f < testCaseCount; f++) {
            int [] developersLevel = dataDeveloper.get(f);
            int [] sequenceNumber = new int[developersLevel.length];
            for (int i = 0; i < sequenceNumber.length; i++) {
                sequenceNumber[i] = i + 1;
            }
            int absMin = 101;
            int indexValue = 0;

            for (int j = 0; j < developersLevel.length; j++) {
                if (developersLevel[j] == 0) {
                    continue;
                }
                for (int k = j + 1; k < developersLevel.length; k++) {
                    if (developersLevel[k] == 0) {
                        continue;
                    }
                    int differenceLevel = Math.abs(developersLevel[j] - developersLevel[k]);
                    if (differenceLevel < absMin) {
                        absMin = differenceLevel;
                        indexValue = k;
                    }
                }
                coupleOfPeople.add(sequenceNumber[j] + " " + sequenceNumber[indexValue]);
                developersLevel[j] = 0;
                developersLevel[indexValue] = 0;
                absMin = 101;
            }
            if (f + 1 < testCaseCount) {
                coupleOfPeople.add(" ");
            }
        }
        return coupleOfPeople;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());
        ArrayList<int[]> dataDevelopers = new ArrayList<>();
        int [] developersLevel;
        for (int i = 0; i < testCaseCount; i++) {
            int countItems = Integer.parseInt(reader.readLine());
            String[] lineItems = reader.readLine().split(" ");
            developersLevel = new int[countItems];
            for (int k = 0; k < lineItems.length; k++) {
                developersLevel[k] = Integer.parseInt(lineItems[k]);
            }
            dataDevelopers.add(developersLevel);
        }
        List<String> newList;
        newList = getCoupleOfPeople(testCaseCount, dataDevelopers);
        for (String s : newList) {
            System.out.println(s);
        }
    }
}

package task_general_type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PurchaseSum {
    public static List<Integer> getPurchaseSum (int testCaseCount, List<int[]> dataPurchase) {
        List<Integer> purchaseSum = new ArrayList<>();
        for (int j = 0; j < testCaseCount; j++) {
            HashMap<Integer, Integer> priceMap = new HashMap<>();
            List<Integer> allKeys = new ArrayList<>();
            int [] inputData = dataPurchase.get(j);
            for (int inputDatum : inputData) {
                if (priceMap.containsKey(inputDatum)) {
                    priceMap.put(inputDatum, (priceMap.get(inputDatum) + 1));
                    continue;
                }
                priceMap.put(inputDatum, 1);
                allKeys.add(inputDatum);
            }
            int purchaseSumPutArray = 0;
            for (int i = 0; i < priceMap.size(); i++) {
                purchaseSumPutArray = purchaseSumPutArray + (((priceMap.get(allKeys.get(i))) - ((priceMap.get(allKeys.get(i))) / 3)) * allKeys.get(i));
            }
            purchaseSum.add(purchaseSumPutArray);
        }
        return purchaseSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());
        ArrayList<int[]> dataPurchase = new ArrayList<>();
        int [] listPrise;
        for (int i = 0; i < testCaseCount; i++) {
            int countItems = Integer.parseInt(reader.readLine());
            String[] lineItems = reader.readLine().split(" ");
            listPrise = new int[countItems];
            for (int k = 0; k < lineItems.length; k++) {
                listPrise[k] = Integer.parseInt(lineItems[k]);
            }
            dataPurchase.add(listPrise);
        }
        List<Integer> theEndSum = getPurchaseSum(testCaseCount, dataPurchase);
        for (int j = 0; j < testCaseCount; j++) {
            System.out.println(theEndSum.get(j));
        }

    }
}

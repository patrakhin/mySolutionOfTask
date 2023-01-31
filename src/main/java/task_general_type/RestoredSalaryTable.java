package task_general_type;

import java.util.*;

public class RestoredSalaryTable {
    public static int[] getRecoveredTable(int N, int [] ids, int [] salary) {
        if (N != ids.length && N != salary.length) throw new AssertionError("Size's array is even!");
        List<Integer> idsSortedByIncrease = new ArrayList<>();
        for (int i: ids) {
            idsSortedByIncrease.add(i);
        }
        Collections.sort(idsSortedByIncrease);
        List<Integer> salarySortByIncrease = new ArrayList<>();
        for (int j: salary) {
            salarySortByIncrease.add(j);
        }
        Collections.sort(salarySortByIncrease);
        HashMap<Integer, Integer> unionTableIdsAndSal = new HashMap<>();
        for (int k = 0; k < N; k++) {
            unionTableIdsAndSal.put(idsSortedByIncrease.get(k), salarySortByIncrease.get(k));
        }
        int [] recoveredSalaryTable = new int[salary.length];
        for(int i = 0; i < N; i++) {
            recoveredSalaryTable[i] = unionTableIdsAndSal.get(ids[i]);
        }
        return recoveredSalaryTable;
    }
}

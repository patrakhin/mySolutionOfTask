package tasks_from_leetcode;

import java.util.*;

public class RescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        int[] sortedDesc = Arrays.stream(people)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        List<Integer> reloadPeople = new ArrayList<>();
        for (int person : sortedDesc) {
            reloadPeople.add(person);
        }
        int count = 0;
        for (int i = 0; i < people.length; i++) {
            count = count + getCountBoars(reloadPeople, limit);
            if (reloadPeople.size() == 1) {
                count++;
                break;
            }
        }
        return count;
    }

    private static int getCountBoars(List<Integer> reloadPeople, int limit) {
        int numberOne = 0;
        int numberTwo = 0;
        numberOne = reloadPeople.get(0);
        numberTwo = reloadPeople.get(reloadPeople.size() - 1);
        if (reloadPeople.size() == 2 && (numberOne + numberTwo) > limit) {
            reloadPeople.remove(0);
            return 1;
        }
        if (reloadPeople.size() == 2 && (numberOne + numberTwo) <= limit) {
            reloadPeople.remove(0);
            return 0;
        }
        if ((numberOne + numberTwo) > limit) {
            reloadPeople.remove(0);
            return 1;
        }
        if ((numberOne + numberTwo) <= limit) {
            reloadPeople.remove(0);
            reloadPeople.remove(reloadPeople.size() - 1);
        }
        return 1;
    }
}

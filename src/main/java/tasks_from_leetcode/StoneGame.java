package tasks_from_leetcode;

import java.util.*;

public class StoneGame {
    public boolean isAliceWins (int[] piles) {
        int sumAllStones = Arrays.stream(piles).reduce(Integer::sum).getAsInt();
        int sumAllOfUnevenPiles = 0;
        for (int i = 0; i < piles.length; i++) {
            if (i % 2 != 0) {
                sumAllOfUnevenPiles = sumAllOfUnevenPiles + piles[i];
            }
        }
        int difEvenAndUneven = sumAllStones - sumAllOfUnevenPiles;
        return piles.length % 2 == 0 || difEvenAndUneven <= sumAllOfUnevenPiles;
    }
}

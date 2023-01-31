package task_general_type;

//import org.apache.log4j.Logger;

public class WhiteWalkers {
    //private static final Logger log = Logger.getLogger(WhiteWalkers.class);
    public static final char THE_WHITE_WALKER = '=';
    public static final int SUM_NUM_FOR_DETECT = 10;
    public static final int THAT_ENOUGH_TO_TRAP = 3;

    public static int detectIntFromChar (char itemOfIncomingString) {
        return Integer.parseInt(Character.toString(itemOfIncomingString));
    }

    public static boolean catchInVillage(String village) {

        char [] transIncomingString = village.toCharArray();
        int walkersBeforePeasant = 0;
        int walkersNotYetCaught = 0;
        int walkersHiding = 0;
        int walkersBetweenPeasant = 0;
        int caughtWalkers = 0;
        int thisIndexOfNumber = 0;
        int thisPeasantOne = 0;
        int thisPeasantTwo = -1;
        boolean isThisCharDigit = false;
        boolean isThisAnyChar = false;

        for (int i = 0; i < village.length(); i++) {
            if (transIncomingString [i] != THE_WHITE_WALKER && !Character.isDigit(transIncomingString [i]) && !isThisAnyChar) {
                isThisAnyChar = true;
            }
            if (transIncomingString [i] == THE_WHITE_WALKER && !isThisCharDigit) {
                walkersBeforePeasant += 1;
                isThisAnyChar = false;
            }
            if (transIncomingString [i] == THE_WHITE_WALKER && isThisCharDigit) {
                walkersNotYetCaught += 1;
                isThisAnyChar = false;
            }
            if (Character.isDigit(transIncomingString [i]) && !isThisCharDigit) {
                thisPeasantOne = detectIntFromChar(transIncomingString [i]);
                isThisCharDigit = true;
                thisIndexOfNumber = i;
            }
            if (Character.isDigit(transIncomingString [i]) && i != thisIndexOfNumber && isThisCharDigit) {
                thisPeasantTwo = detectIntFromChar(transIncomingString [i]);
                walkersBetweenPeasant = walkersNotYetCaught;
                walkersNotYetCaught = 0;
            }
            if (isThisCharDigit && thisPeasantTwo > -1 && isThisAnyChar && walkersBetweenPeasant == 0) {
                isThisAnyChar = false;
                thisPeasantOne = thisPeasantTwo;
                thisPeasantTwo = -1;
            }
            if (((thisPeasantOne + thisPeasantTwo) != SUM_NUM_FOR_DETECT) && thisPeasantTwo > -1) {
                walkersHiding += 1;
                walkersBetweenPeasant = 0;
                thisPeasantOne = thisPeasantTwo;
                thisPeasantTwo = -1;
            }
            boolean isPeasantsWereFound = ((thisPeasantOne + thisPeasantTwo) == SUM_NUM_FOR_DETECT);
            boolean isEnoughToTrap = (walkersBetweenPeasant == THAT_ENOUGH_TO_TRAP);
            boolean isWalkersFew = (walkersBetweenPeasant != THAT_ENOUGH_TO_TRAP);
            if (isPeasantsWereFound && isEnoughToTrap && thisPeasantTwo > -1) {
                caughtWalkers += 1;
                walkersBetweenPeasant = 0;
                walkersHiding = 0;
                thisPeasantOne = thisPeasantTwo;
                thisPeasantTwo = -1;
            }
            if (isPeasantsWereFound && isWalkersFew && thisPeasantTwo > -1) {
                walkersHiding += 1;
                walkersBetweenPeasant = 0;
                thisPeasantOne = thisPeasantTwo;
                thisPeasantTwo = -1;
            }
        }

        boolean isWalkersCaught = (caughtWalkers != 0 && walkersBeforePeasant == 0 && walkersNotYetCaught == 0 && walkersHiding == 0 && walkersBetweenPeasant == 0);
        if (isWalkersCaught) {
            return true;
        }
        boolean isWalkersFled = (caughtWalkers != 0 && walkersHiding != 0 && walkersBeforePeasant == 0 && walkersNotYetCaught == 0 && walkersBetweenPeasant == 0);
        if (isWalkersFled) {
            return false;
        }
        boolean isWalkersDetected = (caughtWalkers != 0 && walkersBeforePeasant != 0 && walkersHiding != 0 && walkersNotYetCaught == 0 && walkersBetweenPeasant == 0);
        if (isWalkersDetected) {
            return true;
        }
        if (walkersBeforePeasant != 0 && walkersNotYetCaught == 0 && walkersHiding == 0 && walkersBetweenPeasant == 0) {
            return false;
        }
        return isThisCharDigit;
    }

    public static void main(String[] args) {
        String [] exampleString = {"axxb6===4xaf5===eee5", "5==ooooooo=5=5", "abc=7==hdjs=3gg1=======5", "aaS=8", "9===1===9===1===9"};
        for (String s : exampleString) {
            //log.debug(catchInVillage(s));
        }
    }
}

package tasks_from_leetcode;

public class Discount {
    public String getDiscountPrices(String sentence, int discount) {
        String [] splitIncoming = sentence.split(" ");
        boolean isNotDigit = false;
        char [] bufferForCheck;
        char bufChar;
        StringBuilder afterDelFirstChar = new StringBuilder();
        double numberFromString;
        double numberAfterDiscount;
        StringBuilder resultOut = new StringBuilder();
        for (int i = 0; i < splitIncoming.length; i++) {
            bufferForCheck = splitIncoming[i].toCharArray();
            if (bufferForCheck[0] != '$') {
                continue;
            }
            if (splitIncoming[i].length() == 1) {
                continue;
            }
            for (int k = 1; k < splitIncoming[i].length(); k++) {
                bufChar = splitIncoming[i].charAt(k);
                if (!Character.isDigit(bufChar)) {
                    isNotDigit = true;
                }
            }
            if (isNotDigit) {
                isNotDigit = false;
                continue;
            }

            for (int j = 1; j < splitIncoming[i].length(); j++) {
                afterDelFirstChar.append(splitIncoming[i].charAt(j));
            }
            numberFromString = Double.parseDouble(afterDelFirstChar.toString());
            numberAfterDiscount = (numberFromString - ((numberFromString / 100) * discount));
            splitIncoming[i] = "$" + String.format("%.2f",numberAfterDiscount);
            afterDelFirstChar = new StringBuilder();
        }
        for (int k = 0; k < splitIncoming.length; k++) {
            if (k == splitIncoming.length - 1) {
                resultOut.append(splitIncoming[k]);
                break;
            }
            resultOut.append(splitIncoming[k]).append(" ");
        }
        return resultOut.toString();
    }
}

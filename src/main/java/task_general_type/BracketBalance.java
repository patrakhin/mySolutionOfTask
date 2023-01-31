package task_general_type;
import  java.util.*;

public class BracketBalance {
    public static boolean checkBrackets (String brackets) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < brackets.length(); i++) {
            char buffer = brackets.charAt(i);
            if (buffer == '(') {
                stack.push(buffer);
            }
            if (buffer == ')' && stack.peek() == '(') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(BracketBalance.checkBrackets("(()((())()))"));
    }
}

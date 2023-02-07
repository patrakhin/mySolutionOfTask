package tasks_from_leetcode.singly_linked_list;

import java.util.*;

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     public static int getNumber (ListNode inputData) {
         StringBuilder sb = new StringBuilder();
         int numberFromInputData = 0;
         int rate = 1;
         ListNode temp = inputData;
         while (temp != null) {
             sb.append(temp.val);
             numberFromInputData = numberFromInputData + (temp.val * rate);
             rate = rate * 10;
             temp = temp.next;
         }
         return numberFromInputData;
     }

     public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int summandOne = getNumber(l1);
        int summandTwo = getNumber(l2);
        int additionOfNumbers = summandOne + summandTwo;
        ListNode dummy = new ListNode(0); // creating an dummy list
        ListNode curr = dummy; // initializing an pointer
        String addition = String.valueOf(additionOfNumbers);
        for (int i = addition.length() - 1; i >= 0; i--) {
            String buff = String.valueOf(addition.charAt(i));
            curr.next = new ListNode(Integer.parseInt(buff)); // curr will point to that new node if we get
            curr = curr.next; // update the current every time
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int numOne = 9;
        int numTwo = 4;
        int numThree = 3;
        ListNode l1 = new ListNode(numOne);
        //ListNode a2 = new ListNode(numTwo);
        //ListNode a3 = new ListNode(numThree);
        //ListNode l1 = new ListNode();
        //l1.val = a1.val;
       // l1.next = a2;
        //a2.next = a3;

        int numOne2 = 999999991;
        int numTwo2 = 9;
        int numThree21 = 9;
        int numThree22 = 9;
        int numThree23 = 9;
        int numThree24 = 9;
        int numThree25 = 9;
        int numThree26 = 9;
        int numThree27 = 9;
        int numThree28 = 1;


        ListNode l12 = new ListNode(numOne2);


        ListNode l333 = addTwoNumbers(l1, l12);

        StringBuilder sb = new StringBuilder("[");
        String sep = "";
        ListNode temp = l333;
        while (temp != null) {
            sb.append(sep).append(temp.val);
            temp = temp.next;
            sep = ", ";
        }
        sb.append(']');
        System.out.println(sb);

    }
}

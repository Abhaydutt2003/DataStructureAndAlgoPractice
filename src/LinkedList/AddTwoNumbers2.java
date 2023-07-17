package linkedList;

import java.util.*;

public class AddTwoNumbers2 {

    public static void main(String args[]) {

    }

    public static ListNode util1(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode temp = l1;
        while (temp != null) {
            s1.add(temp);
            temp = temp.next;
        }
        temp = l2;
        while (temp != null) {
            s2.add(temp);
            temp = temp.next;
        }
        return getAns(s1, s2);
    }

    public static ListNode getAns(Stack<ListNode> s1, Stack<ListNode> s2) {
        ListNode head = null;
        int carry = 0;
        while (s1.isEmpty() == false && s2.isEmpty() == false) {
            ListNode a = s1.pop();
            ListNode b = s2.pop();
            int currentNumber = a.val + b.val + carry;
            if (currentNumber > 9) {
                carry = currentNumber / 10;
                ListNode n = new ListNode(currentNumber % 10, head);
                head = n;
            } else {
                carry = 0;
                ListNode n = new ListNode(currentNumber, head);
                head = n;
            }
        }
        while (s1.isEmpty() == false) {
            ListNode a = s1.pop();
            int currentNumber = a.val + carry;
            if (currentNumber > 9) {
                carry = currentNumber / 10;
                ListNode n = new ListNode(currentNumber % 10, head);
                head = n;
            } else {
                carry = 0;
                ListNode n = new ListNode(currentNumber, head);
                head = n;
            }
        }
        while (s2.isEmpty() == false) {
            ListNode b = s2.pop();
            int currentNumber = b.val + carry;
            if (currentNumber > 9) {
                carry = currentNumber / 10;
                ListNode n = new ListNode(currentNumber % 10, head);
                head = n;
            } else {
                carry = 0;
                ListNode n = new ListNode(currentNumber, head);
                head = n;
            }
        }
        if (carry > 0) {
            ListNode n = new ListNode(carry, head);
            head = n;
        }
        return head;
    }

}

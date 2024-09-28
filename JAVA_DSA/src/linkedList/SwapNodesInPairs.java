package linkedList;

import java.util.*;

public class SwapNodesInPairs {

    public static void main(String args[]) {
        ListNode head = takeInput();
        head = util1(head);
        print(head);
    }

    public static void print(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        head = head.next;
        print(head);
    }

    public static ListNode util1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            ListNode temp2 = temp.next;
            temp.next = temp2.next;
            temp2.next = temp;
            prev.next = temp2;
            temp = temp.next;
            prev = temp2.next;
        }
        return dummy.next;
    }

    public static ListNode takeInput() {
        Scanner s = new Scanner(System.in);
        int val = s.nextInt();
        ListNode head = null;
        ListNode tail = null;
        while (val != -1) {
            ListNode temp = new ListNode(val);
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = tail.next;
            }
            val = s.nextInt();
        }
        s.close();
        return head;
    }

}

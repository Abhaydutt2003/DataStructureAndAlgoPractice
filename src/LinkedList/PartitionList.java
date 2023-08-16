package linkedList;

class lc86helper {
    ListNode smallerHead;
    ListNode smallerTail;
    ListNode biggerHead;
    ListNode biggerTail;
}

public class PartitionList {

    public static void main(String args[]) {

    }

    public static ListNode util1(ListNode head, int x) {
        helper(head, x);
        if (ans.biggerHead == null && ans.smallerHead == null) {
            return null;
        } else if (ans.biggerHead == null && ans.smallerHead != null) {
            return ans.smallerHead;
        } else if (ans.biggerHead != null && ans.smallerHead == null) {
            return ans.biggerHead;
        } else {
            ans.smallerTail.next = ans.biggerHead;
            return ans.smallerHead;
        }
    }

    static lc86helper ans = new lc86helper();

    public static void helper(ListNode head, int x) {
        if (head == null) {
            return;
        }
        ListNode temp = head.next;
        head.next = null;
        if (head.val >= x) {
            if (ans.biggerHead == null) {
                ans.biggerHead = head;
                ans.biggerTail = head;
            } else {
                ans.biggerTail.next = head;
                ans.biggerTail = head;
            }
        } else {
            if (ans.smallerHead == null) {
                ans.smallerHead = head;
                ans.smallerTail = head;
            } else {
                ans.smallerTail.next = head;
                ans.smallerTail = head;
            }
        }
        helper(temp, x);
    }

    // public static ListNode util1(ListNode head, int x) {
    // lc86helper ans = new lc86helper();
    // helper(head, x);
    // if (ans.biggerHead == null && ans.smallerHead != null) {
    // return ans.smallerHead;
    // } else if (ans.biggerHead != null && ans.smallerHead == null) {
    // return ans.biggerHead;
    // } else {
    // ans.smallerTail.next = ans.biggerHead;
    // return ans.smallerHead;
    // }
    // }

    // static lc86helper ans;

    // public static void helper(ListNode head, int x) {
    // if (head == null) {
    // return;
    // }
    // if (head.val >= x) {
    // if (ans.biggerHead == null) {
    // ans.biggerHead = head;
    // ans.biggerTail = head;
    // } else {
    // ans.biggerTail.next = head;
    // ans.biggerTail = ans.biggerTail.next;
    // }
    // } else {
    // if (ans.smallerHead == null) {
    // ans.smallerHead = head;
    // ans.smallerTail = head;
    // } else {
    // ans.smallerTail.next = head;
    // ans.smallerTail = ans.smallerTail.next;
    // }
    // }
    // helper(head.next, x);
    // }
}

package linkedList;

public class ReverseLinkedList2 {

    public static void main(String args[]) {

    }

    public static ListNode util1(ListNode head, int left, int right) {
        // build the part
        ListNode dummy = new ListNode(-1, head);
        ListNode revHead = head;
        ListNode revTail = head;
        ListNode temp1 = dummy;
        ListNode temp2 = dummy;
        ListNode temp = dummy;
        for (int index = 0; index <= right; index++) {
            if (index == left - 1) {
                temp1 = temp;
                revHead = temp.next;
            }
            if (index == right) {
                revTail = temp;
                temp2 = revTail.next;
            }
            temp = temp.next;
        }
        revTail.next = null;
        reverse(revHead);
        temp1.next = revTail;
        if (temp1 != temp2) {
            revHead.next = temp2;
        }
        ListNode ans = dummy.next;
        dummy.next = null;
        return ans;
    }

    // reverse linked list
    public static void reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return;
    }

}

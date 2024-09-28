package linkedList;

public class RemoveLinkedListElement {

    public static void main() {

    }

    public static ListNode remove(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode next = current.next;
        ListNode prev = null;
        while (current != null) {
            if (current.val == val && current == head) {
                head = next;
                prev = null;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            } else if (current.val == val) {
                prev.next = next;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            } else {
                prev = current;
                current = next;
                next = current.next;
            }
        }
        return head;
    }

}

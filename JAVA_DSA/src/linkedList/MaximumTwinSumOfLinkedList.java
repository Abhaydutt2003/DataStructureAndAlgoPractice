package linkedList;

import java.util.*;

public class MaximumTwinSumOfLinkedList {

    public static void main(String args[]) {
        
    }

    public static int util1(ListNode head) {
        Deque<ListNode> dq = new ArrayDeque<>();
        ListNode temp = head;
        while (temp != null) {
            dq.addLast(temp);
            temp = temp.next;
        }
        int ans = Integer.MIN_VALUE;
        while (dq.isEmpty() == false) {
            ListNode leftNode = dq.removeFirst();
            ListNode rightNode = dq.removeLast();
            int candidate = leftNode.val + rightNode.val;
            ans = Math.max(ans, candidate);
        }
        return ans;
    }

}

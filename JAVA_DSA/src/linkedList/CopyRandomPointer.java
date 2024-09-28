package linkedList;

import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomPointer {

    public static void main(String args[]) {

    }

    // iterative O(1) space code
    public static Node util2(Node head) {
        Node temp = head;
        while (temp != null) {
            Node newNext = new Node(temp.val);
            newNext.next = temp.next;
            temp.next = newNext;
            temp = newNext.next;
        }
        temp = head;
        while (temp != null) {
            Node toJoinWith = temp.random;
            if (toJoinWith != null) {
                toJoinWith = toJoinWith.next;
            }
            temp = temp.next;
            temp.random = toJoinWith;
            temp = temp.next;
        }
        Node newHead = head.next;
        Node temp1 = head;
        Node temp2 = head.next;
        while (temp1 != null) {
            temp1.next = temp2.next;
            temp1 = temp1.next;
            if (temp2.next == null) {
                break;
            }
            temp2.next = temp2.next.next;
            temp2 = temp2.next;
        }
        return newHead;
    }

    // very easy
    public static Node util1(Node head) {
        hm = new HashMap<>();
        return helper(head);
    }

    static HashMap<Node, Node> hm;

    public static Node helper(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        hm.put(head, newHead);
        newHead.next = helper(head.next);
        if (head.random == null) {
            newHead.random = null;
        } else {
            newHead.random = hm.get(head.random);
        }
        return newHead;
    }

}

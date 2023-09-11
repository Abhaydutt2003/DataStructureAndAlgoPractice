package linkedList;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

class lc430Helper {
    Node head;
    Node tail;
}

public class FlattenDoublyLinkedList {

    public static void main(String args[]) {

    }

    // combination of iteration and recursion

    public static lc430Helper util1(Node head) {
        Node dummy = new Node();
        dummy.next = head;
        Node temp = dummy;
        while (temp.next != null) {
            temp = temp.next;
            if (temp.child == null) {
                continue;
            } else {
                lc430Helper bottom = util1(temp.child);
                Node temp2 = temp.next;
                temp.child = null;
                temp.next = bottom.head;
                bottom.head.prev = temp;
                bottom.tail.next = temp2;
                if (temp2 != null) {
                    temp2.prev = bottom.tail;
                }
                temp = bottom.tail;
            }
        }
        lc430Helper ans = new lc430Helper();
        dummy.next = null;
        ans.head = head;
        ans.tail = temp;
        return ans;
    }

}

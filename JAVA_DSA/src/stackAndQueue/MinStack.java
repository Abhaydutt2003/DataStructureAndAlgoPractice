package stackAndQueue;

class stackNode {
    int min;
    int val;
    stackNode next;
}

public class MinStack {

    stackNode head;
    stackNode tail;
    int size;

    public MinStack() {
        head = null;
        tail = null;
    }

    public void push(int val) {
        stackNode sn = new stackNode();
        sn.val = val;
        if (head == null) {
            sn.min = val;
            head = sn;
            tail = sn;
        } else {
            int m = Math.min(tail.min, val);
            sn.min = m;
            sn.next = tail;
            tail = sn;
        }
    }

    public void pop() {
        if (tail.next == null) {
            head = null;
            tail = null;
        } else {
            stackNode temp = tail.next;
            tail.next = null;
            tail = temp;
        }
    }

    public int top() {
        return tail.val;
    }

    public int getMin() {
        return tail.min;
    }

}

package StackAndQueues;

import java.util.*;

class MyStack {

    int size;
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        size = 0;
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        size++;
        q1.add(x);
    }

    public int pop() {
        fillReverse(q1, q2);
        int popped = q2.poll();
        size--;
        fillReverse(q2, q1);
        return popped;
    }

    private static void fillReverse(Queue<Integer> queue1, Queue<Integer> queue2) {
        if (queue1.isEmpty() == false) {
            return;
        }
        int temp = queue1.poll();
        fillReverse(queue1, queue2);
        queue2.add(temp);
    }

    public int top() {
        fillReverse(q1, q2);
        int p = q2.peek();
        fillReverse(q2, q1);
        return p;
    }

    public boolean empty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
}

public class StackUsingQueues {

    public static void main(String args[]) {

    }

}

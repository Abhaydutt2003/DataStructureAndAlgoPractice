package StackAndQueues;

import java.util.*;

class CustomStack {

    private int[] lazy;
    private Stack<Integer> s;
    final private int maxSize;

    public CustomStack(int maxSize) {
        s = new Stack<>();
        this.maxSize = maxSize;
        lazy = new int[maxSize];
    }

    public void push(int x) {
        if (s.size() < maxSize) {
            s.push(x);
        }
    }

    public int pop() {
        if (s.isEmpty()) {
            return -1;
        } else {
            int index = s.size() - 1;
            if (index > 0) {
                lazy[index - 1] += lazy[index];
            }
            int ans = s.pop() + lazy[index];
            lazy[index] = 0;
            return ans;
        }
    }

    public void increment(int k, int val) {
        int a = Math.min(k, s.size()) - 1;
        if (a >= 0) {
            lazy[a] += val;
        }
    }
}

public class StackWithIncrementOperation {

}

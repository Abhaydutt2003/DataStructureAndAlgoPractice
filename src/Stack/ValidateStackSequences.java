package StackAndQueues;

import java.util.*;

public class ValidateStackSequences {

    public static void main(String args[]) {

    }

    public static boolean util1(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0, k = 0; i < pushed.length; i++) {
            s.push(pushed[i]);
            while ((s.isEmpty() == false) && (s.peek() == popped[k])) {
                s.pop();
                k++;
            }
        }
        return s.isEmpty();
    }

}

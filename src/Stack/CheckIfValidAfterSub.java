package StackAndQueues;

import java.util.Stack;

public class CheckIfValidAfterSub {

    public static void main(String args[]) {
        String s = "aabcbc";
        System.out.print(util1(s));
    }

    public static boolean util1(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
            if (s.peek() == 'c' && s.size() >= 3) {
                char c = s.pop();
                char b = s.pop();
                char a = s.pop();
                if (c == 'c' && b == 'b' && a == 'a') {
                    // i do not need to do anything
                } else {
                    return false;
                }
            } else if (s.peek() == 'c') {
                return false;
            }
        }
        if (s.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}

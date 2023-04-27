package StackAndQueues;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String args[]) {
        String s = "()[]{";
        System.out.print(util1(s));
    }

    public static boolean util1(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '[') {
                s.push(str.charAt(i));
            } else {
                char current = s.peek();
                if (current == '{' && str.charAt(i) == '}') {
                    s.pop();
                } else if (current == '[' && str.charAt(i) == ']') {
                    s.pop();
                } else if (current == '(' && str.charAt(i) == ')') {
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty() == true) {
            return true;
        } else {
            return false;
        }
    }

}

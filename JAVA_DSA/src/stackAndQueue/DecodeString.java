package stackAndQueue;

import java.util.*;

public class DecodeString {

    public static void main(String args[]) {
        String s = "10[leetcode]";
        System.out.print(decode2(s));
    }

    public static String decode(String str) {
        Stack<String> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            String a = str.substring(i, i + 1);
            if (a.equals("]")) {
                String toDup = "";
                while (s.peek().equals("[") == false) {
                    String toAdd = s.pop();
                    toDup = toAdd + toDup;
                }
                s.pop();
                int dupAmt = Integer.parseInt(s.pop());
                String willPut = "";
                for (int j = 0; j < dupAmt; j++) {
                    willPut = willPut + toDup;
                }
                s.push(willPut);
            } else {
                s.push(a);
            }
        }
        String ans = "";
        while (s.isEmpty() == false) {
            ans = s.pop() + ans;
        }
        return ans;
    }

    public static String decode2(String str) {
        Stack<Integer> forDup = new Stack<>();
        Stack<StringBuilder> forWords = new Stack<>();
        StringBuilder temp = new StringBuilder();
        int dupAmt = 0;
        for (int i = 0; i < str.length(); i++) {
            Character current = str.charAt(i);
            if (Character.isDigit(current)) {
                dupAmt = dupAmt * 10;
                int toAdd = current - '0';
                dupAmt += toAdd;
            } else if (Character.isAlphabetic(current)) {
                temp.append(current);
            } else if (current == '[') {
                forDup.push(dupAmt);
                forWords.push(temp);
                dupAmt = 0;
                temp = new StringBuilder();
            } else {
                int count = forDup.pop();
                StringBuilder prev = forWords.pop();
                String duped = "";
                for (int j = 0; j < count; j++) {
                    duped += temp;
                }
                prev.append(duped);
                temp = prev;
            }
        }
        return temp.toString();
    }

}

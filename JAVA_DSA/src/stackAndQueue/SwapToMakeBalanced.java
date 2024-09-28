package stackAndQueue;

import java.util.*;

public class SwapToMakeBalanced {

    public static void main(String args[]) {
        String str = "]]][[[";
        System.out.print(util1(str));
    }

    public static int util1(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                s.push(str.charAt(i));
            } else {
                if (s.isEmpty() == false && s.peek() == '[') {
                    s.pop();
                } else {
                    s.push(str.charAt(i));
                }
            }
        }
        double pairs = s.size() / 2;
        double a = pairs / 2.0;
        int ans = (int) Math.ceil(a);
        return ans;
    }

}

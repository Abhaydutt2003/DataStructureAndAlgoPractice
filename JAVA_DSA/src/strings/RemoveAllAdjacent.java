package strings;

import java.util.*;

class lc1047 {
    String removed;
    String c;

    lc1047(String removed, String c) {
        this.removed = removed;
        this.c = c;
    }
}

public class RemoveAllAdjacent {

    public static void main(String args[]) {
        String a = "abbaca";
        System.out.print(util5(a));
    }

    public static String util5(String s) {
        Stack<String> stk = new Stack<>();
        while (s.length() != 0) {
            String firstLetter = s.substring(0, 1);
            s = s.substring(1);
            if (stk.isEmpty() == true) {
                stk.push(firstLetter);
            } else {
                if (stk.peek().equals(firstLetter)) {
                    stk.pop();
                } else {
                    stk.push(firstLetter);
                }
            }
        }
        String ans = "";
        while (stk.isEmpty() == false) {
            ans = stk.pop() + ans;
        }
        return ans;
    }

    // corect recursive approach
    public static String util4(int startIndex, String str) {
        for (int i = startIndex; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                String afterRemoval = str.substring(0, i) + str.substring(i + 2);
                if (i == 0) {
                    startIndex = 0;
                } else {
                    startIndex = i - 1;
                }
                return util4(startIndex, afterRemoval);
            }
        }
        return str;
    }

    // wrong
    public static String util3(String str) {
        lc1047 ans = getAns(str);
        return ans.removed;
    }

    public static lc1047 getAns(String str) {
        if (str.length() == 1) {
            return new lc1047(str, str);
        }
        String firstLetter = str.substring(0, 1);
        lc1047 rem = getAns(str.substring(1));
        if (rem.c.equals(firstLetter)) {
            if (rem.removed.length() != 0) {
                if (rem.removed.substring(0, 1) == firstLetter) {
                    String s = rem.removed.substring(0, 1);
                    return new lc1047(s, rem.c);
                } else {
                    return new lc1047(rem.removed, rem.c);
                }
            } else {
                return new lc1047(rem.removed, rem.c);
            }
        } else {
            String s = firstLetter + rem.removed;
            return new lc1047(s, firstLetter);
        }
    }

    // for test case = "abbaca"
    // expected = "ca"
    // giving = "abaca%"
    public static String util1(String str) {
        String ans = "";
        ans += str.substring(0, 1);
        String remaning = getRem(str.substring(0, 1), str.substring(1));
        ans += remaning;
        return ans;
    }

    public static String getRem(String prev, String str) {
        if (str.length() == 0) {
            return "";
        }
        String firstLetter = str.substring(0, 1);
        if (prev.equals(firstLetter)) {
            return getRem(prev, str.substring(1));
        } else {
            String removed = getRem(firstLetter, str.substring(1));
            String ans = firstLetter + removed;
            return ans;
        }
    }

    // another incorrect method
    public static String util2(String str) {
        if (str.length() == 1) {
            return str;
        }
        String firstLetter = str.substring(0, 1);
        String removed = util2(str.substring(1));
        String remfirstLetter = removed.substring(0, 1);
        if (firstLetter.equals(remfirstLetter)) {
            return removed.substring(1);
        } else {
            String toReturn = firstLetter + removed;
            return toReturn;
        }
    }

}

package StackAndQueues;

import java.util.*;

class lc32Helper {
    char bracket;
    int index;

    lc32Helper(char bracket, int index) {
        this.bracket = bracket;
        this.index = index;
    }
}

public class LongestValidParentheses {

    public static void main(String agrs[]) {
        String str = ")()()(";
        System.out.print(util3(str));
    }

    static int dp[];

    public static int util1(String str) {
        dp = new int[str.length()];
        fillDp(str);
        int ans = 0;
        int currentLength = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 0) {
                currentLength = 0;
            } else {
                currentLength++;
                ans = Math.max(ans, currentLength);
            }
        }
        return ans;
    }

    private static void fillDp(String str) {
        Stack<lc32Helper> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                s.push(new lc32Helper(str.charAt(i), i));
            } else if (str.charAt(i) == ')' && s.isEmpty() == false) {
                if (s.peek().bracket == '(') {
                    dp[s.peek().index] = 1;
                    dp[i] = 1;
                    s.pop();
                }
            }
        }
    }

    // very smart approach
    public static int util2(String str) {
        int ans1 = leftTraversal(str);
        int ans2 = rightTraversal(str);
        return Math.max(ans1, ans2);
    }

    public static int leftTraversal(String str) {
        int left = 0;
        int right = 0;
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, (2 * left));
            } else if (right >= left) {
                left = right = 0;
            }
        }
        return ans;
    }

    public static int rightTraversal(String str) {
        int left = 0;
        int right = 0;
        int ans = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                ans = Math.max(ans, (2 * right));
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return ans;
    }

    public static int util3(String str) {
        int ans = 0;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                s.push(i);
            } else {
                s.pop();
                if (s.isEmpty() == true) {
                    s.push(i);
                } else {
                    int smallAns = i - s.peek();
                    ans = Math.max(ans, smallAns);
                }
            }
        }
        return ans;
    }

}

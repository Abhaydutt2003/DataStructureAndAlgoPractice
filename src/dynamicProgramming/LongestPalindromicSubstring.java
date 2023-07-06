package dynamicProgramming;

public class LongestPalindromicSubstring {
    public static void main(String args[]) {
        String s = "ababbbabbababa";
        System.out.print(longest(s));
    }

    // approach 1.....
    public static String longestPalindrome(String s) {
        String s1 = s;
        String s2 = new String();
        for (int i = 0; i < s1.length(); i++) {
            s2 = s1.charAt(i) + s2;
        }
        int length = LCS(s1, s2, s1.length(), s2.length());
        int i = 0, j = length - 1;
        while (j < s1.length()) {
            if (isPalindrome(i, j, s1)) {
                return s1.substring(i, j + 1);
            } else {
                i++;
                j++;
            }
        }
        return "";
    }

    private static boolean isPalindrome(int i, int j, String s1) {
        while (i < j) {
            if (s1.charAt(i) == s1.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static int LCS(String S1, String S2, int n, int m) {
        int t[][] = new int[n + 1][m + 1];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1] + 1;
                    ans = (ans > t[i][j]) ? ans : t[i][j];
                } else {
                    t[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        ans = (ans == Integer.MIN_VALUE) ? 0 : ans;
        return ans;
    }
    // 0 0 0 0 0 0
    // 0 0 0 1 0 1
    // 0 0 1 0 2 0
    // 0 0 0 2 0 3
    // 0 0 1 0 3 0
    // 0 1 0 0 0 0

    public static String longest(String s) {
        String reverse = new String();
        for (int i = 0; i < s.length(); i++) {
            reverse = s.charAt(i) + reverse;
        }
        int t[][] = new int[s.length() + 1][s.length() + 1];
        int max = Integer.MIN_VALUE, endingIndex = -1, n = s.length();
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                if (s.charAt(i - 1) == reverse.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1] + 1;
                }
                if (t[i][j] > max && i - t[i][j] == n - j) {
                    max = t[i][j];
                    endingIndex = i;
                }
            }
        }
        if (endingIndex == -1) {
            return "";
        }
        return s.substring(endingIndex - max, endingIndex);
    }

    // expand around center approach

    public static String util2(String str) {
        int start = 0;
        int maxLen = 0;
        int i = 0;
        while (i < str.length()) {
            if (str.length() - i < maxLen / 2) {// remaning string is of lesser size than the maxlen String
                break;
            }
            int leftIndex, rightIndex;
            leftIndex = rightIndex = i;
            // to take care of the same characters
            while (rightIndex < str.length() - 1 && str.charAt(rightIndex) == str.charAt(rightIndex + 1)) {
                rightIndex++;
            }
            i = rightIndex + 1;
            // now we will start to compare charcters at the left and right
            while (leftIndex > 0 && rightIndex < str.length() - 1
                    && str.charAt(leftIndex - 1) == str.charAt(rightIndex + 1)) {
                leftIndex--;
                rightIndex++;
            }
            int currentLength = rightIndex - leftIndex + 1;
            if (currentLength > maxLen) {
                maxLen = currentLength;
                start = leftIndex;
            }
        }
        String ans = str.substring(start, start + maxLen);
        return ans;
    }
}

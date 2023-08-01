package dynamicProgramming;

import java.util.*;

public class ASCIIDeleteSum {

    public static void main(String args[]) {

    }

    public static int util1(String s1, String s2) {
        hm = new HashMap<>();
        return helper(s1, s2);
    }

    public static int util2(String s1, String s2) {
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1, j = 0; i <= s1.length(); i++) {
            dp[i][j] = dp[i - 1][j] + ((int) s1.charAt(i - 1));
        }
        for (int j = 1, i = 0; j <= s2.length(); j++) {
            dp[i][j] = dp[i][j - 1] + ((int) s2.charAt(j - 1));
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int ans1 = dp[i - 1][j] + ((int) s1.charAt(i - 1));
                    int ans2 = dp[i][j - 1] + ((int) s2.charAt(j - 1));
                    dp[i][j] = Math.min(ans1, ans2);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    static HashMap<String, Integer> hm;

    // hate strings in java as much as you can
    public static int helper(String s1, String s2) {
        String key = s1 + "-" + s2;
        int ans = 0;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        if (s1.length() == 0 || s2.length() == 0) {
            if (s1.length() == 0 && s2.length() == 0) {
                ans = 0;
            } else if (s1.length() == 0 && s2.length() != 0) {
                for (int i = 0; i < s2.length(); i++) {
                    ans += (int) s2.charAt(i);
                }
            } else {
                for (int i = 0; i < s1.length(); i++) {
                    ans += (int) s1.charAt(i);
                }
            }
            hm.put(key, ans);
            return ans;
        }
        if (s1.charAt(0) == s2.charAt(0)) {
            ans = helper(s1.substring(1), s2.substring(1));
        } else {
            int ans1 = helper(s1.substring(1), s2) + ((int) s1.charAt(0));
            int ans2 = helper(s1, s2.substring(1)) + ((int) s2.charAt(0));
            ans = Math.min(ans1, ans2);
        }
        hm.put(key, ans);
        return ans;
    }

}

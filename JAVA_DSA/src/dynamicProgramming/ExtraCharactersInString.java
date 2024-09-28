package dynamicProgramming;

import java.util.*;

public class ExtraCharactersInString {

    public static void main(String args[]) {
        String[] dictionary = { "leet", "code" };
        String str = "leetscode";
        System.out.print(util2(str, dictionary));
    }

    static HashSet<String> hs;

    public static int util1(String s, String[] dictionary) {
        hs = new HashSet<>();
        for (String str : dictionary) {
            hs.add(str);
        }
        return check(s);
    }

    public static int check(String str) {
        if (str.length() == 1) {
            if (hs.contains(str)) {
                return 0;
            } else {
                return 1;
            }
        }
        if (hs.contains(str)) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < str.length() - 1; i++) {
            int left = check(str.substring(0, i + 1));
            int right = check(str.substring(i + 1));
            int smallAns = left + right;
            ans = Math.min(ans, smallAns);
        }
        return ans;
    }

    // with memo
    static HashMap<String, Integer> hm;

    public static int util2(String s, String[] dictionary) {
        hs = new HashSet<>();
        hm = new HashMap<>();
        for (String str : dictionary) {
            hs.add(str);
        }
        return check3(s);
    }

    public static int check2(String str) {
        if (str.length() == 1) {
            if (hs.contains(str)) {
                return 0;
            } else {
                return 1;
            }
        }
        if (hs.contains(str)) {
            return 0;
        }
        if (hm.containsKey(str)) {
            return hm.get(str);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < str.length() - 1; i++) {
            int left = check2(str.substring(0, i + 1));
            int right = check2(str.substring(i + 1));
            int smallAns = left + right;
            ans = Math.min(ans, smallAns);
        }
        hm.put(str, ans);
        return ans;
    }

    public static int check3(String str) {
        if (str.length() == 1) {
            if (hs.contains(str)) {
                return 0;
            } else {
                return 1;
            }
        }
        if (hs.contains(str)) {
            return 0;
        }
        if (hm.containsKey(str)) {
            return hm.get(str);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < str.length() - 1; i++) {
            String leftString = str.substring(0, i + 1);
            if (hs.contains(leftString)) {
                int smallAns = check3(str.substring(i + 1));
                ans = Math.min(ans, smallAns);
            } else {
                int leftAns = leftString.length();
                int rightAns = check3(str.substring(i + 1));
                int total = leftAns + rightAns;
                ans = Math.min(ans, total);
            }
        }
        hm.put(str, ans);
        return ans;
    }

}

package dynamicProgramming;

import java.util.*;

public class WordBreak {

    public static void main(String args[]) {
        String str = "abhay";
        // int i = 0;
        // int j = str.length();
        // for(int k = i+1;k<=j;k++){
        // String sub1 = str.substring(i,k);
        // String sub2 = str.substring(k,j);
        // System.out.println(sub1+" "+sub2+"| ");
        // }
        List<String> l = new ArrayList<>();
        l.add("a");
        l.add("bh");
        l.add("ay");
        System.out.print(util2(str, l));
    }

    static HashSet<String> hs;
    static Boolean dp[][];

    public static boolean util1(String str, List<String> dict) {
        hs = new HashSet<>();
        dp = new Boolean[str.length() + 1][str.length() + 1];
        for (String s : dict) {
            hs.add(s);
        }
        boolean ans = check2(str, 0, str.length() - 1);
        return ans;
    }

    public static boolean check2(String str, int i, int j) {
        if (i == j) {
            if (hs.contains(str.substring(i, j + 1))) {
                return true;
            } else {
                return false;
            }
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (hs.contains(str.substring(i, j + 1))) {
            return true;
        }

        boolean ans = false;
        for (int k = i; k < j; k++) {
            boolean leftAns = check2(str, i, k);
            boolean rightAns = check2(str, k + 1, j);
            if (leftAns && rightAns) {
                ans = true;
            }
        }
        return dp[i][j] = ans;
    }

    public static boolean check(String str, int i, int j) {
        if (i == j) {
            if (hs.contains(str.substring(i, j + 1))) {
                return true;
            } else {
                return false;
            }
        }

        if (hs.contains(str.substring(i, j + 1))) {
            return true;
        }

        boolean ans = false;
        for (int k = i; k < j; k++) {
            boolean leftAns = check(str, i, k);
            boolean rightAns = check(str, k + 1, j);
            if (leftAns && rightAns) {
                ans = true;
            }
        }
        return ans;
    }

    // approach 2
    // call right only if left is correct
    static HashMap<String, Boolean> hm;

    public static boolean util2(String str, List<String> dict) {
        hs = new HashSet<>();
        hm = new HashMap<>();
        for (String s : dict) {
            hs.add(s);
        }
        return check2(str);
    }

    public static boolean check2(String str) {
        if (str.equals("")) {
            return true;
        }
        if (hm.containsKey(str)) {
            return hm.get(str);
        }
        if (hs.contains(str)) {
            return true;
        }
        boolean ans = false;
        for (int i = 0; i < str.length() - 1; i++) {
            if (hs.contains(str.substring(0, i + 1))) {
                boolean smallAns = check2(str.substring(i + 1));
                if (smallAns) {
                    ans = true;
                    break;
                }
            }
        }
        hm.put(str, ans);
        return ans;
    }

}

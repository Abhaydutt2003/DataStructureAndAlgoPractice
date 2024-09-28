package dynamicProgramming;

import java.util.*;

public class ConcatenatedWords {

    public static void main(String args[]) {
        String words[] = { "cat", "dog", "catdog" };
        List<String> ans = util1(words);
        for (String s : ans) {
        System.out.println(s);
        }
    }

    // will have to do word break on every word

    static HashSet<String> hs;

    public static List<String> util1(String words[]) {
        hs = new HashSet<>();
        for (String s : words) {
            hs.add(s);
        }
        List<String> ans = new ArrayList<>();
        for (String s : words) {
            hs.remove(s);
            boolean a = wrdBrk(s, new HashMap<String, Boolean>());
            if (a) {
                ans.add(s);
            }
            hs.add(s);
        }
        return ans;
    }

    public static boolean wrdBrk(String str, HashMap<String, Boolean> memo) {
        if (str.length() == 0) {
            return true;
        }
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        if (hs.contains(str)) {
            return true;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            String left = str.substring(0, i + 1);
            if (hs.contains(left)) {
                String right = str.substring(i + 1);
                boolean smallAns = wrdBrk(right, memo);
                if (smallAns) {
                    memo.put(str, true);
                    return true;
                }
            }
        }
        memo.put(str, false);
        return false;
    }

}

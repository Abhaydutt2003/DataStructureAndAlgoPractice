package dynamicProgramming;

import java.util.*;

public class WordBreak2 {

    public static void main(String args[]) {
        String s = "catsanddog";
        List<String> l = new ArrayList<>();
        l.add("cat");
        l.add("cats");
        l.add("and");
        l.add("sand");
        l.add("dog");
        List<String> a = util1(s, l);
        for (String str : a) {
            System.out.println(str);
        }
        // for(int i = s.length()-1;i>=0;i--){
        // System.out.println(s.substring(0, i+1) +" "+s.substring(i+1));
        // }
    }

    static List<String> ans;
    static HashSet<String> hs;

    public static List<String> util1(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        hs = new HashSet<>();
        for (String str : wordDict) {
            hs.add(str);
        }
        helper2(s, "");
        return ans;
    }

    public static void helper(String str, String tillNow) {
        if (str.length() == 0) {
            tillNow.trim();
            ans.add(tillNow);
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            if (hs.contains(left)) {
                String right = str.substring(i + 1);
                String toSend = tillNow + left + " ";
                helper(right, toSend);
            }
        }
    }

    public static void helper2(String str, String tillNow) {
        if (str.length() == 0) {
            ans.add(tillNow);
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            String right = str.substring(i);
            if (hs.contains(right)) {
                String left = str.substring(0, i);
                String toSend;
                if (tillNow == "") {
                    toSend = right;
                } else {
                    toSend = right + " " + tillNow;
                }
                helper2(left, toSend);
            }
        }
    }

}

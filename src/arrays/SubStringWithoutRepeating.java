package arrays;

import java.util.*;

public class SubStringWithoutRepeating {

    public static void main(String args[]) {
        String s = "pwwkew";
        System.out.println(util1(s));
    }

    public static int util1(String s) {
        int start = 0;
        int end = 0;
        int ans = 0;
        HashSet<Character> hs = new HashSet<>();
        while (end < s.length()) {
            if (hs.contains(s.charAt(end))) {
                while (hs.contains(s.charAt(end))) {
                    hs.remove(s.charAt(start));
                    start++;
                }
                hs.add(s.charAt(end));
                end++;
            } else {
                hs.add(s.charAt(end));
                int currentLength = end - start + 1;
                ans = Math.max(ans, currentLength);
                end++;
            }
        }
        return ans;
    }

}

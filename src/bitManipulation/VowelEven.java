package Strings;

import java.util.*;

public class VowelEven {

    public static void main(String[] args) {
        System.out.println(util1("eleetminicoworoep"));
    }

    // use bitmask

    public static int util1(String str) {
        int mask = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (isVowel(str.charAt(i))) {
                mask = mask ^ (1 << (str.charAt(i) - 'a'));
                if (hm.containsKey(mask)) {
                    ans = Math.max(ans, (i - hm.get(mask)));
                } else {
                    hm.put(mask, i);
                }
            } else {
                if (hm.containsKey(mask)) {
                    ans = Math.max(ans, (i - hm.get(mask)));
                }
            }
        }
        // check edge case
        if (mask == 0) {
            ans = str.length();
        }
        return ans;
    }

    // check weather a vowel or not
    public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        } else {
            return false;
        }
    }

}

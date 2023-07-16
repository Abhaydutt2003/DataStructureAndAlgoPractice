package hashMapAndHeap;

import java.util.*;

public class FindAndReplacePattern {

    public static void main(String args[]) {

    }

    public static List<String> util1(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String str : words) {
            if (isValid(str, pattern)) {
                ans.add(str);
            }
        }
        return ans;
    }

    public static boolean isValid(String word, String pattern) {
        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (hm.containsKey(pattern.charAt(i))) {
                if (hm.get(pattern.charAt(i)) != word.charAt(i)) {
                    return false;
                }
            } else if (hs.contains(word.charAt(i))) {
                return false;
            } else {
                hm.put(pattern.charAt(i), word.charAt(i));
                hs.add(word.charAt(i));
            }
        }
        return true;
    }

}

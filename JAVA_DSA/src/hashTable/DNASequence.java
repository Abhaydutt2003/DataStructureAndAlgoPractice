package hashTable;

import java.util.*;

public class DNASequence {

    public static void main(String args[]) {
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> ans = util2(str);
        for (String s : ans) {
            System.out.println(s + " ");
        }
    }

    // sliding window
    public static List<String> util1(String str) {
        List<String> ans = new ArrayList<>();
        if (str.length() <= 10) {
            return ans;
        }
        HashMap<String, Boolean> hm = new HashMap<>();
        // construct window
        StringBuffer startString = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            startString.append(str.charAt(i));
        }
        hm.put(startString.toString(), false);
        // now slide the windahh
        int end = 10;
        while (end < str.length()) {
            startString.deleteCharAt(0);
            startString.append(str.charAt(end));
            if (hm.containsKey(startString.toString())) {
                if (hm.get(startString.toString()) == false) {
                    ans.add(startString.toString());
                    hm.put(startString.toString(), true);
                }
            } else {
                hm.put(startString.toString(), false);
            }
            end++;
        }
        return ans;
    }

    // explanation of the bit manipulation approach
    // https://leetcode.com/problems/repeated-dna-sequences/solutions/898306/repeated-dna-sequences-c-java-o-n-bit-manipulation-don-t-use-string-hashmap/

    public static List<String> util2(String str) {
        HashSet<Integer> hs = new HashSet<>();
        HashSet<String> dup = new HashSet<>();
        int curr = 0;
        for (int i = 0; i < str.length(); i++) {
            curr = curr % (1 << 18);
            curr *= 4;
            curr = curr + getDigit(str.charAt(i));
            if (i >= 9) {
                if (hs.contains(curr)) {
                    dup.add(str.substring(i - 9, i + 1));
                } else {
                    hs.add(curr);
                }
            }
        }
        return new ArrayList<>(dup);
    }

    private static int getDigit(char ch) {
        if (ch == 'A') {
            return 0;
        } else if (ch == 'C') {
            return 1;
        } else if (ch == 'G') {
            return 2;
        } else {
            return 3;
        }
    }

}

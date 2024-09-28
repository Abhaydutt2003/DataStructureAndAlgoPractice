package hashTable;

import java.util.*;

public class AllAnagrams {

    public static void main(String[] args) {
        List<Integer> ans = util2("ab","abab");
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    // better solution
    public static List<Integer> util2(String s, String p) {
        int[] map1 = new int[26];
        int map2[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = (int) (s.charAt(i) - 97);
            map1[index]++;
        }
        int start = 0;
        int end = 0;
        List<Integer> ans = new ArrayList<>();
        while (end < p.length()) {
            int index = (int) (p.charAt(end) - 97);
            map2[index]++;
            if (end - start + 1 == s.length()) {
                if (Arrays.equals(map1, map2)) {
                    ans.add(start);
                }
                index = (int) (p.charAt(start) - 97);
                map2[index]--;
                start++;
            }
            end++;
        }
        return ans;
    }

    // not so optimal solution
    // O(n*26)
    public static List<Integer> util1(String s, String p) {
        int freq[] = new int[26];
        for (int i = 0; i < p.length(); i++) {
            int index = (int) (p.charAt(i) - 97);
            freq[index]++;
        }
        String theString = "";
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                theString += freq[i] + "" + ((char) (97 + i));
            }
        }
        int start = 0;
        int end = 0;
        int freq2[] = new int[26];
        List<Integer> ans = new ArrayList<>();
        while (end < s.length()) {
            int index = (int) (s.charAt(end) - 97);
            freq2[index]++;
            if (end - start + 1 == p.length()) {
                if (check(theString, freq2)) {
                    ans.add(start);
                }
                index = (int) (s.charAt(start) - 97);
                freq2[index]--;
                start++;
            }
            end++;
        }
        return ans;
    }

    public static boolean check(String theString, int[] freq) {
        String theString2 = "";
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                theString2 += freq[i] + "" + ((char) (97 + i));
            }
        }
        return theString.equals(theString2);
    }

}

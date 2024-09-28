package hashTable;

import java.util.*;

public class GroupAnagrams {

    public static void main(String args[]) {
        String[] strs = {
                "eat",
                "tea",
                "tan",
                "ate",
                "nat",
                "bat"
        };
        List<List<String>> l = util2(strs);
        for (List<String> a : l) {
            for (String b : a) {
                System.out.print(b + " ");
            }
            System.out.println("");
        }
    }

    static HashMap<String, List<String>> hm2;

    public static List<List<String>> util2(String strs[]) {
        hm2 = new HashMap<>();
        helper2(strs, 0);
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> en : hm2.entrySet()) {
            ans.add(en.getValue());
        }
        return ans;
    }

    public static void helper2(String strs[], int i) {
        if (i == strs.length) {
            return;
        }
        String currentWord = strs[i];
        char charArr[] = currentWord.toCharArray();
        Arrays.sort(charArr);
        String currentSorted = new String(charArr);
        if (hm2.containsKey(currentSorted)) {
            hm2.get(currentSorted).add(currentWord);
        } else {
            List<String> l = new ArrayList<>();
            l.add(currentWord);
            hm2.put(currentSorted, l);
        }
        helper2(strs, i + 1);
    }

    // approach fails on duh and ill test case
    public static List<List<String>> util1(String strs[]) {
        hm = new HashMap<>();
        helper(strs, 0);
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> en : hm.entrySet()) {
            ans.add(en.getValue());
        }
        return ans;
    }

    static HashMap<Integer, List<String>> hm;

    public static void helper(String[] strs, int i) {
        if (i == strs.length) {
            return;
        }
        int spSum = getSpSum(strs[i]);
        if (hm.containsKey(spSum)) {
            hm.get(spSum).add(strs[i]);
        } else {
            List<String> l = new ArrayList<>();
            l.add(strs[i]);
            hm.put(spSum, l);
        }
        helper(strs, i + 1);
    }

    public static int getSpSum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += (int) str.charAt(i);
        }
        return sum + str.length();
    }

}

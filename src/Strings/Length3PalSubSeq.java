package Strings;

import java.util.*;

public class Length3PalSubSeq {

    public static void main(String args[]) {
        System.out.print(util1("bbcbaba"));
    }

    // aaa, abaa, aba, afanaa

    public static int util1(String str) {
        int freq[][] = new int[26][2];
        // setting start and end as -1 initally
        for (int i = 0; i < freq.length; i++) {
            for (int j = 0; j < freq[i].length; j++) {
                freq[i][j] = -1;
            }
        }
        // now searching for start and end
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (freq[index][0] != -1) {
                freq[index][1] = i;
            } else {
                freq[index][0] = i;
            }
        }

        // now calculate the unique pairs
        HashSet<String> hs = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < freq.length; i++) {
            int start = freq[i][0];
            int end = freq[i][1];
            if (start != -1 && end != -1) {
                for (int j = start + 1; j < end; j++) {
                    String key = str.charAt(start) + " " + str.charAt(j);
                    if (hs.contains(key) == false) {
                        ans++;
                        hs.add(key);
                    }
                }
            }
        }
        return ans;
    }

}

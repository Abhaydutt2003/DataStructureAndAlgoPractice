package Strings;

import java.util.*;

public class ReorganizeString {

    public static void main(String args[]) {
        String str = "aabbcdd";
        System.out.print(util1(str));
    }

    public static String util1(String str) {
        int freq[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                pq.add(new int[] { 'a' + i, freq[i] });
            }
        }
        StringBuilder ans = new StringBuilder();
        while (pq.isEmpty() == false) {
            int[] current = pq.poll();
            if (ans.length() == 0 || ans.charAt(ans.length() - 1) != ((char) current[0])) {
                ans.append((char) current[0]);
                current[1]--;
                if (current[1] > 0) {
                    pq.add(current);
                }
            } else {
                if (pq.isEmpty() == true) {
                    return "";
                }
                int current2[] = pq.poll();
                ans.append((char) current2[0]);
                current2[1]--;
                if (current2[1] > 0) {
                    pq.add(current2);
                }
                pq.add(current);
            }
        }
        return ans.toString();
    }

    // public static String util1(String str) {
    // TreeMap<Character, Integer> tm = new TreeMap<>();
    // for (int i = 0; i < str.length(); i++) {
    // tm.put(str.charAt(i), tm.getOrDefault(str.charAt(i), 0) + 1);
    // }
    // String ans = "";
    // while (tm.size() != 1) {
    // char a = tm.lastKey();
    // int freqA = tm.get(a);
    // tm.pollLastEntry();
    // char b = tm.lastKey();
    // int freqB = tm.get(b);
    // tm.pollLastEntry();
    // if (freqB == freqA || freqB == freqB - 1) {
    // addString(a, b, freqA, freqB, ans);
    // } else {
    // return "";
    // }
    // }
    // if (tm.size() == 1) {
    // char a = tm.lastKey();
    // int freqA = tm.get(a);
    // tm.pollLastEntry();
    // if (freqA != 1) {
    // return "";
    // } else {
    // ans += a;
    // }
    // }
    // return ans;
    // }

    // public static void addString(char a, char b, int freqA, int freqB, String
    // ans){
    // boolean turn = true;
    // while(freqA!=0 && freqB!=0){
    // if(turn){
    // ans+=a;
    // freqA--;
    // }else{
    // ans+=b;
    // freqB--;
    // }
    // }
    // if(freqA != 0){

    // }
    // }

    // public static String util1(String str) {
    // String adjacents = "";
    // String s = "";
    // for (int i = 0; i < str.length(); i++) {
    // if (i == 0 || str.charAt(i) != str.charAt(i - 1)) {
    // s += str.charAt(i);
    // } else {
    // if (adjacents.length() == 0 || adjacents.charAt(adjacents.length() - 1) !=
    // str.charAt(i)) {
    // adjacents += str.charAt(i);
    // } else {
    // return "";
    // }
    // }
    // }
    // return s + adjacents;
    // }

}

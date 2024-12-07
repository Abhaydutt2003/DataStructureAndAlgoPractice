package hashTable;

// import java.util.*;

public class PermutationInString {

    // // recursive
    // public static boolean evaluateIfPermutation(String s2, HashMap<Character,
    // Integer> hm, int index) {
    // if (hm.isEmpty()) {
    // return true;
    // }else if(index >= s2.length()){
    // return false;
    // } else {
    // if (hm.containsKey(s2.charAt(index))) {
    // hm.put(s2.charAt(index), hm.get(s2.charAt(index)) - 1);
    // if (hm.get(s2.charAt(index)) == 0) {
    // hm.remove(s2.charAt(index));
    // }
    // boolean ans = evaluateIfPermutation(s2, hm, index + 1);
    // hm.put(s2.charAt(index), hm.getOrDefault(s2.charAt(index), 0) + 1);
    // return ans;
    // } else {
    // return false;
    // }
    // }
    // }

    // public static boolean checkInclusion(String s1, String s2) {
    // HashMap<Character, Integer> hm = new HashMap<>();
    // for (int i = 0; i < s1.length(); i++)
    // hm.put(s1.charAt(i), hm.getOrDefault(s1.charAt(i), 0) + 1);
    // // start to itertate s2
    // for (int i = 0; i < s2.length(); i++) {
    // if (hm.containsKey(s2.charAt(i)))
    // if (evaluateIfPermutation(s2, hm, i))
    // return true;
    // }
    // return false;
    // }

    public static boolean checkInclusion(String s1, String s2) {
        int lengthDifference = s2.length() - s1.length();
        if (lengthDifference < 0)
            return false;
        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freqS1[s1.charAt(i) - 'a']++;
            freqS2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < lengthDifference; i++) {
            if (freqMatch(freqS1, freqS2))
                return true;
            freqS2[s2.charAt(i + s1.length()) - 'a']++;
            freqS2[s2.charAt(i) - 'a']--;
        }
        return freqMatch(freqS1, freqS2);
    }

    public static boolean freqMatch(int arr1[], int arr2[]) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "ooolleoooleh";
        System.out.println(checkInclusion(s1, s2));
    }
}

package backTracking;

import java.util.*;

public class Permutations2 {

    public static void main(String args[]) {

    }

    static HashMap<Integer, Integer> hm;
    static List<List<Integer>> ans;

    public static List<List<Integer>> util1(int[] arr) {
        hm = new HashMap<>();
        ans = new ArrayList<>();
        for (int i : arr) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        helper(arr, new ArrayList<>());
        return ans;
    }

    public static void helper(int arr[], List<Integer> tillNow) {
        if (tillNow.size() == arr.length) {
            ans.add(new ArrayList<>(tillNow));
            return;
        }
        for (Map.Entry<Integer, Integer> en : hm.entrySet()) {
            int number = en.getKey();
            int frequency = en.getValue();
            if (frequency == 0) {
                continue;
            }
            tillNow.add(number);
            hm.put(number, frequency - 1);
            helper(arr, tillNow);
            tillNow.remove(tillNow.size() - 1);
            hm.put(number, frequency);
        }
    }

}

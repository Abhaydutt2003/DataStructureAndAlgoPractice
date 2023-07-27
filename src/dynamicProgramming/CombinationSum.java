package dynamicProgramming;

import java.util.*;

public class CombinationSum {

    public static void main(String args[]) {

    }

    // leetcode approach

    static List<List<Integer>> ans;
    static int t;

    public static List<List<Integer>> util1(int arr[], int target) {
        ans = new ArrayList<>();
        t = target;
        helper(arr, 0, 0, new ArrayList<>());
        return ans;
    }

    public static void helper(int arr[], int start, int sum, List<Integer> tillNow) {
        if (sum > t) {
            return;
        } else if (sum == t) {
            ans.add(new ArrayList<>(tillNow));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            sum += arr[i];
            tillNow.add(arr[i]);
            helper(arr, i, sum, tillNow);
            sum -= arr[i];
            tillNow.remove(tillNow.size() - 1);
        }
    }

    // static List<List<Integer>> ans;
    // static HashSet<String> hs;
    // static int t;

    // public static List<List<Integer>> util1(int arr[], int target) {
    // t = target;
    // hs = new HashSet<>();
    // ans = new ArrayList<>();
    // helper(arr, 0, "", 0, new ArrayList<>());
    // return ans;
    // }

    // public static void helper(int arr[], int sumTillNow, String str, int index,
    // List<Integer> tillNow) {
    // if (hs.contains(str)) {
    // return;
    // }
    // if (sumTillNow == t) {
    // List<Integer> l = new ArrayList<>(tillNow);
    // ans.add(l);
    // return;
    // }
    // if (index == arr.length) {
    // return;
    // }
    // if (sumTillNow > t) {
    // return;
    // }
    // String str2 = str + index;
    // sumTillNow += arr[index];
    // tillNow.add(arr[index]);
    // helper(arr, sumTillNow, str2, index + 1, tillNow);
    // helper(arr, sumTillNow, str2, index, tillNow);
    // sumTillNow -= arr[index];
    // tillNow.remove(tillNow.size() - 1);
    // helper(arr, sumTillNow, str, index + 1, tillNow);
    // }

}

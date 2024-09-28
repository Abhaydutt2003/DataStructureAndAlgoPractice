package backtracking;

import java.util.*;

public class Subsets {

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        List<List<Integer>> ans = util1(arr);
        for (List<Integer> a : ans) {
            for (Integer i : a) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    static List<List<Integer>> ans;

    public static List<List<Integer>> util1(int[] nums) {
        ans = new ArrayList<>();
        helper(nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    public static void helper(int arr[], List<Integer> tillNow, int start) {
        if (tillNow.size() == arr.length) {
            ans.add(new ArrayList<>(tillNow));
            return;
        }
        ans.add(new ArrayList<>(tillNow));
        for (int i = start; i < arr.length; i++) {
            tillNow.add(arr[i]);
            helper(arr, tillNow, i + 1);
            tillNow.remove(tillNow.size() - 1);
        }
    }

}

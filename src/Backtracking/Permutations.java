package backTracking;

import java.util.*;

public class Permutations {

    public static void main(String args[]) {

    }


    //O(n * n!)
    //for every permutation we are doing n! work.

    
    public static List<List<Integer>> util1(int[] nums) {
        visited = new boolean[nums.length];
        ans = new ArrayList<>();
        helper(nums, new ArrayList<>());
        return ans;
    }

    static List<List<Integer>> ans;
    static boolean visited[];

    public static void helper(int arr[], List<Integer> tillNow) {
        if (tillNow.size() == arr.length) {
            ans.add(new ArrayList<>(tillNow));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                tillNow.add(arr[i]);
                helper(arr, tillNow);
                visited[i] = false;
                tillNow.remove(tillNow.size() - 1);
            }
        }
    }

}

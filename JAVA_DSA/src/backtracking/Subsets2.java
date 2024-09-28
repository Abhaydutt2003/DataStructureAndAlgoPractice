package backtracking;

import java.util.*;

public class Subsets2 {

    public static void main(String args[]) {

    }

    static List<List<Integer>> ans;

    public static List<List<Integer>> util1(int arr[]) {
        ans = new ArrayList<>();
        Arrays.sort(arr);
        helper(arr, 0, new ArrayList<>());
        return ans;
    }

    public static void helper(int arr[], int index, List<Integer> l) {
        ans.add(new ArrayList<>(l));
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            l.add(arr[i]);
            helper(arr, i + 1, l);
            l.remove(l.size() - 1);
        }
    }

}

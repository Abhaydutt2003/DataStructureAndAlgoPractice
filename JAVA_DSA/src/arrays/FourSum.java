package arrays;

import java.util.*;

public class FourSum {

    public static void main(String args[]) {

    }

    // we will generalize this problem to the ksum problem

    // taking long target because of test case like

    // nums =
    // [-1000000000,-1000000000,1000000000,-1000000000,-1000000000]
    // target = 294967296

    public static List<List<Integer>> recUtil(int arr[], long target, int start, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k > (arr.length - start) || start == arr.length) {
            return ans;
        }
        long average = target / k;
        if (arr[start] > average || arr[arr.length - 1] < average) {
            return ans;
        }

        if (k == 2) {
            return twoSum(arr, target, start);
        } else {
            for (int i = start; i < arr.length; i++) {
                if (i == start || arr[i - 1] != arr[i]) {
                    List<List<Integer>> smallAns = recUtil(arr, target - arr[i], i + 1, k - 1);
                    if (smallAns.size() != 0) {
                        for (List<Integer> a : smallAns) {
                            ans.add(new ArrayList<>(Arrays.asList(arr[i])));
                            ans.get(ans.size() - 1).addAll(a);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> twoSum(int arr[], long target, int start) {
        List<List<Integer>> ans = new ArrayList<>();
        int low = start, end = arr.length - 1;
        while (low < end) {
            int sum = arr[low] + arr[end];
            if (sum < target || ((low > start) && (arr[low] == arr[low - 1]))) {
                low++;
            } else if (sum > target || ((end < arr.length - 1) && (arr[end] == arr[end + 1]))) {
                end--;
            } else {
                System.out.println(target + " " + arr[low] + " " + arr[end]);
                ans.add(Arrays.asList(arr[low++], arr[end--]));
            }
        }
        return ans;
    }

}

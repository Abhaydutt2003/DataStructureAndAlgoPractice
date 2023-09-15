package backTracking;

import java.util.*;

public class KEqualSumSubsets {

    public static void main(String args[]) {
        int arr[] = { 1739, 5391, 8247, 236, 5581, 11, 938, 58, 1884, 823, 686, 1760, 6498, 6513, 6316, 2867 };
        int k = 6;
        System.out.print(util1(arr, k));
    }

    public static boolean util1(int[] arr, int k) {
        int sum = 0;
        Integer arr1[] = new Integer[arr.length];
        int K = 0;
        for (int i : arr) {
            sum += i;
            arr1[K++] = i;
        }
        if (sum % k != 0 || k > arr.length) {
            return false;
        }
        int visited[] = new int[k];
        Arrays.sort(arr1, Collections.reverseOrder());
        return helper2(arr1, visited, 0, sum / k);
    }

    public static boolean helper2(Integer arr[], int visited[], int index, int target) {
        if (index == arr.length) {
            return true;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] + arr[index] > target || (i > 0 && visited[i - 1] == visited[i])) {
                continue;
            }
            visited[i] += arr[index];
            boolean ans = helper2(arr, visited, index + 1, target);
            visited[i] -= arr[index];
            if (ans) {
                return true;
            }
        }
        return false;
    }

    // optimize this further
    public static boolean helper(int arr[], int visited[], int index) {
        if (index >= arr.length) {
            for (int i : visited) {
                if (i != 0) {// awful part
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] - arr[index] >= 0) {
                visited[i] -= arr[index];
                boolean ans = helper(arr, visited, index + 1);
                visited[i] += arr[index];
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }

}

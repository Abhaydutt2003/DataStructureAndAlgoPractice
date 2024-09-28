package backtracking;

import java.util.*;

public class KEqualSumSubsets {

    public static void main(String args[]) {
        int arr[] = { 1739, 5391, 8247, 236, 5581, 11, 938, 58, 1884, 823, 686, 1760,
                6498, 6513, 6316, 2867 };
        int k = 6;
        System.out.print(util2(arr, k));

    }

    /*
     * some basic bitmask concept
     * 
     * 
     * Set the ith bit: b(1<<i). Let i=0, so,
     * (1<<i) = 00001
     * 01010 | 00001 = 01011
     * 
     * Unset the ith bit: b & !(1<<i). Let i=1, so,
     * (1<<i) = 00010
     * !(1<<i) = 11101
     * 01010 & 11101 = 01000
     * 
     * Let i = 3
     * (1<<i) = 01000
     * 01010 & 01000 = 01000
     * 
     * Clearly the result is non-zero, so that means 3rd element is present in the
     * subset.
     * 
     * 
     */

    // using bitmask and recursion

    public static boolean util2(int arr[], int k) {
        int sum = 0;
        Integer arr1[] = new Integer[arr.length];
        int K = 0;
        for (int i : arr) {
            sum += i;
            arr1[K++] = i;
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(arr1, Collections.reverseOrder());
        Boolean dp[] = new Boolean[1 << arr.length];
        return helper3(arr1, sum / k, 0, 0, k, dp);
    }

    public static boolean helper3(Integer arr[], int target, int currSum, int mask, int k, Boolean[] dp) {
        if (dp[mask] != null) {
            return dp[mask];
        } else if (k == 0) {
            return true;
        }
        dp[mask] = false;
        for (int i = 0; i < arr.length; i++) {
            if ((mask & (1 << i)) == 0) {
                int curr = currSum % target + arr[i];
                if (curr < target) {
                    dp[mask] = helper3(arr, target, currSum + arr[i], (mask | (1 << i)), k, dp);
                } else if (curr == target) {
                    dp[mask] = helper3(arr, target, currSum + arr[i], (mask | (1 << i)), k - 1, dp);
                }
                if (dp[mask]) {
                    return true;
                }
            }
        }
        return dp[mask];
    }

    // backtracking solution
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

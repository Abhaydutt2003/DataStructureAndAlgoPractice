package arrays;

import java.util.*;

public class MaxNumberKSumPair {

    public static void main(String args[]) {

    }

    public static int util1(int[] arr, int k) {
        Arrays.sort(arr);
        int ans = 0;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == k) {
                ans++;
                i++;
                j--;
            } else if (arr[i] + arr[j] < k) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

}

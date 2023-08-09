package binarySearch;

import java.util.Arrays;

public class MinimizeMaximumDiffPairs {

    public static void main(String args[]) {

    }

    public static int util1(int[] arr, int p) {
        Arrays.sort(arr);
        int start = 0, end = 1000000000, mid = 0, res = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (isValid(arr, mid, p)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static boolean isValid(int arr[], int mid, int p) {
        int validPairs = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int currentPair = arr[i + 1] - arr[i];
            if (currentPair <= mid) {
                validPairs++;
                i++;
            }
        }
        return validPairs >= p;
    }

}

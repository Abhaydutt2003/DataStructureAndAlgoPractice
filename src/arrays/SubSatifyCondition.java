package arrays;

import java.lang.reflect.Array;
import java.util.*;

public class SubSatifyCondition {

    public static void main(String args[]) {

    }

    static int mod = 1000000007;

    // using binary search
    // we will make a power array as to not compute powers again and again

    public static int util2(int arr[], int target) {
        Arrays.sort(arr);
        // make a power array
        int power[] = new int[arr.length];
        power[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        // now start calculating the answer
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int rightIndex = bs(arr, target - arr[i]);
            if (rightIndex >= i) {
                ans += power[rightIndex - i];
                ans %= mod;
            }
        }
        return ans;
    }

    // binary search
    public static int bs(int arr[], int target) {
        int start = 0, end = arr.length - 1, res = -1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] <= target) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    // using two sum concept
    public static int util1(int arr[], int target) {
        Arrays.sort(arr);
        int power[] = new int[arr.length];
        power[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        int ans = 0;
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            if (arr[start] + arr[end] <= target) {
                ans += power[end - start];
                ans %= mod;
                start++;
            } else {
                end--;
            }
        }
        return ans;
    }

}

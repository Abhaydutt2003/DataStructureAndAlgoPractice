package StackAndQueues;

import java.util.*;

public class SumOfSubarrayMin {

    public static void main(String[] args) {
        int arr[] = { 11, 81, 94, 43, 3 };
        System.out.println(util2(arr));
    }

    // why life hard?
    // super clever stack problem
    public static int util2(int arr[]) {
        Stack<Integer> s = new Stack<Integer>();
        long ans = 0;
        s.push(-1);
        for (int i = 0; i <= arr.length; i++) {
            while (s.isEmpty() == false && getElem(arr, i) < getElem(arr, s.peek())) {
                int current = s.pop();
                int right = i - current;
                int left = current - s.peek();
                ans = (ans + (long) (left * right * (long)arr[current])) % mod;
            }
            s.push(i);
        }
        return (int) ans;
    }

    public static int getElem(int arr[], int index) {
        if (index == arr.length || index == -1) {
            return Integer.MIN_VALUE;
        } else {
            return arr[index];
        }
    }

    // O(n^2)

    static int mod = 1000000007;

    public static int util1(int arr[]) {
        int dp[] = new int[arr.length];
        dp[dp.length - 1] = arr[arr.length - 1] % mod;
        for (int i = arr.length - 2; i >= 0; i--) {
            int min = arr[i] % mod;
            int ans = 0;
            int j = i;
            while (j < arr.length) {
                min = Math.min(min, arr[j]);
                ans += min;
                ans %= mod;
                j++;
            }
            dp[i] += ((dp[i + 1] + ans) % mod);
        }
        return dp[0];
    }

}

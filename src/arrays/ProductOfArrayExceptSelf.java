package arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String args[]) {
        int arr[] = { -1, 1, 0, -3, 3 };
        arr = util3(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int[] util3(int arr[]) {
        int ans[] = new int[arr.length];
        int left = 1;
        for (int i = 0; i < arr.length; i++) {
            ans[i] = left;
            left *= arr[i];
        }
        int right = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= arr[i];
        }
        return ans;
    }

    // was thinking of this approach, but failed in test cases with 0;
    public static int[] util2(int arr[]) {
        if (arr.length == 1) {
            return arr;
        }
        int numZeroes = 0;
        int ansLast = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                numZeroes++;
            }
            ansLast *= arr[i];
        }
        if (numZeroes > 1) {
            Arrays.fill(arr, 0);
            return arr;
        } else {
            int ans[] = new int[arr.length];
            ans[arr.length - 1] = ansLast;
            for (int i = arr.length - 2; i >= 0; i--) {
                int a = ans[i + 1] * arr[i + 1];
                if (arr[i] != 0) {
                    a = a / arr[i];
                }
                ans[i] = a;
            }
            if (numZeroes == 1) {
                for (int i = 0; i < ans.length; i++) {
                    if (arr[i] != 0) {
                        ans[i] = 0;
                    }
                }
            }
            return ans;
        }
    }

    public static int[] util1(int arr[]) {
        if (arr.length == 1) {
            return arr;
        }
        int left[] = new int[arr.length];
        left[0] = arr[0];
        for (int i = 1; i < left.length; i++) {
            left[i] = arr[i] * left[i - 1];
        }
        int right[] = new int[arr.length];
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = arr[i] * right[i + 1];
        }
        int[] ans = new int[arr.length];
        ans[0] = right[1];
        ans[arr.length - 1] = left[arr.length - 2];
        for (int i = 1; i < arr.length - 1; i++) {
            ans[i] = left[i - 1] * right[i + 1];
        }
        return ans;
    }

}

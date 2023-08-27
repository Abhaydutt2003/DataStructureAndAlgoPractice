package dynamicProgramming;

import java.util.Arrays;

public class CombinationSumIV {

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int target = 4;
        System.out.print(util1(arr, target));
    }

    static int dp[];

    public static int util1(int arr[], int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return helper(arr, target);
    }

    public static int helper(int arr[], int target) {
        if (target == 0) {
            return 1;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (target - arr[i] >= 0) {
                ans += helper(arr, target - arr[i]);
            }
        }
        return dp[target] = ans;
    }

}

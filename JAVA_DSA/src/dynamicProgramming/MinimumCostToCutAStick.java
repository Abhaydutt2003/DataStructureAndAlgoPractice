package dynamicProgramming;

import java.util.Arrays;

//import java.util.*;

public class MinimumCostToCutAStick {
    public static void main(String args[]) {
        int n = 7;
        int cuts[] = { 1, 3, 4, 5 };
        System.out.println(util1(n, cuts));
    }

    public static int util1(int n, int[] cuts) {
        // dp = new int[n + 1][n + 1];
        // for (int[] a : dp) {
        // Arrays.fill(a, -1);
        // }
        Arrays.sort(cuts);
        dp = new int[cuts.length][cuts.length];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return helper3(0, n, cuts, 0, cuts.length - 1);
        // return helper2(n, cuts, 0, n);
    }

    // normal recursive solution
    public static int helper(int size, int cuts[], int start, int end) {
        if (size == 1) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < cuts.length; i++) {
            if (cuts[i] < end && cuts[i] > start) {
                int leftAns = helper((cuts[i] - start), cuts, start, cuts[i]);
                int rightAns = helper((end - cuts[i]), cuts, cuts[i], end);
                ans = Math.min(ans, (rightAns + leftAns + size));
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return 0;
        }
        return ans;
    }

    static int dp[][];

    // memo
    public static int helper2(int size, int cuts[], int start, int end) {
        if (size == 1) {
            return 0;
        }
        if (dp[size][start] != -1) {
            return dp[size][start];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < cuts.length; i++) {
            if (cuts[i] < end && cuts[i] > start) {
                int leftAns = helper2((cuts[i] - start), cuts, start, cuts[i]);
                int rightAns = helper2((end - cuts[i]), cuts, cuts[i], end);
                ans = Math.min(ans, (rightAns + leftAns + size));
            }
        }
        if (ans == Integer.MAX_VALUE) {
            ans = 0;
        }
        return dp[size][start] = ans;
    }
    // using HashMap will get rid of the mle

    // to reduce the space used
    // left and right indicate the subarray of the cuts array
    public static int helper3(int stickStart, int stickEnd, int cuts[], int left, int right) {
        if (left > right) {
            return 0;
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int leftAns = helper3(stickStart, cuts[i], cuts, left, i - 1);
            int rightAns = helper3(cuts[i], stickEnd, cuts, i + 1, right);
            int currentAns = leftAns + rightAns + (stickEnd - stickStart);
            ans = Math.min(currentAns, ans);
        }
        return dp[left][right] = ans;
    }

}

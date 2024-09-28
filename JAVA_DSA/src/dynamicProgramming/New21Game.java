package dynamicProgramming;

import java.util.*;

public class New21Game {

    public static void main(String args[]) {
        System.out.println(util3(9301, 9224, 7771));
        // System.out.print(util2(6,1,10));
    }

    // since the events are independet, the prob will be multiplied

    public static double util1(int n, int k, int max) {
        dp = new double[n + 1];
        Arrays.fill(dp, -1.0);
        prob = (double) 1 / (double) max;
        return helper(n, k, 0, max);
    }

    public static double helper(int n, int k, int current, int max) {
        if (current > n) {
            return 0.0;
        }
        if (current >= k) {
            return 1.0;
        }
        if (dp[current] != -1) {
            return dp[current];
        }
        double ans = 0.0;
        for (int i = 1; i <= max; i++) {
            double smallAns = helper(n, k, current + i, max);
            ans += (smallAns * prob);
        }
        return dp[current] = ans;
    }

    static double prob;
    static double dp[];

    // tabulation answer
    public static double util2(int n, int k, int max) {
        double dp[] = new double[n + 1];
        double prob = (double) 1 / (double) max;
        for (int i = n; i >= 0; i--) {
            if (i >= k) {
                dp[i] = 1.0;
            }
            for (int j = 1; j <= max; j++) {
                if (i - j >= 0) {
                    dp[i - j] += (prob * dp[i]);
                }
            }
        }
        return dp[0];
    }

    // oversmart sliding window approach
    public static double util3(int n, int k, int max) {
        if (k == 0 || k + max - 1 <= n) {
            return 1.0;
        }
        double dp[] = new double[n + max];
        double windowSum = 0.0;
        int end = k + max - 1;
        for (int i = n; i >= 0; i--) {
            if (i >= k) {
                dp[i] = 1.0;
            } else {
                dp[i] = windowSum / max;
                if (end - i == max) {
                    windowSum -= dp[end--];
                }
            }
            windowSum += dp[i];
        }
        return dp[0];
    }

}

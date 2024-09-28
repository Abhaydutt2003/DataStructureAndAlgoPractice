package dynamicProgramming;

public class ClimbingStairs {

    public static void main(String args[]) {
        int n = 5;
        dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }

        System.out.println(util1(n));
    }

    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        int ans1 = climbStairs(n - 1);
        int ans2 = climbStairs(n - 2);
        return ans1 + ans2;
    }

    static int dp[];

    public static int util1(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else if (dp[n] != -1) {
            return dp[n];
        }

        int ans1 = climbStairs(n - 1);
        int ans2 = climbStairs(n - 2);
        return dp[n] = ans1 + ans2;
    }

}

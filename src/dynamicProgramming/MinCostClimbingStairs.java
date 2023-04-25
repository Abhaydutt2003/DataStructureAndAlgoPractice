package dynamicProgramming;

public class MinCostClimbingStairs {

    public static void main(String args[]) {
        int arr[] = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        int ans1 = util1(arr, 0);
        int ans2 = util1(arr, 1);
        System.out.print(ans1 + " " + ans2);
    }

    static int dp[];

    public static int util1(int arr[], int i) {
        if (i >= arr.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int ans1 = util1(arr, i + 1) + arr[i];
        int ans2 = util1(arr, i + 2) + arr[i];

        return dp[i] = Math.min(ans1, ans2);
    }
}

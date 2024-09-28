package dynamicProgramming;

public class HouseRobber2 {

    public static void main(String args[]) {
        int arr[] = { 1, 4, 3, 2 };
        System.out.print(util2(arr));
    }

    public static int util2(int arr[]) {
        if (arr.length == 0) {
            return arr[0];
        }
        int ans1 = helper(arr, 1);
        int ans2 = helper(arr, 0);
        return Math.max(ans1, ans2);
    }

    public static int helper(int arr[], int i) {
        int dp[] = new int[arr.length];
        dp[0] = 0;
        dp[1] = arr[i++];
        for (int a = 2; a < dp.length; a++) {
            dp[a] = Math.max(dp[a - 1], (dp[a - 2] + arr[i++]));
        }
        return dp[dp.length - 1];
    }

}

package dynamicProgramming;

public class TriangulationOfPolygon {
    // very clever problem

    public static void main(String args[]) {

    }

    public static int util1(int[] values) {
        dp = new int[values.length][values.length];
        return helper(values, 0, values.length - 1);
    }

    static int dp[][];

    public static int helper(int arr[], int start, int end) {
        if ((end - start + 1) <= 2) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = start + 1; k < end; k++) {
            int left = helper(arr, start, k);
            int right = helper(arr, k, end);
            int currentAns = arr[start] * arr[k] * arr[end] + left + right;
            ans = Math.min(ans, currentAns);
        }
        return dp[start][end] = ans;
    }

}

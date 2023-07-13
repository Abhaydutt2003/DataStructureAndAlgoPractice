package greedy;

public class JumpGame2 {

    public static void main(String args[]) {
        int arr[] = { 2, 3, 0, 1, 4 };
        System.out.print(util2(arr));
    }

    // 1-D dp approach..
    public static int util1(int arr[]) {
        int dp[] = new int[arr.length];
        dp[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;

            // finding the minimum..
            int limit = i + arr[i];
            for (int j = i + 1; (j <= limit) && (j <= arr.length - 1); j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[0];
    }

    // greedy
    public static int util2(int arr[]) {
        int steps = 0;
        int boundry = 0;
        int prevBoundry = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boundry = Math.max(i + arr[i], boundry);
            if (i == prevBoundry) {
                prevBoundry = boundry;
                steps++;
            }
        }
        return steps;
    }

}

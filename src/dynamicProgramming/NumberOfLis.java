package dynamicProgramming;

public class NumberOfLis {

    public static void main(String args[]) {
        int arr[] = { 1, 2, 4, 3, 5, 4 };
        System.out.println(util3(arr));
    }

    public static int util3(int arr[]) {
        int dp[][] = new int[arr.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        int maxLis = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            int j = i - 1;
            int currentMax = 1;
            while (j > 0) {
                if (arr[j - 1] < arr[i - 1]) {
                    int candidate = dp[j][0] + 1;
                    if (candidate > currentMax) {
                        dp[i][0] = candidate;
                        dp[i][1] = dp[j][1];
                        currentMax = candidate;
                    } else if (candidate == currentMax) {
                        dp[i][1] += dp[j][1];
                    }
                }
                j--;
            }
            maxLis = Math.max(maxLis, currentMax);
        }
        int ans = 0;
        for (int[] i : dp) {
            if (i[0] == maxLis) {
                ans += i[1];
            }
        }
        return ans;
    }

    // does not work as well
    public static int util2(int arr[]) {
        int dp[] = new int[arr.length + 1];
        dp[0] = 0;
        int max = 1;
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            int j = i - 1;
            while (j > 0) {
                if (arr[j - 1] < arr[i - 1]) {
                    int candidate = dp[j] + 1;
                    if (candidate > max) {
                        max = candidate;
                        ans = 1;
                    } else if (candidate == max) {
                        ans++;
                    }
                    dp[i] = Math.max(dp[i], candidate);
                }
                j--;
            }
        }
        if (ans == 0) {
            return arr.length;
        }
        return ans;
    }

    // this does not work..
    public static int util1(int[] nums) {
        int dp[] = new int[nums.length + 1];
        dp[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            int j = i - 1;
            while (j > 0) {
                if (nums[j - 1] < nums[i - 1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                j--;
            }
            max = Math.max(max, dp[i]);
        }
        int ans = 0;
        for (int i : dp) {
            if (i == max) {
                ans++;
            }
        }
        return ans;
    }

}

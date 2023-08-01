package dynamicProgramming;

//import java.util.*;

public class StrangePrinter {

    public static void main(String args[]) {
        String str = "aba";
        System.out.print(util1(str));
    }

    static int dp[][];

    public static int util1(String str) {
        char arr[] = str.toCharArray();
        dp = new int[str.length() + 1][str.length() + 1];
        return helper2(arr, 0, arr.length - 1);
    }

    public static int helper2(char arr[], int i, int j) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int ans = helper2(arr, i + 1, j);
        for (int a = i + 1; a <= j; a++) {
            if (arr[a] == arr[i]) {
                int smallAns = helper2(arr, i, a - 1) + helper2(arr, a + 1, j);
                ans = Math.min(ans, smallAns);
            }
        }
        return dp[i][j] = ans;
    }

    // i tried

    public static int helper(char arr[], int i, int j) {
        if (i == j) {
            return 1;
        }
        int ans = 0;
        char filledWith = arr[i];
        for (int a = i; a <= j; a++) {
            if (arr[a] != filledWith) {
                int start = a, end = start;
                while (end <= j && arr[end] != filledWith) {
                    end++;
                }
                ans += helper(arr, start, end - 1);
                a = end;
            }
        }
        return ans + 1;
    }

}

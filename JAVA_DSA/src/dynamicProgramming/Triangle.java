package dynamicProgramming;

import java.util.*;

public class Triangle {

    public static void main(String args[]) {

    }

    public static int util1(List<List<Integer>> triangle) {
        dp = new int[triangle.size()][];
        int size = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[size++];
            Arrays.fill(dp[i], -1);
        }
        return helper(triangle, 0, 0);
    }

    static int dp[][];

    public static int helper(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans1 = helper(triangle, i + 1, j);
        int ans2 = helper(triangle, i + 1, j + 1);
        int ans = Math.min(ans1, ans2) + triangle.get(i).get(j);
        return dp[i][j] = ans;
    }

    // over smart 1-dp approach

    public static int util2(List<List<Integer>> triangle) {
        int dp[] = new int[triangle.get(triangle.size() - 1).size()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i); // base case
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            int newDp[] = new int[triangle.get(i).size()];
            for (int j = 0; j < newDp.length; j++) {
                newDp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
            dp = newDp;
        }
        return dp[0];
    }

}

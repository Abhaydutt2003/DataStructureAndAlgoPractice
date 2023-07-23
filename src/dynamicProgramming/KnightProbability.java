package dynamicProgramming;

import java.util.*;

public class KnightProbability {

    public static void main(String args[]) {

    }

    public static double helper2(int n, int moves, double[][][] dp, int currR, int currC, int targetR, int targetC) {
        if (moves == 0) {
            if (currC == targetC && currR == targetR) {
                return 1.0;
            } else {
                return 0.0;
            }
        }
        double desiredOutcomes = 0.0;
        double totalOutcomes = 8.0;
        for (int a = 0; a < xdir.length; a++) {
            int x = currR + xdir[a];
            int y = currC + ydir[a];
            if (x >= 0 && x < n && y >= 0 && y < n) {
                desiredOutcomes += helper2(n, moves - 1, dp, x, y, targetR, targetC);
            }
        }
        return dp[moves][currR][currC] = desiredOutcomes / totalOutcomes;
    }

    public static double util3(int n, int k, int row, int column) {
        double dp[][][] = new double[k + 1][n][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int l = 0; l < dp[0][0].length; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += helper2(n, k, dp, i, j, row, column);
            }
        }
        return ans;
    }

    // all the directions that the knight can go in..
    static int xdir[] = { -2, -1, 2, 1, 1, 2, -1, -2 };
    static int ydir[] = { 1, 2, 1, 2, -2, -1, -2, -1 };

    public static double util2(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        dp[0][row][column] = 1.0;
        for (int moves = 1; moves <= k; moves++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double favourable = 0.0;
                    for (int a = 0; a < xdir.length; a++) {
                        int prevX = i + xdir[a];
                        int prevY = j + ydir[a];
                        if (prevX >= 0 && prevY >= 0 && prevX < n && prevY < n) {
                            favourable += dp[moves - 1][prevX][prevY];
                        }
                    }
                    dp[moves][i][j] = favourable / 8.0;
                }
            }
        }
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                total += dp[k][i][j];
            }
        }
        return total;
    }

    // utterly failed..
    public static double util1(int n, int k, int row, int column) {
        hm = new HashMap<>();
        int timesIn = helper(n, k, row, column);
        int total = (int) Math.pow(8, k);
        double ans = ((double) timesIn) / ((double) total);
        return ans;
    }

    static HashMap<String, Integer> hm;

    public static int helper(int n, int k, int row, int column) {
        if (row < 0 || column < 0 || row >= n || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        String key = row + "" + column;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        int ans = 0;
        for (int a = 0; a < xdir.length; a++) {
            int x = row + xdir[a];
            int y = column + ydir[a];
            ans += helper(n, k - 1, x, y);
        }
        hm.put(key, ans);
        return ans;
    }

}

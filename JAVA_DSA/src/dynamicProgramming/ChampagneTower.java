package dynamicProgramming;

import java.util.*;

public class ChampagneTower {

    public static void main(String[] args) {
        System.out.println(util1(2, 1, 1));
    }

    // simulation

    public static double util1(int poured, int row, int col) {
        dp = new double[102][102];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        double ans = simulate(poured, row, col);
        return Math.min(ans, 1.0);
    }

    static double dp[][];

    public static double simulate(int poured, int row, int col) {
        if (row < 0 || col > row || col < 0) {
            return 0.0;
        }
        if (row == 0 && col == 0) {
            return poured;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        double left = (simulate(poured, row - 1, col - 1) - 1.0) / 2.0;
        if (left < 0.0) {
            left = 0.0;
        }
        double right = (simulate(poured, row - 1, col) - 1.0) / 2.0;
        if (right < 0.0) {
            right = 0.0;
        }
        return dp[row][col] = left + right;
    }

}

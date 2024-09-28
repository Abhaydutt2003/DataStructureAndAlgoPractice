package dynamicProgramming;

import java.util.*;

public class stoneGame2 {

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 100 };
        System.out.print(util2(arr));
    }

    static HashMap<String, Integer> hm;

    public static int util1(int piles[]) {
        hm = new HashMap<>();
        return helper(piles, 0, 1, true);
    }

    public static int helper(int[] piles, int i, int M, boolean AliceTurn) {
        if (i == piles.length) {
            return 0;
        }

        String key = AliceTurn + "_" + i + "_" + M;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }

        int[] range = { 0, 2 * M };

        if (AliceTurn) {
            int sum = 0;
            int ans = Integer.MIN_VALUE;
            for (int a = range[0]; a < range[1]; a++) {
                if (i + a >= piles.length) {
                    break;
                }
                sum += piles[i + a];
                int smallAns = helper(piles, i + a + 1, Math.max(a + 1, M), false);
                ans = Math.max(ans, sum + smallAns);
            }
            hm.put(key, ans);
            return ans;
        } else {
            int ans = Integer.MAX_VALUE;
            for (int a = range[0]; a < range[1]; a++) {
                if (i + a >= piles.length) {
                    break;
                }
                int smallAns = helper(piles, i + a + 1, Math.max(a + 1, M), true);
                ans = Math.min(ans, smallAns);
            }
            hm.put(key, ans);
            return ans;
        }
    }

    static int suffixArray[];
    static int memo[][];

    public static int util2(int piles[]) {
        suffixArray = new int[piles.length];
        suffixArray[piles.length - 1] = piles[piles.length - 1];
        for (int i = piles.length - 2; i >= 0; i--) {
            suffixArray[i] = piles[i] + suffixArray[i + 1];
        }
        memo = new int[piles.length + 1][piles.length + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo.length; j++) {
                memo[i][j] = -1;
            }
        }
        return helper2(piles.length, 0, 1);
    }

    public static int helper2(int pilesLength, int i, int m) {
        if (i == pilesLength) {
            return 0;
        }

        if ((2 * m) >= pilesLength - i) {
            return suffixArray[i];
        }

        if (memo[i][m] != -1) {
            return memo[i][m];
        }

        int maxStonesGot = Integer.MIN_VALUE;
        for (int a = 1; a <= (2 * m); a++) {
            int stonesGot = suffixArray[i] - helper2(pilesLength, i + a, Math.max(a, m));
            maxStonesGot = Math.max(maxStonesGot, stonesGot);
        }
        return memo[i][m] = maxStonesGot;
    }

    //approach 3

    

}

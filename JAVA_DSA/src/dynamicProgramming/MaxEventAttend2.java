package dynamicProgramming;

import java.util.*;

public class MaxEventAttend2 {

    public static void main(String args[]) {

    }

    public static int util1(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        dp = new int[events.length][k];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return helper(events, 0, k, 0);
    }

    // we will need to make a 2d dp here..
    static int dp[][];

    public static int helper(int[][] events, int attended, int limit, int i) {
        if (i >= events.length || attended == limit) {
            return 0;
        }
        if (dp[i][attended] != -1) {
            return dp[i][attended];
        }
        // to pick the current element
        int pick = events[i][2];
        int nextIndex = bs(events, i + 1, events.length - 1, events[i][1]);
        if (nextIndex != -1) {
            pick += helper(events, attended + 1, limit, nextIndex);
        }
        // no to pick the current element
        int notPick = helper(events, attended, limit, i + 1);
        return dp[i][attended] = Math.max(pick, notPick);
    }

    public static int bs(int[][] events, int start, int end, int currentEnd) {
        int mid = 0, res = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (events[mid][0] > currentEnd) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

}

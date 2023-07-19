package arrays;

import java.util.*;

public class RemoveOverlapping {

    public static void main(String args[]) {

    }

    public static int util1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] == b[1]) ? a[0] - b[0] : a[1] - b[1]);
        int end = intervals[0][1];
        int ans = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                ans++;
            } else {
                end = intervals[i][1];
            }
        }
        return ans;
    }

    // sorting according to start times does not work
    // public static int helper(int intervals[][], int i, int end) {
    // if (intervals.length == i) {
    // return 0;
    // }
    // if (intervals[i][0] < end) {
    // int ans1 = helper(intervals, i + 1, end);
    // int ans2 = helper(intervals, i + 1, intervals[i][1]);
    // return Math.min(ans1, ans2) + 1;
    // } else {
    // return helper(intervals, i + 1, end);
    // }
    // }

    // public static int helper(int[][] intervals) {
    // int end = intervals[0][1];
    // int ans = 0;
    // for (int i = 1; i < intervals.length; i++) {
    // if (intervals[i][0] <= end) {
    // ans++;
    // } else {
    // end = intervals[i][1];
    // }
    // }
    // return ans;
    // }

}

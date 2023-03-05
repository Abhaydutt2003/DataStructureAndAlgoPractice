package arrays;

import java.util.Arrays;
import java.util.*;

public class MergeIntervals {
    public static void main(String args[]) {
        int[][] matrix = {
                // {1,3},
                // {8,10},
                // {2,6},
                // {15,18}
                // {1,4},
                // {4,5}
                { 1, 4 },
                { 2, 3 }
        };
        int[][] ans = merge(matrix);
        for (int[] a : ans) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        Queue<int[]> ans = new LinkedList<int[]>();
        for (int i = 1; i <= intervals.length; i++) {
            if (i == intervals.length) {
                int[] toPut = new int[2];
                toPut[0] = start;
                toPut[1] = end;
                ans.add(toPut);
                break;
            } else if (end >= intervals[i][0]) {
                if (intervals[i][1] > end) {
                    end = intervals[i][1];
                }
            } else {
                int[] toPut = new int[2];
                toPut[0] = start;
                toPut[1] = end;
                ans.add(toPut);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        int[][] toReturn = new int[ans.size()][];
        for (int i = 0; i < toReturn.length && ans.isEmpty() == false; i++) {
            toReturn[i] = ans.poll();
        }
        return toReturn;
    }

}

package arrays;

import java.util.*;

public class InterchangableRect {

    public static void main(String args[]) {

    }

    // simple hashMap solution
    public static long util1(int[][] rectangles) {
        HashMap<Double, Integer> hm = new HashMap<>();
        long ans = 0;
        for (int[] a : rectangles) {
            double currentRatio = (double) a[0] / (double) a[1];
            if (hm.containsKey(currentRatio)) {
                ans += hm.get(currentRatio);
            }
            hm.put(currentRatio, hm.getOrDefault(currentRatio, 0) + 1);
        }
        return ans;
    }

    // using the famous ncr formula
    // nc2 can be re written as
    // val(val-1)/2

    public static long util2(int[][] rectangles) {
        HashMap<Double, Integer> hm = new HashMap<>();
        for (int a[] : rectangles) {
            double ratio = (double) a[0] / (double) a[1];
            hm.put(ratio, hm.getOrDefault(ratio, 0) + 1);
        }
        long ans = 0;
        for (Map.Entry<Double, Integer> en : hm.entrySet()) {
            double value = en.getValue();
            double combinations = (value * (value - 1)) / 2;
            ans += combinations;
        }
        return ans;
    }

}

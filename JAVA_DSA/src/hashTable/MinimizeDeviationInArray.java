package hashTable;

import java.util.*;

public class MinimizeDeviationInArray {

    public static void main(String args[]) {
        int arr[] = { 4, 1, 5, 20, 3 };
        System.out.print(util2(arr));
    }

    /*
     * firstly we make every element even
     * then we track each possible deviation
     * keep on dividing the max until it is not divisible by 2 anymore
     */

    public static int util1(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i % 2 != 0) {
                i *= 2;
            }
            pq.add(i);
            min = Math.min(i, min);
        }
        int ans = Integer.MAX_VALUE;
        while (true) {
            int max = pq.poll();
            ans = Math.min(ans, (max - min));
            if (max % 2 != 0) {
                break;
            }
            max = max / 2;
            min = Math.min(min, max);
            pq.add(max);
        }
        return ans;
    }

    // TreeSet solution
    public static int util2(int arr[]) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i : arr) {
            if (i % 2 == 0) {
                ts.add(i);
            } else {
                ts.add(i * 2);
            }
        }
        int ans = Integer.MAX_VALUE;
        while (true) {
            int max = ts.last();
            int min = ts.first();
            ans = Math.min(ans, (max - min));
            if (max % 2 != 0) {
                return ans;
            } else {
                ts.remove(max);
                max /= 2;
                ts.add(max);
            }
        }
    }

}

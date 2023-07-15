package hashMapAndHeap;

import java.util.*;

public class KClosestPointsToOrigin {

    public static void main(String args[]) {

    }

    public static int[][] util1(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int x2 = 0;
        int y2 = 0;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int currentDistance = ((int) Math.pow(x1 - x2, 2)) + ((int) Math.pow(y1 - y2, 2));
            pq.add(new int[] { i, currentDistance });
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while (pq.isEmpty() == false && k-- > 0) {
            int currentIndex[] = pq.poll();
            int a = points[currentIndex[0]][0];
            int b = points[currentIndex[0]][1];
            ans[i][0] = a;
            ans[i][1] = b;
            i++;
        }
        return ans;
    }
}

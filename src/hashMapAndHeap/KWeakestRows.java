package hashMapAndHeap;

import java.util.*;

public class KWeakestRows {

    public static void main(String[] args) {

    }

    public static int[] util1(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    soldiers++;
                } else {
                    break;
                }
            }
            pq.add(new int[] { soldiers, i });
        }
        int ans[] = new int[k];
        int a = 0;
        while (a < ans.length) {
            ans[a++] = pq.poll()[1];
        }
        return ans;
    }

}

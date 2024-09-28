package graphs;

import java.util.*;

public class ShortestBridge {

    public static void main(String agrs[]) {
        int matrix[][] = {
                // { 1, 1, 1, 1, 1, 1 },
                // { 1, 0, 0, 0, 0, 1 },
                // { 1, 0, 0, 0, 0, 1 },
                // { 1, 0, 0, 1, 0, 1 },
                // { 1, 0, 0, 0, 0, 1 },
                // { 1, 0, 0, 0, 0, 1 }
                { 1, 1, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 1, 1 }
        };
        int ans1 = util1(matrix);
        System.out.print(ans1 + " ");
    }

    static boolean[][] visited;
    static Queue<int[]> q;

    static int xdir[] = { 0, 0, 1, -1 };
    static int ydir[] = { 1, -1, 0, 0 };

    public static int util1(int matrix[][]) {
        q = new LinkedList<>();
        visited = new boolean[matrix.length][matrix[0].length];
        boolean a = true;
        for (int i = 0; i < matrix.length && a; i++) {
            for (int j = 0; j < matrix[0].length && a; j++) {
                if (matrix[i][j] == 1) {
                    fillQ(matrix, i, j);
                    a = false;
                }
            }
        }
        int ans = getAns(matrix);
        return ans;
    }

    public static void fillQ(int matrix[][], int i, int j) {
        Queue<int[]> q1 = new LinkedList<>();
        q.add(new int[] { i, j, 0 });
        q1.add(new int[] { i, j });
        visited[i][j] = true;
        while (q1.isEmpty() == false) {
            int currX = q1.peek()[0];
            int currY = q1.poll()[1];
            for (int a = 0; a < xdir.length; a++) {
                int x = currX + xdir[a];
                int y = currY + ydir[a];
                if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] == 1
                        && visited[x][y] == false) {
                    visited[x][y] = true;
                    q1.add(new int[] { x, y });
                    q.add(new int[] { x, y, 0 });
                }
            }
        }
    }

    public static int getAns(int matrix[][]) {
        while (q.isEmpty() == false) {
            int currX = q.peek()[0];
            int currY = q.peek()[1];
            int currWt = q.poll()[2];
            for (int i = 0; i < xdir.length; i++) {
                int x = xdir[i] + currX;
                int y = ydir[i] + currY;
                if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && visited[x][y] == false) {
                    if (matrix[x][y] == 1) {
                        return currWt;
                    } else {
                        visited[x][y] = true;
                        q.add(new int[] { x, y, currWt + 1 });
                    }
                }
            }
        }
        return -1;
    }

}

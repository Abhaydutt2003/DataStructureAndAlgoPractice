package backtracking;

import java.util.*;

public class RatInAMaze {

    public static void main(String args[]) {
        int matrix[][] = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 }
        };
        int n = 4;
        ArrayList<String> ans2 = util1(matrix, n);
        for (String s : ans2) {
            System.out.println(s);
        }
    }

    static boolean visited[][];
    static ArrayList<String> ans;

    public static ArrayList<String> util1(int[][] matrix, int n) {
        ans = new ArrayList<>();
        visited = new boolean[n][n];
        if (matrix[0][0] != 1) {
            ans.add("-1");
        } else {
            dfs(matrix, n, 0, 0, new String());
            if (ans.size() == 0) {
                ans.add("-1");
            }
        }
        return ans;
    }

    static int xdir[] = { 1, -1, 0, 0 };
    static int ydir[] = { 0, 0, -1, 1 };
    static char dir[] = { 'D', 'U', 'L', 'R' };

    public static void dfs(int matrix[][], int n, int i, int j, String pathTillNow) {
        if (i == n - 1 && j == n - 1) {
            String toPut = new String(pathTillNow);
            ans.add(toPut);
            return;
        }
        visited[i][j] = true;
        for (int a = 0; a < xdir.length; a++) {
            int x = i + xdir[a];
            int y = j + ydir[a];
            char di = dir[a];
            if (x >= 0 && y >= 0 && x < n && y < n && visited[x][y] == false && matrix[x][y] == 1) {
                pathTillNow += di;
                dfs(matrix, n, x, y, pathTillNow);
                pathTillNow = pathTillNow.substring(0, pathTillNow.length() - 1);
            }
        }
        visited[i][j] = false;
        return;
    }

}

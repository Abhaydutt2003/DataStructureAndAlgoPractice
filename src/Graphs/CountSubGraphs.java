package Graphs;

public class CountSubGraphs {

    public static void main(String args[]) {

    }

    public static int util1(int[][] mat1, int[][] mat2) {
        visited = new int[mat1.length][mat1[0].length];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[0].length; j++) {
                if (visited[i][j] == 0 && mat1[i][j] == 1) {
                    dfs1(mat1, i, j);
                }
            }
        }
        // now traversing to see the second matrix..
        int ans = 0;
        for (int i = 0; i < mat2.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                if (visited[i][j] != 2 && mat2[i][j] == 1) {
                    dfs2(mat2, i, j);
                    ans += (currentAns) ? 1 : 0;
                    currentAns = true;
                }
            }
        }
        return ans;
    }

    public static void dfs2(int mat2[][], int i, int j) {
        if (i < 0 || j < 0 || i >= mat2.length || j >= mat2[0].length || mat2[i][j] != 1
                || visited[i][j] == 2) {
            return;
        }
        if (visited[i][j] != 1) {
            currentAns = false;
        }
        visited[i][j] = 2;
        dfs2(mat2, i + 1, j);
        dfs2(mat2, i, j + 1);
        dfs2(mat2, i - 1, j);
        dfs2(mat2, i, j - 1);
    }

    static boolean currentAns = true;
    static int visited[][];

    public static void dfs1(int mat1[][], int i, int j) {
        if (i < 0 || j < 0 || i >= mat1.length || j >= mat1[0].length || mat1[i][j] != 1
                || visited[i][j] == 1) {
            return;
        }
        visited[i][j] = 1;
        dfs1(mat1, i + 1, j);
        dfs1(mat1, i, j + 1);
        dfs1(mat1, i - 1, j);
        dfs1(mat1, i, j - 1);
    }

}

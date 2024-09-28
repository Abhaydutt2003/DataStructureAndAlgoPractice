package graphs;

public class MaxAreaIsland {

    public static void main(String args[]) {
        int arr[][] = { { 1 } };
        System.out.print(util1(arr));
    }

    public static int util1(int matrix[][]) {
        visited = new boolean[matrix.length][matrix[0].length];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j] == false && matrix[i][j] == 1) {
                    int smallAns = dfs(matrix, i, j);
                    ans = Math.max(ans, smallAns);
                }
            }
        }
        return (ans == Integer.MIN_VALUE) ? 0 : ans;
    }

    static boolean visited[][];

    public static int dfs(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] != 1
                || visited[i][j] == true) {
            return 0;
        }
        visited[i][j] = true;
        int ans1 = dfs(matrix, i + 1, j);
        int ans2 = dfs(matrix, i, j + 1);
        int ans3 = dfs(matrix, i - 1, j);
        int ans4 = dfs(matrix, i, j - 1);
        return ans1 + ans2 + ans3 + ans4 + 1;
    }
}

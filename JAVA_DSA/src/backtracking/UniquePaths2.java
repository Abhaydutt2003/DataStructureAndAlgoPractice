package backtracking;

public class UniquePaths2 {

    public static void main(String args[]) {

    }

    public static int util1(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        if (matrix[0][0] != 1) {
            dp[0][0] = 1;
        } else {
            return 0;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i - 1 >= 0 && matrix[i - 1][j] != 1 && matrix[i][j] != 1) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j - 1 >= 0 && matrix[i][j - 1] != 1 && matrix[i][j] != 1) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[matrix.length - 1][matrix[0].length - 1];
    }

}

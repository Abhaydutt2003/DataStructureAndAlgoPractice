package dynamicProgramming;

public class LargestPlusSign {

    public static void main(String[] args) {
        int mines[][] = {
                { 4, 2 },
                { 5, 6 },
                { 8, 8 }
        };
        System.out.println(util1(10, mines));
    }

    public static int util1(int n, int mines[][]) {
        int matrix[][] = new int[n][n];
        // reverse the behaviour of 0 and 1
        for (int i = 0; i < mines.length; i++) {
            matrix[mines[i][0]][mines[i][1]] = 1;
        }
        int[][][] fuck = new int[n][n][4];
        // {up,left,bottom,right}
        // fill fuck for left and up
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    // do nothing
                    continue;
                } else {
                    if (i == 0 && j == 0) {
                        fuck[i][j][0] = 1;
                        fuck[i][j][1] = 1;
                    } else if (i == 0) {
                        fuck[i][j][0] = 1;
                        fuck[i][j][1] = fuck[i][j - 1][1] + 1;
                    } else if (j == 0) {
                        fuck[i][j][1] = 1;
                        fuck[i][j][0] = fuck[i - 1][j][0] + 1;
                    } else {
                        fuck[i][j][0] = fuck[i - 1][j][0] + 1;
                        fuck[i][j][1] = fuck[i][j - 1][1] + 1;
                    }
                }
            }
        }
        // fill fuck for bottom and right
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    // do nothing
                    continue;
                } else {
                    if (i == matrix.length - 1 && j == matrix.length - 1) {
                        fuck[i][j][2] = 1;
                        fuck[i][j][3] = 1;
                    } else if (i == matrix.length - 1) {
                        fuck[i][j][2] = 1;
                        fuck[i][j][3] = fuck[i][j + 1][3] + 1;
                    } else if (j == matrix.length - 1) {
                        fuck[i][j][3] = 1;
                        fuck[i][j][2] = fuck[i + 1][j][2] + 1;
                    } else {
                        fuck[i][j][2] = fuck[i + 1][j][2] + 1;
                        fuck[i][j][3] = fuck[i][j + 1][3] + 1;
                    }
                }
            }
        }
        // fuck is filled,now get the answer
        int ans = 0;
        for (int i = 0; i < fuck.length; i++) {
            for (int j = 0; j < fuck[i].length; j++) {
                if (matrix[i][j] == 1) {
                    // do nothing
                    continue;
                } else {
                    if (i == 0 || j == 0 || i == matrix.length - 1 || j == matrix[0].length - 1) {
                        ans = Math.max(ans, 1);
                    } else {
                        int up = fuck[i][j][0];
                        int left = fuck[i][j][1];
                        int bottom = fuck[i][j][2];
                        int right = fuck[i][j][3];
                        int smallAns = Math.min(up, Math.min(left, Math.min(bottom, right)));
                        ans = Math.max(smallAns, ans);
                    }
                }
            }
        }
        return ans;
    }
}
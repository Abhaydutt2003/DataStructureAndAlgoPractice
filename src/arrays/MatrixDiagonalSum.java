package arrays;

public class MatrixDiagonalSum {

    public static void main(String args[]) {
        int matrix[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(util1(matrix));
    }

    public static int util1(int matrix[][]) {
        int ans = 0;
        int j = 0;
        for (int i = 0; i < matrix.length; i++) {
            int toAdd1 = matrix[i][j];
            int otherIndex = (matrix[0].length - 1) - j;
            int toAdd2 = matrix[i][otherIndex];
            if (j == otherIndex) {
                ans += toAdd1;
            } else {
                ans += toAdd1;
                ans += toAdd2;
            }
            j++;
        }
        return ans;
    }
}
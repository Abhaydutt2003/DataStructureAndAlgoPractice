package binarySearch;

public class peakElement2 {

    public static void main(String args[]) {
        int matrix[][] = {
                { 1, 2, 5, 1, 4, 5 },
                { 2, 1, 3, 2, 3, 2 },
                { 1, 7, 6, 0, 1, 3 },
                { 3, 6, 2, 3, 7, 2 }
        };
        int ans[] = util1(matrix);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] util1(int[][] matrix) {
        int startCol = 0, endCol = matrix[0].length - 1, mid = 0;
        while (startCol <= endCol) {
            mid = startCol + (endCol - startCol) / 2;
            int maxi = findMaxInCol(matrix, mid);
            boolean leftBig = false, rightBig = false;

            if (mid - 1 >= 0) {
                if (matrix[maxi][mid - 1] > matrix[maxi][mid]) {
                    leftBig = true;
                }
            }

            if (mid + 1 < matrix[0].length) {
                if (matrix[maxi][mid + 1] > matrix[maxi][mid]) {
                    rightBig = true;
                }
            }

            if (leftBig == false && rightBig == false) {
                int ans[] = { maxi, mid };
                return ans;
            } else if (rightBig) {
                startCol = mid + 1;
            } else {
                endCol = mid - 1;
            }
        }
        return null;
    }

    public static int findMaxInCol(int matrix[][], int col) {
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] > matrix[index][col]) {
                index = i;
            }
        }
        return index;
    }

}

package arrays;

import java.util.*;

public class SpiralMatrix {

    public static void main(String args[]) {
        int matrix[][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();
        int total = matrix.length * matrix[0].length;
        int current = 0;
        while (true) {
            if (current >= total) {
                break;
            }
            for (int i = colStart; i <= colEnd; i++) {
                if (current >= total) {
                    return ans;
                }
                ans.add(matrix[rowStart][i]);
                current++;
                System.out.print(matrix[rowStart][i]);
                System.out.println(" ");
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                if (current >= total) {
                    return ans;
                }
                ans.add(matrix[i][colEnd]);
                current++;
                System.out.print(matrix[i][colEnd]);
                System.out.println(" ");
            }
            colEnd--;
            for (int i = colEnd; i >= colStart; i--) {
                if (current >= total) {
                    return ans;
                }
                ans.add(matrix[rowEnd][i]);
                current++;
                System.out.print(matrix[rowEnd][i]);
                System.out.println(" ");
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--) {
                if (current >= total) {
                    return ans;
                }
                ans.add(matrix[i][colStart]);
                current++;
                System.out.print(matrix[i][colStart]);
                System.out.println(" ");
            }
            colStart++;
        }
        return ans;
    }
}

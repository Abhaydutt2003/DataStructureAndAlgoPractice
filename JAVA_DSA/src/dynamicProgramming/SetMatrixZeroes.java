package dynamicProgramming;

import java.util.*;

public class SetMatrixZeroes {

    public static void main(String args[]) {

    }

    // O(1) space approach

    public static void util2(int[][] matrix) {
        boolean row0 = false;
        boolean column0 = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                column0 = true;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                row0 = true;
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (column0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (row0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    // my approach
    public static void util1(int[][] matrix) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (hm.containsKey(i)) {
                        hm.get(i).add(j);
                    } else {
                        List<Integer> l = new ArrayList<>(Arrays.asList(j));
                        hm.put(i, l);
                    }
                }
            }
        }
        for (Map.Entry<Integer, List<Integer>> en : hm.entrySet()) {
            int key = en.getKey();
            List<Integer> value = en.getValue();
            Arrays.fill(matrix[key], 0);
            for (int j : value) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}

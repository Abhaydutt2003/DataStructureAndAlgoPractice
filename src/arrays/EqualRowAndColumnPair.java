package arrays;

import java.util.HashMap;

public class EqualRowAndColumnPair {

    public static void main(String agrs[]) {
        int matrix[][] = {
                // { 3, 2, 1 },
                // { 1, 7, 6 },
                // { 2, 7, 7 }
                // {3,1,2,2},
                // {1,4,4,5},
                // {2,4,2,2},
                // {2,4,2,2}
                { 11, 1 },
                { 1, 11 }
        };
        System.out.print(util1(matrix));
    }

    public static int util1(int[][] grid) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int[] arr : grid) {
            String toAdd = "";
            for (int i : arr) {
                toAdd = toAdd + " " + i;
            }
            int toPut = 1;
            if (hm.containsKey(toAdd)) {
                toPut = hm.get(toAdd) + 1;
            }
            hm.put(toAdd, toPut);
        }
        int ans = 0;
        for (int j = 0; j < grid[0].length; j++) {
            String toCheck = "";
            for (int i = 0; i < grid.length; i++) {
                toCheck = toCheck + " " + grid[i][j];
            }
            if (hm.containsKey(toCheck)) {
                ans += hm.get(toCheck);
            }
        }
        return ans;
    }

}

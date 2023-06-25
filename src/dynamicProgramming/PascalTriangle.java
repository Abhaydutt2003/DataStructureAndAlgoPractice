package dynamicProgramming;

import java.util.*;

public class PascalTriangle {

    public static void main(String args[]) {
        List<List<Integer>> a = util1(6);
        for (List<Integer> b : a) {
            for (Integer c : b) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> ans;

    public static List<List<Integer>> util1(int rows) {
        ans = new ArrayList<>();
        List<Integer> toAdd = new ArrayList<>();
        toAdd.add(1);
        ans.add(toAdd);
        if (rows == 1) {
            return ans;
        }
        List<Integer> toAdd2 = new ArrayList<>();
        toAdd2.add(1);
        toAdd2.add(1);
        ans.add(toAdd2);
        if (rows == 2) {
            return ans;
        } else {
            makeAns(3, toAdd2, rows);
            return ans;
        }
    }

    public static void makeAns(int currentRow, List<Integer> prev, int max) {
        if (currentRow > max) {
            return;
        }
        List<Integer> toMake = new ArrayList<>();
        toMake.add(1);
        for (int index = 1; index < currentRow - 1; index++) {
            int a = prev.get(index);
            int b = prev.get(index - 1);
            toMake.add(index, (a + b));
        }
        toMake.add(1);
        ans.add(toMake);
        makeAns(currentRow + 1, toMake, max);
    }

}

package arrays;

import java.util.*;

public class BrickWall {

    public static void main(String args[]) {

    }

    // will give tle , because we are traversing the entire sum range
    public static int util1(List<List<Integer>> wall) {
        // calculate the width of the wall
        int sum = 0;
        for (int i : wall.get(0)) {
            sum += i;
        }
        // check a base case
        if (sum == 1) {
            return wall.size();
        }
        // calculating prefix sum for each row
        List<HashSet<Integer>> help = new ArrayList<>();
        for (int i = 0; i < wall.size(); i++) {
            help.add(new HashSet<>());
        }

        for (int i = 0; i < wall.size(); i++) {
            int currSum = 0;
            for (int a : wall.get(i)) {
                currSum += a;
                help.get(i).add(currSum);
            }
        }

        // now calculating the answer
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < sum; i++) {
            int bricksCrossed = 0;
            for (HashSet<Integer> hs : help) {
                if (hs.contains(i) == false) {
                    bricksCrossed++;
                }
            }
            ans = Math.min(ans, bricksCrossed);
        }
        return ans;
    }

    // clever
    public static int util2(List<List<Integer>> walls) {
        // keeping a hashMap to keep track of edges
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        for (List<Integer> l : walls) {
            int currentSum = 0;
            for (int i = 0; i < l.size() - 1; i++) {
                currentSum += l.get(i);
                int edgeFreq = hm.getOrDefault(currentSum, 0) + 1;
                max = Math.max(max, edgeFreq);
                hm.put(currentSum, edgeFreq);
            }
        }
        return walls.size() - max;
    }

}

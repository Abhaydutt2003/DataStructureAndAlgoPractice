package dynamicProgramming;

import java.util.*;

public class FrogJump {

    public static void main(String args[]) {
        int arr[] = { 0, 1, 2, 3, 4, 8, 9, 11 };
        System.out.print(util1(arr));
    }

    static HashMap<Integer, Integer> hm;
    static Boolean dp[][];

    public static boolean util1(int[] stones) {
        hm = new HashMap<>();
        dp = new Boolean[stones.length][stones.length];
        for (int i = 0; i < stones.length; i++) {
            hm.put(stones[i], i);
        }
        return helper(stones, 0, 0, 0);
    }

    static int dir[] = { -1, 0, 1 };

    public static boolean helper(int stones[], int index, int prev, int prevJump) {
        if (index == stones.length - 1) {
            return true;
        }
        if (dp[index][prev] != null) {
            return dp[index][prev];
        }
        for (int a = 0; a < dir.length; a++) {
            int jump = prevJump + dir[a];
            if (jump > 0 && hm.containsKey(stones[index] + jump)) {
                boolean smallAns = helper(stones, hm.get(stones[index] + jump), index, jump);
                if (smallAns) {
                    return dp[index][prev] = smallAns;
                }
            }
        }
        return dp[index][prev] = false;
    }

}

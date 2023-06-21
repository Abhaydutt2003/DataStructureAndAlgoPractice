package dynamicProgramming;

import java.util.*;

class st3 {
    int bobStones;
    int aliceStones;

    st3(int bobStones, int aliceStones) {
        this.bobStones = bobStones;
        this.aliceStones = aliceStones;
    }
}

public class StoneGame3 {

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, -9 };
        System.out.print(util3(arr));
        // st3 ans = util1(arr);
        // System.out.print(ans.bobStones + " " + ans.aliceStones);
    }

    // correct approach, but gives tle on the last test case
    static HashMap<String, st3> hm;

    public static String util1(int arr[]) {
        hm = new HashMap<>();
        st3 ans = helper(arr, 0, true);
        if (ans.aliceStones == ans.bobStones) {
            return "Tie";
        } else if (ans.aliceStones > ans.bobStones) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

    public static st3 helper(int arr[], int i, boolean isAlice) {
        if (i == arr.length) {
            return new st3(0, 0);
        }

        String key = isAlice + "_" + i;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }

        if (isAlice) {
            int canAchive = Integer.MIN_VALUE;
            st3 ans = null;
            int sum = 0;
            for (int a = 0; a < 3; a++) {
                int index = i + a;
                if (index >= arr.length) {
                    break;
                }
                sum += arr[index];
                st3 candidate = helper(arr, index + 1, false);
                if (candidate.aliceStones + sum > canAchive) {
                    canAchive = candidate.aliceStones + sum;
                    ans = new st3(candidate.bobStones, candidate.aliceStones + sum);
                }
            }
            hm.put(key, ans);
            return ans;
        } else {
            int canAchive = Integer.MIN_VALUE;
            st3 ans = null;
            int sum = 0;
            for (int a = 0; a < 3; a++) {
                int index = i + a;
                if (index >= arr.length) {
                    break;
                }
                sum += arr[index];
                st3 candidate = helper(arr, index + 1, true);
                if (candidate.bobStones + sum > canAchive) {
                    canAchive = candidate.bobStones + sum;
                    ans = new st3(candidate.bobStones + sum, candidate.aliceStones);
                }
            }
            hm.put(key, ans);
            return ans;
        }
    }

    static int dp[][];

    public static String util2(int[] stoneValue) {
        int totalSum = 0;
        for (int a : stoneValue) {
            totalSum += a;
        }
        dp = new int[stoneValue.length][2];
        int aliceScore = getAliceScore(stoneValue, 0, true);
        int bobScore = totalSum - aliceScore;
        if (bobScore == aliceScore) {
            return "Tie";
        } else if (bobScore < aliceScore) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

    public static int getAliceScore(int arr[], int i, boolean AliceTurn) {
        if (i >= arr.length) {
            return 0;
        }

        if (AliceTurn) {
            if (dp[i][1] != 0) {
                return dp[i][1];
            }

            int sum = 0;
            int ans = Integer.MIN_VALUE;
            for (int a = 0; a < 3; a++) {
                int index = a + i;
                if (index >= arr.length) {
                    break;
                }
                sum += arr[index];
                int candidate = sum + getAliceScore(arr, index + 1, false);
                ans = Math.max(ans, candidate);
            }
            return dp[i][1] = ans;
        } else {
            if (dp[i][0] != 0) {
                return dp[i][0];
            }
            int ans = Integer.MAX_VALUE;
            for (int a = 0; a < 3; a++) {
                int index = a + i;
                if (index >= arr.length) {
                    break;
                }
                int candidate = getAliceScore(arr, index + 1, true);
                ans = Math.min(ans, candidate);
            }
            return dp[i][0] = ans;
        }
    }

    // appraoch 3

    static int memo[];

    public static String util3(int arr[]) {
        memo = new int[arr.length];
        int aliceScore = getScore(arr, 0);
        if (aliceScore > 0) {
            return "Alice";
        } else if (aliceScore < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    public static int getScore(int arr[], int i) {
        if (i == arr.length) {
            return 0;
        }
        if (memo[i] != 0) {
            return memo[i];
        }
        int maxScore = Integer.MIN_VALUE;
        int stones = 0;
        for (int a = 0; a < 3; a++) {
            int index = i + a;
            if (index >= arr.length) {
                break;
            }
            stones += arr[index];
            int currScore = stones - getScore(arr, index + 1);
            maxScore = Math.max(maxScore, currScore);
        }
        return memo[i] = maxScore;
    }

}

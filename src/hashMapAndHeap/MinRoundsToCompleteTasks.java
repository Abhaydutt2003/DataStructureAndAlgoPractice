package hashMapAndHeap;

import java.util.*;

public class MinRoundsToCompleteTasks {

    public static void main(String args[]) {
        int arr[] = { 2, 2, 3, 3, 2, 4, 4, 4, 4, 4 };
        System.out.print(util2(arr));
    }

    public static int util2(int arr[]) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : arr) {
            m.put(i, (m.getOrDefault(i, 0) + 1));
        }
        int ans = 0;
        for (int freq : m.values()) {
            if (freq < 2) {
                return -1;
            }
            if (freq % 3 == 0) {
                ans += freq / 3;
            } else if (freq % 3 == 1) {
                // 2 pairs,and (freq/3)-1 triplets
                ans += (freq / 3 - 1) + 2;
            } else if (freq % 3 == 2) {
                // 1 pair,and (freq/3) triplets
                ans += (freq / 3) + 1;
            }
        }
        return ans;
    }

    public static int util1(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : arr) {
            hm.put(i, (hm.getOrDefault(i, 0) + 1));
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> en : hm.entrySet()) {
            int frq = en.getValue();
            if (frq < 2) {
                return -1;
            }
            int ans1, ans2, ans3;
            ans1 = ans2 = ans3 = Integer.MAX_VALUE;
            if (frq % 2 == 0) {
                ans1 = frq / 2;
            }
            if (frq % 3 == 0) {
                ans2 = frq / 3;
            }
            ans3 = getAns(frq);
            ans += Math.min(ans1, Math.min(ans3, ans2));
        }
        return ans;
    }

    public static int getAns(int frq) {
        int achivable3 = (frq / 3) * 3;
        while (achivable3 > 0) {
            int rest = frq - achivable3;
            if (rest % 2 == 0) {
                int ans1 = achivable3 / 3;
                int ans2 = rest / 2;
                return ans1 + ans2;
            }
            achivable3 -= 3;
        }
        return Integer.MAX_VALUE;
    }

}

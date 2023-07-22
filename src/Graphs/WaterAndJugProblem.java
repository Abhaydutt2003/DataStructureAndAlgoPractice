package Graphs;

import java.util.*;

public class WaterAndJugProblem {

    public static void main(String args[]) {
        System.out.print(util1(1, 2, 3));
    }

    public static boolean util1(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        visited = new HashSet<>();
        toAchive = targetCapacity;
        if (jug1Capacity < jug2Capacity) {
            cap1 = jug1Capacity;
            cap2 = jug2Capacity;
        } else {
            cap2 = jug1Capacity;
            cap1 = jug2Capacity;
        }
        return helper(0, 0);
    }

    static int toAchive = 0;
    static int cap1 = 0;
    static int cap2 = 0;
    static HashSet<String> visited;

    public static boolean helper(int waterIn1, int waterIn2) {
        String key = waterIn1 + "" + waterIn2;
        if (waterIn1 > cap1 || waterIn2 > cap2 || visited.contains(key)) {
            return false;
        }
        visited.add(key);
        if (waterIn1 == toAchive || waterIn2 == toAchive || (waterIn1 + waterIn2 == toAchive)) {
            return true;
        }
        // if we empty the first jug
        boolean a = helper(0, waterIn2);
        // if we empty the second jug
        boolean b = helper(waterIn1, 0);
        // if we fill only the first one with water
        boolean c = helper(cap1, waterIn2);
        // if we fill only the second one with water
        boolean d = helper(waterIn1, cap2);

        // now the conditions regarding transfer of water
        int capLeft1 = cap1 - waterIn1;
        int capLeft2 = cap2 - waterIn2;
        boolean e, f;
        if (waterIn1 >= capLeft2) {
            e = helper((waterIn1 - capLeft2), cap2);
        } else {
            e = helper(0, waterIn2 + waterIn1);
        }
        if (waterIn2 >= capLeft1) {
            f = helper(cap1, (waterIn2 - capLeft1));
        } else {
            f = helper(waterIn1 + waterIn2, 0);
        }
        return a || b || c || d || e || f;
    }

    // clever bfs solution

    public static boolean bfs(int capacity1, int capacity2, int target) {
        if (capacity1 + capacity2 < target) {
            return false;
        }
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        int[] dir = { capacity1, -capacity1, capacity2, -capacity2 };
        q.add(0);
        while (q.isEmpty() == false) {
            int currentWeight = q.poll();
            hs.add(currentWeight);
            for (int a : dir) {
                int wt = currentWeight + a;
                if (wt == target) {
                    return true;
                }
                if (hs.contains(wt) || capacity1 + capacity2 < wt || wt < 0) {
                    continue;
                } else {
                    q.add(wt);
                }
            }
        }
        return false;
    }

    // using the bezout's theorem...
    public static boolean util2(int capacity1, int capacity2, int target) {
        if (capacity1 + capacity2 < target) {
            return false;
        }
        int gcd;
        if (capacity1 > capacity2) {
            gcd = find2(capacity1, capacity2);
        } else {
            gcd = find2(capacity2, capacity1);
        }

        return (target % gcd) == 0;
    }

    public static int find2(int max, int min) {
        if (min == 0) {
            return max;
        }
        return find2(min, max % min);
    }

    

    // Bézout's identity (also called Bézout's lemma) is a theorem in the elementary
    // theory of numbers:

    // let a and b be nonzero integers and let d be their greatest common divisor.
    // Then there exist integers x
    // and y such that ax+by=d

    // In addition, the greatest common divisor d is the smallest positive integer
    // that can be written as ax + by

    // every integer of the form ax + by is a multiple of the greatest common
    // divisor d.
}

package trees;

import java.util.*;

public class UniqueBst {

    public static void main(String args[]) {
        System.out.print(util2(6));
    }

    static HashMap<Integer, Integer> hm;

    public static int util2(int n) {
        if (n == 1) {
            return 1;
        } else {
            hm = new HashMap<>();
            hm.put(1, 1);
            return helper2(n);
        }
    }

    public static int helper2(int n) {
        if (n <= 1) {
            return 1;
        }
        if (hm.containsKey(n)) {
            return hm.get(n);
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int left = helper2(i);
            int right = helper2(n - i - 1);
            ans += (left * right);
        }
        hm.put(n, ans);
        return ans;
    }

    public static int util1(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            hm = new HashMap<>();
            hm.put(2, 2);
            return helper(n);
        }
    }

    public static int helper(int n) {
        if (n == 0) {
            return 0;
        }

        if (hm.containsKey(n)) {
            return hm.get(n);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = n - i - 1;
            int right = i;
            if ((left == 1 || right == 1)) {
                if (left == right) {
                    ans += 1;
                } else if (left == 1) {
                    if (n == 6) {
                        System.out.print(left + " ");
                    }
                    ans += helper(right);
                } else {
                    if (n == 6) {
                        System.out.print(right + " ");
                    }
                    ans += helper(left);
                }
            } else {
                if (n == 6) {
                    System.out.print(left + " " + right);
                }
                ans += helper(left);
                ans += helper(right);
            }
            System.out.println();
        }
        hm.put(n, ans);
        return ans;
    }

}

package dynamicProgramming;

import java.util.*;

public class BuildArrayExactlyK {

    public static void main(String[] args) {
        System.out.println(util1(2, 3, 1));
    }
    // hashmap go brr
    public static int util1(int n, int m, int k) {
        hm = new HashMap<>();
        return (int) helper(n, m, k, Integer.MIN_VALUE);
    }

    static int mod = 1000000007;

    static HashMap<String, Long> hm;

    public static long helper(int n, int m, int search_cost, int prev_max) {
        if (n == 0) {
            if (search_cost == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        String key = n + " " + search_cost + " " + prev_max;
        if (hm.containsKey(key)) {
            return hm.get(key);
        }
        long ans = 0;
        for (int i = 1; i <= m; i++) {
            if (i > prev_max) {
                if (search_cost - 1 >= 0) {
                    long smallAns = helper(n - 1, m, search_cost - 1, i) % mod;
                    ans += smallAns;
                    ans %= mod;
                }
            } else {
                long smallAns = helper(n - 1, m, search_cost, prev_max) % mod;
                ans += smallAns;
                ans %= mod;
            }
        }
        hm.put(key, ans);
        return ans;
    }

}

package backtracking;

import java.util.*;

public class Combinations {

    public static void main(String args[]) {

    }

    // based on combination sum...

    static List<List<Integer>> answer;

    public static List<List<Integer>> util2(int n, int k) {
        answer = new ArrayList<>();
        helper(n, k, new ArrayList<Integer>(), 1);
        return answer;
    }

    public static void helper(int n, int k, List<Integer> li, int start) {
        if (li.size() == k) {
            answer.add(new ArrayList<>(li));
            return;
        }
        for (int i = start; i <= n; i++) {
            li.add(i);
            helper(n, k, li, i + 1);
            li.remove(li.size() - 1);
        }
    }

    // hahahahah, did it
    public static List<List<Integer>> util1(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> a = new ArrayList<>();
                a.add(i);
                ans.add(a);
            }
            return ans;
        } else if (n == k) {
            List<Integer> a = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                a.add(i);
            }
            ans.add(a);
            return ans;
        }
        List<List<Integer>> ans1 = util1(n - 1, k);
        List<List<Integer>> ans2 = util1(n - 1, k - 1);
        for (List<Integer> a : ans2) {
            a.add(n);
            ans.add(a);
        }
        for (List<Integer> a : ans1) {
            ans.add(a);
        }
        return ans;
    }

}

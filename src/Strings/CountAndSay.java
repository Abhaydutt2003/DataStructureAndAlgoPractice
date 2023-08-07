package Strings;

public class CountAndSay {

    public static void main(String args[]) {
        System.out.print(util1(5));
    }

    // using iteration
    public static String util2(int n) {
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for (int i = 2; i <= n; i++) {
            ans = helper(ans);
        }
        return ans.toString();
    }

    public static StringBuilder helper(StringBuilder prev) {
        StringBuilder ans = new StringBuilder();
        int freq = 1;
        for (int i = 0; i < prev.length(); i++) {
            if (i == prev.length() - 1 || prev.charAt(i) != prev.charAt(i + 1)) {
                ans.append(freq);
                ans.append(prev.charAt(i));
                freq = 1;
            } else {
                freq++;
            }
        }
        return ans;
    }

    // using recursion
    public static String util1(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = util1(n - 1);
        String ans = "";
        int freq = 1;
        for (int i = 0; i < prev.length(); i++) {
            if (i == prev.length() - 1 || prev.charAt(i) != prev.charAt(i + 1)) {
                ans += freq;
                ans += prev.charAt(i);
                freq = 1;
            } else {
                freq++;
            }
        }
        return ans;
    }
}

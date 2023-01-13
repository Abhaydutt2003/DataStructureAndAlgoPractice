package dynamicProgramming;

public class OptimizedPalindromePartition {
    public static void main(String args[]) {
        String s = "aab";
        int ans = solve(s);
        System.out.print(ans + " ");
    }

    static int dp1[][];// for number of partitions.
    static int dp2[][];// for palindrome function.

    public static int solve(String s) {
        dp1 = new int[s.length() + 1][s.length() + 1];
        dp2 = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < s.length() + 1; j++) {
                dp1[i][j] = -1;
                dp2[i][j] = -1;
            }
        }
        int ans = helper(s, 0, s.length() - 1);
        return ans;
    }

    public static int helper(String s, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (dp1[i][j] != -1) {
            return dp1[i][j];
        }
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int ans1 = helper(s, i, k);
            int ans2 = helper(s, k + 1, j);
            int current = 1 + ans1 + ans2;
            ans = (ans > current) ? current : ans;
        }
        dp1[i][j] = ans;
        return ans;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        if (dp2[i][j] != -1) {
            if (dp2[i][j] == 1) {
                return true;
            } else {
                return false;
            }
        }
        int a = i, b = j;
        while (a < b) {
            if(dp2[a][b]!=-1){
                if(dp2[a][b]==1){
                    dp2[i][j] = 1;
                    return true;
                }else{
                    dp2[i][j] = 0;
                    return false;
                }
            }
            if (s.charAt(a) != s.charAt(b)) {
                dp2[i][j] = 0;
                return false;
            }
            a++;
            b--;
        }
        dp2[i][j] = 1;
        return true;
    }

}

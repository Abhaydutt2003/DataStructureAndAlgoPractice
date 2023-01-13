package dynamicProgramming;

public class PalindromicPartitioning2 {
    public static void main(String args[]) {
        String s = "aab";
        System.out.print(minCut(s));
    }

    public static int minCut(String s) {
        int i = 0, j = s.length() - 1;
        int dp[] =new int[s.length()+1];
        for(int a = 0;a<s.length()+1;a++){
            dp[a] = -1;
        }
        int ans = solve(s, i, j, dp);
        return ans;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        int a = i, b = j;
        while (a < b) {
            if (s.charAt(a) != s.charAt(b)) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    } 

    public static int helper(String s, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int ans1 = helper(s, i, k);
            int ans2 = helper(s, k + 1, j);
            int current = ans1 + ans2 + 1;
            ans = (ans > current) ? current : ans;
        }
        return ans;
    }

    public static int helperMemo(String s, int i, int j, int[][] memo) {
        if (i >= j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int ans1 = helperMemo(s, i, k, memo);
            int ans2 = helperMemo(s, k + 1, j, memo);
            int current = ans1 + ans2 + 1;
            ans = (ans > current) ? current : ans;
        }
        memo[i][j] = ans;
        return ans;
    }
    //does not work on letcode......
    // need to memoize palindrome code too....
    public static int helperMemo2(String s, int i, int j, int[][] memo) {
        if (i >= j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int ans1,ans2;
            if(memo[i][k]!=-1){
                ans1 = memo[i][k];
            }else{
                ans1 = helperMemo2(s,i,k,memo);
                memo[i][k] = ans1;
            }if(memo[k+1][j]!=-1){
                ans2 = memo[k+1][j];
            }else{
                ans2 = helperMemo2(s, k+1, j, memo);
                memo[k+1][j] = ans2;
            }
            int current = ans1+ans2+1;
            ans = (ans > current) ? current : ans;
        }
        memo[i][j] = ans;
        return ans;
    }
    public static int solve(String s, int i, int j, int[] dp){
        if(i>=j){return 0;}
        if(dp[i]!=-1){return dp[i];}
        if(isPalindrome(s, i, j)){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            if(isPalindrome(s, i, k)){
                int temp = solve(s,k+1,j,dp)+1;
                ans = Math.min(ans, temp);
            }
        }
        return dp[i] = ans;
    }
    

}

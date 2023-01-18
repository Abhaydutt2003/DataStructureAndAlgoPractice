package dynamicProgramming;

public class BooleanParenthesization {
    public static void main(String args[]) {
        String s = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
        int ans = countWays(s.length(), s);
        System.out.print(ans + " ");
    }

    public static int countWays(int N, String S) {
        // int ans = helper(S, 0, S.length() - 1, true);
        // return ans;
        dp = new int[N+1][N+1][2];
        for(int i =0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                for(int k = 0;k<dp[0][0].length;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return helperDp(S,0,S.length()-1,1);
    }

    public static int helper(String s, int i, int j, boolean isTrue) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (s.charAt(j) == 'T') {
                return (isTrue == true) ? 1 : 0;
            } else {
                return (isTrue == false) ? 1 : 0;
            }
        }
        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            int leftTrue = helper(s, i, k - 1, true);
            int leftFalse = helper(s, i, k - 1, false);
            int rightTrue = helper(s, k + 1, j, true);
            int rightFalse = helper(s, k + 1, j, false);
            if (s.charAt(k) == '&') {
                if (isTrue == true) {
                    ans += (leftTrue * rightTrue);
                } else {
                    ans += (leftFalse * rightFalse) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
                }
            } else if (s.charAt(k) == '|') {
                if (isTrue == true) {
                    ans += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue);
                } else {
                    ans += (leftFalse * rightFalse);
                }
            } else {
                if (isTrue == true) {
                    ans += (leftTrue * rightFalse) + (leftFalse * rightTrue);
                } else {
                    ans += (leftFalse * rightFalse) + (leftTrue * rightTrue);
                }
            }
        }
        return ans;
    }
    static int[][][] dp;
    public static int helperDp(String s, int i, int j, int isTrue){
        if(i>j){return 0;}
        if(i == j){
            if (s.charAt(j) == 'T') {
                return (isTrue == 1) ? 1 : 0;
            } else {
                return (isTrue == 0) ? 1 : 0;
            }
        }
        if(dp[i][j][isTrue]!=-1){
            return dp[i][j][isTrue];
        }
        long ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            int leftTrue = helperDp(s, i, k - 1, 1);
            int leftFalse = helperDp(s, i, k - 1, 0);
            int rightTrue = helperDp(s, k + 1, j, 1);
            int rightFalse = helperDp(s, k + 1, j, 0);
            if (s.charAt(k) == '&') {
                if (isTrue == 1) {
                    ans += (leftTrue * rightTrue);
                } else {
                    ans += (leftFalse * rightFalse) + (leftTrue * rightFalse) + (leftFalse * rightTrue);
                }
            } else if (s.charAt(k) == '|') {
                if (isTrue == 1) {
                    ans += (leftTrue * rightFalse) + (leftFalse * rightTrue) + (leftTrue * rightTrue);
                } else {
                    ans += (leftFalse * rightFalse);
                }
            } else {
                if (isTrue == 1) {
                    ans += (leftTrue * rightFalse) + (leftFalse * rightTrue);
                } else {
                    ans += (leftFalse * rightFalse) + (leftTrue * rightTrue);
                }
            }
        }
        return dp[i][j][isTrue] = (int)(ans%1003);
    }

}

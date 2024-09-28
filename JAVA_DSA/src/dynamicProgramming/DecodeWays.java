package dynamicProgramming;


public class DecodeWays {

    public static void main(String args[]) {
        String str = "110199";
        int ans2 = util2(str);
        System.out.print(ans2);
        // util1(str);
        // System.out.print(ans);
    }

    public static int util2(String str) {
        int dp[] = new int[str.length() + 1];
        dp[str.length()] = 1;
        if (str.charAt(str.length() - 1) == '0') {
            dp[str.length() - 1] = 0;
        } else {
            dp[str.length() - 1] = 1;
        }
        for (int i = str.length() - 2; i >= 0; i--) {
            if (str.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            dp[i] += dp[i + 1];
            if (Integer.parseInt(str.substring(i, i + 2)) <= 26) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    static int ans = 0;

    public static void util1(String str) {
        if (str.length() == 0) {
            ans++;
            return;
        }
        if (str.charAt(0) == '0') {
            return;
        }
        for (int k = 1; k <= str.length(); k++) {
            String left = str.substring(0, k);
            if (isValid(left)) {
                util1(str.substring(k));
            } else {
                break;
            }
        }
    }

    public static boolean isValid(String str) {
        if (str.length() > 2) {
            return false;
        } else if (Integer.parseInt(str) > 26) {
            return false;
        } else {
            return true;
        }
    }

}

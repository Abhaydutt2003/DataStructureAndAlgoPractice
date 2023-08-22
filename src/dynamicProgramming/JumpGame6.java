package dynamicProgramming;

public class JumpGame6 {

    public static void main(String args[]) {
        String str = "00111010";
        System.out.print(util3(str, 3, 5));
    }

    // basic 1-d dp solution
    public static boolean util1(String str, int minJump, int maxJump) {
        if (str.charAt(str.length() - 1) != '0') {
            return false;
        }
        boolean dp[] = new boolean[str.length()];
        dp[dp.length - 1] = true;
        for (int i = dp.length - 2; i >= 0; i--) {
            if (str.charAt(i) == '1') {
                dp[i] = false;
            } else {
                for (int j = i + minJump; j < dp.length && j <= i + maxJump; j++) {
                    if (dp[j] == true) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }

    // optimised dp

    public static boolean util3(String str, int minJump, int maxJump) {
        if (str.charAt(str.length() - 1) == '1') {
            return false;
        }
        int n = str.length();
        int start = 0;
        int end = 0;
        boolean dp[] = new boolean[str.length()];
        dp[0] = true;
        for (int i = 0; i < str.length(); i++) {
            if (dp[i] == false) {
                continue;
            }
            start = Math.max(i + minJump, end + 1);
            end = Math.min(n - 1, i + maxJump);
            for (int j = start; j <= end; j++) {
                if (str.charAt(j) == '0') {
                    dp[j] = true;
                }
            }
            if (dp[n - 1]) {
                return true;
            }
        }
        return dp[n - 1];
    }

    // expand boundry solution
    // fails many test cases
    public static boolean util2(String str, int minJump, int maxJump) {
        int boundryEnd = 0;
        int i = 0;
        while (i <= boundryEnd) {
            if (str.charAt(i) == '0') {
                boundryEnd = i + maxJump;
                i = i + minJump;
                if (boundryEnd >= str.length() - 1) {
                    if (i <= str.length() - 1 && str.charAt(str.length() - 1) != '1') {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                i++;
            }
        }
        return false;
    }

}

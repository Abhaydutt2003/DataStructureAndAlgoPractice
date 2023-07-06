package dynamicProgramming;

public class PalindromicSubstrings {

    public static void main(String args[]) {
        String str = "caad";
        System.out.print(util3(str));
    }

    // expand around center approach
    public static int util3(String str) {
        int ans = 0;
        int i = 0;
        while (i < str.length()) {
            int leftIndex = i;
            int rightIndex = i;
            while (rightIndex < str.length() - 1 && str.charAt(rightIndex) == str.charAt(rightIndex + 1)) {
                rightIndex++;
            }
            i = rightIndex+1;
            int midLength = rightIndex - leftIndex + 1;
            int possiblePalindromes = ((midLength) * (midLength + 1)) / 2;
            while (leftIndex > 0 && rightIndex < str.length() - 1
                    && str.charAt(rightIndex + 1) == str.charAt(leftIndex - 1)) {
                possiblePalindromes++;
                leftIndex--;
                rightIndex++;
            }
            ans += possiblePalindromes;
        }
        return ans;
    }

    // almost correct
    public static int util2(String str) {
        int dp[][] = new int[str.length() + 1][str.length() + 1];
        String reverse = reverse(str);
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            int colMax = 0;
            for (int j = 1; j < dp.length; j++) {
                if (str.charAt(i - 1) == reverse.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > colMax && i - dp[i][j] == str.length() - j) {
                    colMax = dp[i][j];
                }
            }
            ans += colMax;
            colMax = 0;
        }
        return ans;
    }

    // wrong approach
    public static int util1(String str1) {

        String str2 = reverse(str1);
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans++;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return ans;
    }

    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}

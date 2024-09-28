package dynamicProgramming;

//import java.util.*;

public class InterleavingString {

    public static void main(String args[]) {
        String s1 = "aabaac";
        String s2 = "aadaaeaaf";
        String s3 = "aadaaeaabaafaac";
        System.out.print(util2(s1, s2, s3));
    }

    // so apparantely, it is always garunteed that whenever the two String will make
    // up the third String
    // they will always follow Math.abs(subset1Length-subset2Length)<=1
    // dry run to know...

    static Boolean dp[][];

    public static boolean util2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return helper2(s1, s2, s3, 0, 0, 0);
    }

    public static boolean helper2(String s1, String s2, String s3, int i, int j, int k) {
        if (i >= s1.length() && j >= s2.length() && k >= s3.length()) {
            return true;
        }
        if ((i >= s1.length() || j >= s2.length()) && k >= s3.length()) {
            return false;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean ans = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            boolean smallAns = helper2(s1, s2, s3, i + 1, j, k + 1);
            if (smallAns) {
                ans = smallAns;
            }
        }
        if (j < s2.length() && s3.charAt(k) == s2.charAt(j) && ans == false) {
            boolean smallAns = helper2(s1, s2, s3, i, j + 1, k + 1);
            if (smallAns) {
                ans = smallAns;
            }
        }
        return dp[i][j] = ans;
    }

    // this is not really a nice approach.
    public static boolean util1(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();
        char arr3[] = s3.toCharArray();
        return helper(arr1, arr2, arr3, 0, 0, 0);
    }

    static int no1 = 0;
    static int no2 = 0;

    public static boolean helper(char arr1[], char arr2[], char[] arr3, int i, int j, int k) {
        if (i == arr1.length && j == arr2.length && k == arr3.length) {
            if (Math.abs(no1 - no2) <= 1) {
                return true;
            }
            return false;
        }

        no1++;
        boolean ans = false;
        for (int a = i, temp = k; (ans == false) && (a < arr1.length && temp < arr3.length)
                && (arr1[a] == arr3[temp]); a++, temp++) {
            boolean smallAns = helper(arr1, arr2, arr3, a + 1, j, temp + 1);
            if (smallAns) {
                ans = true;
            }
        }
        no1--;
        // now checking for the second String
        no2++;
        for (int b = j, temp = k; (ans == false) && (b < arr2.length && temp < arr3.length)
                && (arr2[b] == arr3[temp]); b++, temp++) {
            boolean smallAns = helper(arr1, arr2, arr3, i, b + 1, temp + 1);
            if (smallAns) {
                ans = true;
            }
        }
        no2--;
        return ans;
    }

}

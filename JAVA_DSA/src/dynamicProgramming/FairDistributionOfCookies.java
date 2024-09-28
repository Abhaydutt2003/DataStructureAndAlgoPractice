package dynamicProgramming;

public class FairDistributionOfCookies {

    public static void main(String args[]) {
        int arr[] = { 8, 15, 10, 20, 8 };
        int k = 2;
        System.out.print(util1(arr, k));
    }

    static int[] children;

    public static int util1(int[] cookies, int k) {
        children = new int[k];
        return helper(cookies, 0);
    }

    public static int helper(int[] cookies, int i) {
        if (i == cookies.length) {
            int max = Integer.MIN_VALUE;
            for (int a : children) {
                max = Math.max(a, max);
            }
            return max;
        }
        int theCookieToPut = cookies[i];
        int ans = Integer.MAX_VALUE;
        for (int a = 0; a < children.length; a++) {
            children[a] += theCookieToPut;
            int smallAns = helper(cookies, i + 1);
            ans = Math.min(ans, smallAns);
            children[a] -= theCookieToPut;
        }
        return ans;
    }

}

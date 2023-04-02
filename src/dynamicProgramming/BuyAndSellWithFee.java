package dynamicProgramming;

public class BuyAndSellWithFee {
    public static void main(String args[]) {
        int arr[] = { 1, 3, 2, 8, 4, 9 };
        dp = new int[arr.length][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(util2(arr, 2));
    }

    static int dp[][];
    static int fee = 2;

    // dp approach
    public static int util1(int prices[], int buy, int i) {
        if (i == prices.length) {
            return 0;
        }
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }

        int ans;
        if (buy == 0) {
            int ans1 = util1(prices, buy, i + 1);
            int ans2 = util1(prices, 1, i + 1) - prices[i];
            ans = Math.max(ans2, ans1);
        } else {
            int ans1 = util1(prices, buy, i + 1);
            int ans2 = util1(prices, 0, i + 1) + (prices[i] - fee);
            ans = Math.max(ans2, ans1);
        }
        return dp[i][buy] = ans;
    }

    // peak valley approach...

    //tried , un optimal,usless approach.. 
    public static int util2(int prices[], int fee1) {
        int peak = prices[0];
        int valley = prices[0];
        int i = 0, ans = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];

            // finding peak will be different
            while (i < prices.length - 1) {
                while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                    i++;
                }
                if (prices[i] - (valley + fee1) > fee1) {
                    peak = prices[i];
                    break;
                } else if (i == prices.length - 1) {
                    valley = 0;
                    peak = 0;
                    break;
                } else {
                    i++;
                }
            }
            i++;
            ans += peak - (valley + fee1);
        }
        return ans;
    }

    //best approach
    
}

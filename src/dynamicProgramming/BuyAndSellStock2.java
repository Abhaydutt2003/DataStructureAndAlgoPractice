package dynamicProgramming;

public class BuyAndSellStock2 {
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5};
        // dp = new int[arr.length][arr.length+1];
        // for(int i = 0;i<dp.length;i++){
        //     for(int j = 0;j<dp[0].length;j++){
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(util2(arr,0,0));
        dp2 = new int[arr.length][2];
        for(int i = 0;i<dp2.length;i++){
            for(int j =0;j<dp2[0].length;j++){
                dp2[i][j] = -1;
            }
        }
        System.out.println(util3(arr,0,0));
    }
    

    public static int util1(int prices[],int prevStock,int i){
        if(i == prices.length){
            return 0;
        }
        if(prevStock == -1){
            int ans1 = util1(prices,prevStock,i+1);
            int ans2 = util1(prices,prices[i],i+1);
            return Math.max(ans1, ans2);
        }else{
            //to not sell the stock
            int ans1 = util1(prices,prevStock,i+1);
            //or to not sell the stock
            int ans2 = Integer.MIN_VALUE;
            if(prices[i]>=prevStock){
                ans2 = util1(prices,-1,i+1)+ (prices[i]-prevStock);
            }
            return Math.max(ans1, ans2);
        }
    }
    //0 would indicate that we have not taken the stock
    //THIS IS MY APPROACH
    static int dp[][];
    public static int util2(int prices[], int prevStockIndex, int i){
        if(i == prices.length){
            return 0;
        }
        if(dp[i][prevStockIndex] != -1){
            return dp[i][prevStockIndex];
        }
        int ans;
        if(prevStockIndex == 0){
            int ans1 = util2(prices,prevStockIndex,i+1);
            int ans2 = util2(prices, i+1, i+1);
            ans = Math.max(ans1, ans2);
        }else{
            //to not sell the stock
            int ans1 = util2(prices,prevStockIndex,i+1);
            //or to sell the stock
            int ans2 = Integer.MIN_VALUE;
            if(prices[prevStockIndex-1]<=prices[i]){
                ans2 = util2(prices,0, i+1) + (prices[i]-prices[(prevStockIndex-1)]);
            }
            ans = Math.max(ans1, ans2);
        }
        return dp[i][prevStockIndex] = ans;
    }


    //APPROACH LEARNT ON LEETCODE
    static int dp2[][];
    public static int util3(int prices[],int i, int buy){
        if(i == prices.length){
            return 0;
        }
        if(dp2[i][buy] != -1){
            return dp2[i][buy];
        }
        int ans;
        if(buy == 0){
            int ans1 = util3(prices,i+1,buy);
            int ans2 = util3(prices,i+1,1) - prices[i];
            ans = Math.max(ans2, ans1);
        }else{
            //we will not sell the stock
            int ans1 =util3(prices,i+1,buy);
            // we will sell the stock
            int ans2 = util3(prices,i+1,0) + prices[i];
            ans = Math.max(ans2,ans1);
        }
        return dp2[i][buy] = ans;
    }

    //peak valley approach...
    public static int util4(int prices[]){
        int valley = prices[0];
        int peak = prices[0];
        int ans = 0,i=0;
        while(i<prices.length-1){
            while(i<prices.length-1 && prices[i]>=prices[i+1]){
                i++;
            }
            valley =prices[i];
            while(i<prices.length-1 && prices[i]<=prices[i+1]){
                i++;
            }
            peak = prices[i];
            ans+= (peak-valley);
        }
        return ans;
    }
    
}

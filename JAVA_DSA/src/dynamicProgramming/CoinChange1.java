package dynamicProgramming;

public class CoinChange1 {
    public static void main(String args[]){
        int arr[] = {2};
        int target = 3;
        System.out.print(tabulation(arr,target));
    }
    public static int coinChange(int coins[], int amount){
        int memo[][] = new int[coins.length+1][amount+1];
        for(int i = 0;i<memo.length;i++)
        for(int j = 0;j<memo[0].length;j++)
        memo[i][j] = -1;
        int ans =  helper(coins,amount,coins.length,0,memo);
        return (ans != Integer.MAX_VALUE)?ans:-1;
    }
    private static int helper(int coins[], int amount, int N, int coinsUsed, int memo[][]){
        if(amount<0){return Integer.MAX_VALUE;}
        if(amount == 0){return coinsUsed;}
        if(N == 0){
            if(amount == 0){return coinsUsed;}
            return Integer.MAX_VALUE;
        }
        if(memo[N][amount]!=-1){return memo[N][amount];}
        int ans1 = helper(coins,amount,N-1,coinsUsed,memo);
        int ans2 = helper(coins,amount-coins[N-1],N,coinsUsed+1,memo);
        return memo[N][amount] = Math.min(ans1, ans2);
    }
    public static int tabulation(int coins[], int amount){
        int t[][] = new int[coins.length+1][amount+1];
        for(int j =0;j<amount+1;j++){
            t[0][j] = Integer.MAX_VALUE;
        }
        t[0][0] =0;
        for(int i = 1;i<coins.length+1;i++){
            for(int j =1;j<amount+1;j++){
                if(coins[i-1]<=j){
                    int ans1 = t[i-1][j];
                    int ans2 = t[i][j-coins[i-1]];
                    if(ans2!=Integer.MAX_VALUE){ans2+=1;}
                    t[i][j] = Math.min(ans1, ans2);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[coins.length][amount];
    }
    public static int coinChangeRec(int [] coins, int amount, int N, int coinsUsed){
        if(amount<0){return Integer.MAX_VALUE;}
        if(amount == 0){return coinsUsed;}
        if(N == 0){
            if(amount == 0){return coinsUsed;}
            return Integer.MAX_VALUE;
        }
        int ans1 = coinChangeRec(coins,amount,N-1,coinsUsed);
        int ans2 = coinChangeRec(coins,amount-coins[N-1],N,coinsUsed+1);
        return Math.min(ans1, ans2);
    }
}

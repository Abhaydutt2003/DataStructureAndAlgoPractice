package dynamicProgramming;

public class CoinChange2 {
    public static void main(String args[]){
        int arr[] = {1,2,5};
        int target = 5;
        System.out.print(change(target,arr));
    }
    public static int change(int amount, int [] coins, int N){
        if(amount == 0){return 1;}
        if(amount<0){return 0;}
        if(N == 0){
            if(amount == 0){return 1;}
            return 0;
        }
        int ans1 = change(amount,coins,N-1);
        int ans2 = change(amount-coins[N-1],coins,N);
        return ans1+ans2;
    }
    public static int changeDp(int amount, int[] coins){
        int t[][] = new int[coins.length+1][amount+1];
        for(int i = 0;i<coins.length+1;i++){
            t[i][0] = 1; 
        }
        for(int i =1;i<coins.length+1;i++){
            for(int j = 0;j<amount+1;j++){
                if(coins[i-1]<=j){
                    t[i][j] = t[i-1][j]+t[i][j-coins[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[coins.length][amount];
    }
    public static int change(int amount, int [] coins){
        int memo[][] = new int[coins.length+1][amount+1];
        for(int i = 0;i<memo.length;i++)
        for(int j = 0;j<memo[0].length;j++)
        memo[i][j] = -1;
        return helper(amount,coins,coins.length,memo);
    }
    public static int helper(int amount, int coins[], int N, int memo[][]){
        if(amount==0){return 1;}
        if(amount<0){return 0 ;}
        if(N == 0){
            if(amount == 0 ){return 1;}
            return 0;
        }
        if(memo[N][amount]!=-1){return memo[N][amount];}
        int ans1 = helper(amount,coins,N-1,memo);
        int ans2 = helper(amount-coins[N-1],coins,N,memo);
        memo[N][amount] = ans1+ans2;
        return  memo[N][amount];
    }
    
}

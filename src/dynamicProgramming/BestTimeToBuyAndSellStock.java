package dynamicProgramming;

public class BestTimeToBuyAndSellStock {
    public static void main(String args[]){
        int arr[] = {7,6,4,3,1};
        rec(arr,arr.length,Integer.MIN_VALUE);
        System.out.print(ans+" ");
    }
    static int ans = Integer.MIN_VALUE;
    public static void rec(int arr[], int N, int max){
        if(N == 0){return;}
        if(arr[N-1] > max){max = arr[N-1];}
        int possibleCandidate = max-arr[N-1];
        if(ans<possibleCandidate){ans = possibleCandidate;}
        rec(arr,N-1,max);
    }

    //better iterative code..
    public static int maxProfit(int[] prices){
        int maxTillNow = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for(int i = prices.length-1;i>=0;i--){
            if(prices[i]>maxTillNow){
                maxTillNow = prices[i];
            }else{
                int temp = maxTillNow-prices[i];
                ans = Math.max(ans, temp);
            }
        }
        if(ans == Integer.MIN_VALUE){return 0;}
        return ans;
    }

    
}

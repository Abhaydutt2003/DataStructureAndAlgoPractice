package dynamicProgramming;

public class SuoerEggDrop {
    public static void main(String args[]){
        int eggs = 2;
        int floors = 6;
        System.out.print(superEggDrop(eggs,floors));
    }
    public static int superEggDrop(int k , int n){
       // int ans = helper(k,n);
       dp = new int[k+1][n+1];
       for(int i = 0;i<dp.length;i++){
        for(int j = 0;j<dp[0].length;j++){
            dp[i][j] = -1;
        }
       }
       int ans = helperBs(k,n);
        return ans;
    }
    //bad recursive code based on mcm
    public static int helper(int eggs, int floors){
        if(eggs == 1){return floors;}
        if(floors == 0 || floors == 1){return floors;}
        int ans = Integer.MAX_VALUE;
        for(int k=1;k<=floors;k++){
            int ans1 = helper(eggs-1,k-1);
            int ans2 = helper(eggs,floors-k);
            int ans3 = 1+Math.max(ans1, ans2);
            ans = Math.min(ans, ans3);
        }
        return ans;
    }
    //using memoization...
    static int dp[][];
    public static int helperDp(int eggs, int floors){
        if(eggs == 1){return floors;}
        if(floors == 0 || floors == 1){return floors;}
        if(dp[eggs][floors] != -1){return dp[eggs][floors];}
        int ans = Integer.MAX_VALUE;
        for(int k=1;k<=floors;k++){
            int ans1 = helperDp(eggs-1,k-1);
            int ans2 = helperDp(eggs,floors-k);
            int ans3 = 1+Math.max(ans1, ans2);
            ans = Math.min(ans, ans3);
        }
        return dp[eggs][floors] = ans;
    }
    //you might realize we can use binary search here
    public static int helperBs(int eggs, int floors){
        if(eggs == 1){return floors;}
        if(floors == 1 || floors == 0){return floors;}
        if(dp[eggs][floors] != -1){return dp[eggs][floors];}
        int ans = Integer.MAX_VALUE;
        int low = 1,high = floors,mid = 0;
        while(low<=high){
            mid = low+(high-low)/2;
            int ans1 = helperBs(eggs-1,mid-1);
            int ans2 = helperBs(eggs,floors-mid);
            int ans3 = Math.max(ans1, ans2)+1;
            ans = (ans>ans3)?ans3:ans;
            //we always want to consider the worst case...
            if(ans1<ans2){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return dp[eggs][floors] = ans;
    }
}

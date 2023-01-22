package dynamicProgramming;

public class BurstBallons {
    public static void main(String args[]){
        int arr[] = {3,1,5,8};
        System.out.print(maxCoins(arr));
    }
    public static int maxCoins(int []nums){
        dp = new int[nums.length+1][nums.length+1];
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int ans = helperMethod2(nums,0,nums.length-1);
        return ans;
    }
    public static int helperMethod(int arr[], int i , int j){
        if(i>j){return 0;}
        int left = 1,right=1;
        if(i>0){
            left = arr[i-1];
        }
        if(j<arr.length-1){
            right = arr[j+1];
        }
        int ans = Integer.MIN_VALUE;
        for(int k = i;k<=j;k++){
            int temp = arr[k]*left*right;
            int leftCall = helperMethod(arr,i,k-1);
            int rightCall = helperMethod(arr,k+1,j);
            int temp2 = temp+leftCall+rightCall;
            ans = Math.max(ans, temp2);
        }
        return ans;
    }
    static int dp[][];
    public static int helperMethod2(int arr[], int i, int j){
        if(i>j){return 0;}
        if(dp[i][j]!=-1){return dp[i][j];}
        int left = 1,right=1;
        if(i>0){
            left = arr[i-1];
        }
        if(j<arr.length-1){
            right = arr[j+1];
        }
        int ans = Integer.MIN_VALUE;
        for(int k = i;k<=j;k++){
            int temp = arr[k]*left*right;
            int leftCall = helperMethod2(arr,i,k-1);
            int rightCall = helperMethod2(arr,k+1,j);
            int temp2 = temp+leftCall+rightCall;
            ans = Math.max(ans, temp2);
        }
        return dp[i][j] = ans;
    }

    
}

package dynamicProgramming;

public class TargetSum {
    public static void main(String [] args){
        int arr[] = {1,0};
        int target = 1;
        System.out.print(findTargetSumWays(arr,target));
    }
    public static int findTargetSumWaysRec(int[] nums, int target) {
        return helper(nums,nums.length,target);
    }
    private static int helper(int arr[], int N, int target){
     //   if(target<0){return 0;}
     //we comment the above condition because we might meet positive values
     //ahead..
        if(N == 0){
            if(target == 0){return 1;}
            return 0;
        }
        int ans1 = helper(arr,N-1,target+arr[N-1]);
        int ans2 = helper(arr,N-1,target-arr[N-1]);
        return ans1+ans2;
    }
    public static int findTargetSumWays(int nums[],int target ){
        int sum=0;
        for(int i:nums){sum+=i;}
        if(sum<Math.abs(target) || (target+sum)%2!=0){return 0;}
        int s1 = (target+sum)/2;
        return helperTab(nums,s1);
    }
    private static int helperTab(int arr[], int sum){
        int t[][] = new int[arr.length+1][sum+1];
        for(int i = 0;i<arr.length+1;i++){
            t[i][0] = 1;
        }
        for(int i = 1;i<arr.length+1;i++){
            //taking j == 0 because we have the possibility of having 0 in arr
            for(int j = 0;j<sum+1;j++){
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j]+t[i-1][j-arr[i-1]];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[arr.length][sum];
    }
}

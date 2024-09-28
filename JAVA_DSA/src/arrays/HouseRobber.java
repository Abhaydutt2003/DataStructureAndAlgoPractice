package arrays;

public class HouseRobber {

	public static void main(String[] args) {
		int arr[] = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
		//System.out.println(rob(arr));
		int dp[] = new int[arr.length+1];
		for(int i = 0;i<dp.length;i++)
			dp[i] = -1;
		
		System.out.println(memoHelper(arr,0,dp,false));
		System.out.println(dpRobber(arr));

	}
	// bad recursive code...
	public static int rob(int [] nums) {
		int ans  = helper(nums,0,false);
		return ans;
	}
	private static int helper(int arr[], int i, boolean prevUsed) {
		if(i == arr.length) {return 0;}
		int smallAns2 = Integer.MIN_VALUE,smallAns1 = helper(arr,i+1,false);
		if(!prevUsed) {
			smallAns2 = helper(arr,i+1,true)+arr[i];
		}
		return Math.max(smallAns2, smallAns1);
	}
	//memo code...
	private static int memoHelper(int arr[], int i, int dp[],boolean prevUsed) {
		if(i == arr.length) {return 0;}
		int smallAns1 = Integer.MIN_VALUE,smallAns2 =Integer.MIN_VALUE;
		if(dp[i+1]!=-1) {
			smallAns1 = dp[i+1];
			if(!prevUsed) {smallAns2 = dp[i+1]+arr[i];}
		}else {
		    smallAns1 = memoHelper(arr,i+1,dp,false);
		    dp[i+1] = smallAns1;
		    if(!prevUsed) {
		    	smallAns2 = memoHelper(arr,i+1,dp,true);
		    	if(dp[i+1]<smallAns2) {dp[i+1] = smallAns2;}
		    	smallAns2+=arr[i];
		    }
		}
		return Math.max(smallAns1, smallAns2);
	}
	//dynamic programming code...
	public static int dpRobber(int arr[]) {
		if(arr.length == 0) {return 0;}
		if(arr.length == 1) {return arr[0];}
		int dp[] = new int[arr.length+1];
		dp[0] = 0;dp[1] = arr[arr.length-1];
		int j = arr.length-2;
		for(int i = 2;i<dp.length;i++) {
			dp[i] = Math.max(dp[i-1],dp[i-2]+arr[j]);
			j--;
		}
		return dp[arr.length];
	}

}

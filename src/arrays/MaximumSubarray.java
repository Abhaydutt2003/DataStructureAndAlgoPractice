package arrays;
public class MaximumSubarray {
	

	public static void main(String[] args) {
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.print(kadane(arr));
	}
	
	
	public static int maxSubArray(int [] nums) {
		return helper2(nums,0,0);
	}
	public static int helper(int [] arr, int i) {
		if(i>=arr.length) {
			return 0;
		}
		int smallOutput1 = helper(arr,i+1)+arr[i];
		int smallOutput2 = helper(arr,i+1);
		return Math.max(smallOutput1, smallOutput2);
	}
	public static int helper2(int arr[], int i, int soFar) {
		if(i>=arr.length) {
			return soFar;
		}
		int toSend = soFar+arr[i];
		int smallOutput1 = Integer.MIN_VALUE;
		if(toSend >=0) {
			smallOutput1 = helper2(arr,i+1,toSend);
		}
		int smallOutput2 = helper2(arr,i+1,0);
		return Math.max(smallOutput1, smallOutput2);
	}
	public static int dp(int arr[]) {
		int dp[] = new int[arr.length+1];
		for(int i = 1;i<=arr.length;i++)
			dp[i] = Math.max(arr[i-1],(dp[i-1] + arr[i-1]));
		
		int max = 0;
		for(int i = 0;i<dp.length;i++)
			if(dp[i]>max) {
				max = dp[i];
			}
		
		return max;
	}
	public static int dp2(int arr[]) {
		int dp[] = new int[arr.length];
		dp[0] = arr[0];
		int max = dp[0];
		for(int i =1;i<arr.length;i++) {
			dp[i] = Math.max(dp[i-1] + arr[i],arr[i]);
			if(dp[i]>max) {
				max = dp[i];
			}
		}
		return max;	
	}
	public static int kadane(int arr[]) {
		int maxNow = 0;
		int totalMax = Integer.MIN_VALUE;
		for(int i = 0;i<arr.length;i++) {
			maxNow += arr[i];
			totalMax = Math.max(totalMax,maxNow);
			if(maxNow<0) {
				maxNow = 0;
			}
		}
		return totalMax;
	}
//	public static void print(int arr[]) {
//		int maxNow = 0;
//		
//	}

}

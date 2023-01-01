package dynamicProgramming;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,5,11,5};
		System.out.print(canPartition(arr));

	}
	public static boolean can(int[] nums) {
		int sum=0;
		for(int i:nums) {sum+=i;}
		 boolean ans = helperMemo(nums,sum,0,nums.length);
		 return ans;
	}
	public static boolean helper(int [] arr,int sum1,int sum2,int N){
		if(N == 0) {
			if(sum1 == sum2) {
				return true;
			}
			return false;
		}
		boolean ans1 = helper(arr,sum1+arr[N-1],sum2,N-1);
		boolean ans2 = helper(arr,sum1,sum2+arr[N-1],N-1);
		return (ans1 == true)?ans1:ans2;
	}
	static boolean[][] memo = new boolean[1000][1000];
	private static boolean helperMemo(int arr[], int sum, int currentSum, int N){
		if(N == 0) {
			if((currentSum + currentSum) == sum) {
				return true;
			}return false;
		}
		if(memo[N][currentSum]!= false) {return true;}
		boolean ans1 = helperMemo(arr,sum,currentSum,N-1);
		boolean ans2 = helperMemo(arr,sum,currentSum+arr[N-1],N-1);
		return (ans1==true)?ans1:ans2;
	}
	public static boolean canPartition(int [] nums){
		int sum=0;
		for(int i : nums) {sum+=i;}
		if(sum%2!=0) {return false;}sum/=2;
		boolean t[][] = new boolean[nums.length+1][sum+1];
		for(int i = 0,j=0;i<nums.length+1;i++) {
			t[i][j] = true;
		}
		for(int i =1;i<nums.length+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(j>=nums[i-1]) {
					boolean ans1 = t[i-1][j-nums[i-1]];
					boolean ans2 = t[i-1][j];
					t[i][j] = (ans1==true)?ans1:ans2;
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[nums.length][sum];
	}

}

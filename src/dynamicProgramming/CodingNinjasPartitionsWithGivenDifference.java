
package dynamicProgramming;
public class CodingNinjasPartitionsWithGivenDifference {

	public static void main(String[] args) {
		int arr[] = {1,0,8,5,1,4};
		System.out.println(countMemo(arr, arr.length, 17));
	}
	 public static int countPartitions(int n, int d, int[] arr){
		int sum=0;
		for(int i: arr){sum+= i;}
		int s2 = (sum+d)/2;
		//return countRec(arr,arr.length,s2);
		return countDp(arr, s2);
	}
	public static int countRec(int arr[], int N, int K){
		if(K<0){return 0;}
		if(N==0){
			if(K == 0){return 1;}
			return 0;
		}
		int ans1 = countRec(arr,N-1,K);
		int ans2 = countRec(arr,N-1,K-arr[N-1]);
		return ans1+ans2;
	}
	public static int countMemo(int arr[], int N, int d){
		int sum=0;
		for(int i:arr){sum+=i;}
		int s1 = (sum+d)/2;
		int dp[][] =new int[arr.length+1][s1+1];
		for(int i= 0;i<dp.length;i++){
			for(int j = 0;j<dp[0].length;j++){
				dp[i][j] = -1;
			}
		}
		int ans = helper(arr,N,s1,dp);
		return ans;
	}
	private static int helper(int arr[], int N, int sum, int dp[][]){
		if(sum<0){return 0;}
		if(N==0){
			if(sum == 0){
				return 1;
			}
			return 0;
		}
		if(dp[N][sum]!=-1){return dp[N][sum];}
		int ans1 = helper(arr, N-1, sum, dp);
		int ans2 = helper(arr, N-1, sum-arr[N-1], dp);
		return dp[N][sum] = ans1+ans2;
	}
	public static int countDp(int arr[] , int K){
		int t[][] = new int[arr.length+1][K+1];
		for(int i = 0,j=0;i<arr.length+1;i++){
			t[i][j] = 1;
		}
		for(int i =1;i<arr.length+1;i++){
			//j = 0 because we have zeros in the array too...
			for(int j = 0;j<K+1;j++){
				t[i][j] = t[i-1][j];
				if(arr[i-1]<=j){
					t[i][j]+= t[i-1][j-arr[i-1]];
				}
			}
		}
		return t[arr.length][K];
	}




}

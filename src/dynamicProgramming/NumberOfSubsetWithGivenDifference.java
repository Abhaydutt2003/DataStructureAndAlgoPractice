package dynamicProgramming;

public class NumberOfSubsetWithGivenDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,0,8,5,1,4};
		int differ = 17;
		System.out.print(countPartitions(arr.length,differ,arr));

	}
	public static int countPartitions(int n, int d, int[] arr) {
		int sum = 0;
		for(int i : arr) {sum+=i;}
		int s2 = (sum-d)/2;
		int ans =  countSubset(arr,s2);
		return ans;
	}
	private static int countSubset(int [] arr, int sum) {
		int[][] t = new int[arr.length+1][sum+1];
		for(int i = 0;i<arr.length+1;i++) {
			t[i][0] = 1;
		}
		for(int i = 1;i<arr.length+1;i++) {
			for(int j = 1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j] = t[i-1][j]+t[i-1][j-arr[i-1]];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[arr.length][sum];
	}

}

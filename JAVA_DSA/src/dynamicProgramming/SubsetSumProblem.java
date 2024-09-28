package dynamicProgramming;

public class SubsetSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		System.out.print(isSubsetDp(arr.length,arr,sum));
	}
	public static boolean isSubsetSumRec(int N,int arr[],int sum) {
		if(N==0) {
			return false;
		}
		if(sum <= 0) {
			if(sum == 0) {return true;}
			return false;
		}
		boolean ans1 = isSubsetSumRec(N-1,arr,sum);
		boolean ans2 = isSubsetSumRec(N-1,arr,sum-arr[N-1]);
		return (ans1==true)?ans1:ans2;
	}
	static boolean[][] memo = new boolean[102][100002];
	public static boolean isSubsetSum(int N,int arr[],int sum){
		for(int i = 0;i<N+2;i++) {
			for(int j = 0;j<sum+2;j++) {
				memo[i][j] = false;
			}
		}
		return helper(N,arr,sum);
	}
	public static boolean helper(int N,int arr[],int sum) {
		if(N==0) {
			return false;
		}
		if(sum <= 0) {
			if(sum==0) {return true;}
			return false;
		}
		if(memo[N][sum]!=false) {return memo[N][sum];}
		boolean ans1=false,ans2=false;
		ans1 = helper(N-1,arr,sum);
		ans2 = helper(N-1,arr,sum-arr[N-1]);
		return (ans1 == true)?ans1:ans2;
	}
	public static boolean isSubsetDp(int N,int arr[],int sum) {
		boolean [][] t = new boolean[N+1][sum+1];
		for(int i=0,j=0;j<=sum;j++) {
			t[i][j] = false;
		}
		for(int i = 0,j = 0;i<=N;i++) {
			t[i][j] = true;
		}
		for(int i = 1;i<N+1;i++) {
			for(int j = 1;j<sum+1;j++) {
				if(j>=arr[i-1]) {
					boolean ans1 = t[i-1][j-arr[i-1]];
					boolean ans2 = t[i-1][j];
					t[i][j] = (ans1==true)?ans1:ans2;
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[N][sum];
	}
	

}

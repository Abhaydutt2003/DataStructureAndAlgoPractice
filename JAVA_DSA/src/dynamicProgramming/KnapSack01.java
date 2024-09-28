package dynamicProgramming;
import java.util.Scanner;
public class KnapSack01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int values[] = new int[85];
		for(int i =0;i<values.length;i++) {
			values[i] = s.nextInt();
		}
		int weight [] = new int[85];
		for(int i =0;i<weight.length;i++) {
			weight[i] = s.nextInt();
		}
		int W = 50;
		System.out.print(knapSackdp(W,weight,values,values.length));
		s.close();
	}
	public static int knapSackRecursive(int wt[], int val[], int W, int i) {
		if(i == 0) {return 0;}
		if(wt[i-1]<W) {
			int ans1 = knapSackRecursive(wt,val,W-wt[i-1],i-1)+val[i-1];
			int ans2 = knapSackRecursive(wt,val,W,i-1);
			return Math.max(ans1, ans2);
		}else{
			return knapSackRecursive(wt,val,W,i-1);
		}
	}
	public static int knapSackMemo(int W, int wt[], int val[], int n) {
		for(int i =0;i<n+2;i++) {
			for(int j = 0;j<W+2;j++) {
				memo[i][j] = -1;
			}
		}
		return helper(W,wt,val,n);
	}
	static int[][] memo = new int[1002][1002];
	public static int helper(int W, int wt[], int val[], int n) {
		if(n==0) {return 0;}
		if(memo[n][W]!=-1) {return memo[n][W];}
		if(wt[n-1]<=W) {
			int ans1 = helper(W,wt,val,n-1);
			int ans2 =helper(W-wt[n-1],wt,val,n-1)+val[n-1];
			int ans = Math.max(ans1,ans2);
			memo[n][W] = ans;
			return ans;
		}else {
			int ans1 = helper(W,wt,val,n-1);
			memo[n][W] = ans1;
			return ans1;
		}
	}
	public static int knapSackdp(int W, int wt[], int val[], int n) {
		int t[][] = new int[n+1][W+1];
		for(int i = 0,j=0;i<n;i++)
			t[i][j] = 0;
		for(int i=0,j=0;j<W;j++)
			t[i][j]=0;
		for(int i =1;i<n+1;i++) {
			for(int j=1;j<W+1;j++) {
				if(wt[i-1]<=j) {
					int ans1 = t[i-1][j];
					int ans2 = t[i-1][j-wt[i-1]]+val[i-1];
					t[i][j]=Math.max(ans1, ans2);
				}else {
					t[i][j]=t[i-1][j];
				}
			}
		}
		return t[n][W];
	}

}

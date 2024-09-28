package dynamicProgramming;

public class MinimumSubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5, 6, 6 ,5, 7, 4, 7, 6};
		System.out.print(minimumDifference(arr));

	}
	//if i already know the values that my half subset is going to achieve , i already 
	//know the value that the other subset is going to achieve (range - s1)...
	// so all need to know is (range -s1)-s1;
	public static int minimumDifference(int[] nums) {
		int range = 0;
		for(int i:nums) {range+=i;}
		boolean[] t = helper(nums,range);
		int ans = Integer.MAX_VALUE;
		for(int i = 0;i<=(t.length/2);i++) {
			if(t[i]) {
				if(range-(2*i)<0) {break;}
				ans = Math.min(ans,(range-i)-i);
			}
		}
		return ans;
	}
	private static boolean[] helper(int arr[], int sum) {
		boolean [][] t = new boolean[arr.length+1][sum+1];
		for(int i=0;i<arr.length+1;i++) {
			t[i][0] = true;
		}
		for(int i = 1;i<arr.length+1;i++) {
			for(int j = 1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j] = (t[i-1][j]==true)?t[i-1][j]:t[i-1][j-arr[i-1]];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[arr.length];
	}

}

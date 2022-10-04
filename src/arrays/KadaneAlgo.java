package arrays;

public class KadaneAlgo {
	public static long maxSubarraySum(int arr[], int n) {
		int maxNow = 0;
		int totalMax = Integer.MIN_VALUE;
		for(int i = 0;i<arr.length;i++) {
			maxNow+=arr[i];
			totalMax = Math.max(totalMax,maxNow);
			if(maxNow<0) {
				maxNow = 0;
			}
		}
		return totalMax;
	}

	public static void main(String[] args) {
		int arr[] = {1,2,3,-2,5};
		System.out.println(maxSubarraySum(arr,arr.length));

	}

}

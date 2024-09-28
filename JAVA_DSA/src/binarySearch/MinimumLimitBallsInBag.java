package binarySearch;

public class MinimumLimitBallsInBag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1};
		System.out.print(minimumSize(arr,1));

	}
	public static int minimumSize(int[] nums, int maxOperations) {
		int max =0;
		for(int i:nums) {
			max = (i>max)?i:max;
		}
		int res = 0, start = 1,end =max,mid = 0;
		while(start<=end) {
			mid = start+(end-start)/2;
			if(isValid2(nums,mid,maxOperations)) {
				res = mid;
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return res;
	}
	@SuppressWarnings("unused")
	private static boolean isValid(int arr[], int mid, int max) {
		int operations = 0;
		for(int i =0;i<arr.length;i++) {
			if(arr[i]%mid == 0) {
				operations+=(arr[i]/mid)-1;
			}else {
				operations+=(arr[i]/mid);
			}
		}
		return operations<=max;
	}
	private static boolean isValid2(int arr[], int mid, int max){
		int operations = 0;
		for(int i:arr) {
			operations+=Math.ceil(i/(mid*1.0))-1;
		}
		return operations<=max;
	}

}

package binarySearch;

public class MinimumInRotatedSortedArray {

	public static void main(String[] args) {
		int arr[] = {2,5,6,8,11,12,15,18};
		System.out.print(findMin(arr));

	}
	public static int findMin(int [] nums) {
		int pivot = getPivot(nums);
		return nums[pivot];
	}
	private static int getPivot(int []arr) {
		int n = arr.length;
		int mid = 0,start = 0,end = n-1;
		while(start<=end) {
			mid = start + (end-start)/2;
			int prev = (mid+n-1)%n,next = (mid+1)%n;
			if(arr[mid]<arr[prev] && arr[mid]<arr[next]) {
				return mid;
			}
			if(arr[mid]<=arr[end]) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return start;
	}

}

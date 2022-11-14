package binarySearch;

public class FindPeakElement {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,7};
		System.out.print(findPeakElement(arr));

	}
	public static int findPeakElement(int [] nums) {
		int low = 0,high = nums.length-1;
		while(low<high) {
			int mid = low + (high-low)/2;
		    if(nums[mid]<nums[mid+1]) {
				low = mid+1;
			}else {
				high = mid;
			}
		}
		return low;
	}

}

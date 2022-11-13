package binarySearch;

public class FirstAndLastPosition {

	public static void main(String[] args) {
		int arr1[] = {1,1,1,1,2,2,2,2,3,4,4,4};
		int arr2[] = searchRange(arr1,2);
		System.out.print(arr2[0]+" "+arr2[1]);

	}
	//implement binarySearch to find first and then last index...
	public static int[] searchRange(int[] nums,int target) { 
		int indexStart = -1,indexEnd = -1;
	    indexStart = bs1(nums,target);
	    indexEnd = bs2(nums,target);
		int ans[] = {indexStart,indexEnd};
		return ans;
	}
	private static int bs1(int nums[], int target) {
		int low = 0, high = nums.length-1;
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(nums[mid] == target) {
				if(mid-1 == -1 || nums[mid-1]!=target) {
					return mid;
				}
				high = mid-1; 
			}else if (nums[mid]<target) {
				low = mid+1;
			}else {
				high = mid-1; 
			}
		}
		return -1;
	}
	private static int bs2(int nums[], int target) {
		int low = 0, high = nums.length-1;
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(nums[mid] == target) {
				if(mid+1 == nums.length || nums[mid+1]!=target) {
					return mid;
				}
				low = mid+1;
			}else if (nums[mid]<target) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return -1;
	}
	//when we need to consider the element after mid, low == mid, or accordingly high
	//but this works only when it is assured that element is present in the array.

}

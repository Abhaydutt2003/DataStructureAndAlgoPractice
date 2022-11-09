package binarySearch;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = {-1,0,3,5,9,12};
		int target =12;
		System.out.println(binarySearch(arr,target));

	}
	public static int binarySearch(int nums[],int target ) {
		int high = nums.length-1,low = 0;
		while(high>=low) {
			int mid = (high+low)/2;
			if(nums[mid]>target) {
				high = mid-1;
			}else if(nums[mid]<target) {
				low = mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}

}

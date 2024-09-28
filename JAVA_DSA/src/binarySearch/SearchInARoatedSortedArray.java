package binarySearch;

public class SearchInARoatedSortedArray {

	public static void main(String[] args) {
		int arr[] = {6,7,0,1,2,3,4};
		System.out.println(searchPivot1(arr));
		System.out.println(search(arr,3));

	}
	
	public static int search(int[] nums,int target) {
		int Index = searchPivot1(nums);
		int ans1 = binarySearch(nums,target,0,Index-1);
		int ans2 = binarySearch(nums,target,Index,nums.length-1);
		int ans = ans1!=-1?ans1:ans2;
		return ans;
	}
	
	private static int searchPivot1(int [] arr) {
		int low = 0,high = arr.length-1;
		while(low<high) {
			int mid = low + (high-low)/2;
			if(mid-1 == -1) {
				low = mid+1;
			}else if(arr[mid]<arr[mid-1]) {
				return mid;
			}else if(arr[mid]>arr[high]) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return low;
	}
	
	
	private static int binarySearch(int[] arr,int target,int si, int ei) {
		int low = si,high = ei;
		while(high>=low) {
			int mid = low + (high-low)/2;
			if(arr[mid]>target) {
				high = mid-1;;
			}else if(arr[mid]<target) {
				low = mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}

}

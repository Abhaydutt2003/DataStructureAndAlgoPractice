package binarySearch;

public class PositionInInfinite {

	public static void main(String[] args) {
		int arr[] = {1,3,4,5,6,7,8,9,11,13,14,16,18,19,22,24,26,27,33,45,49,89,99,100};
		System.out.print(find(arr,22));

	}
	public static int find(int arr[], int target) {
		int nums[] = findIndexes(arr, target);
		int index = bs(nums[0], nums[1],target,arr);
		return index;
	}
	private static int[] findIndexes(int arr[], int target) {
		int start = 0,end = 1;
		while(true) {
			if(arr[end]<target) {
				start = end;
				end = end*2;
				if(end>arr.length) {
					while(end>arr.length) {
						end = end-1;
					}
				}
			}else {
				break;
			}
		}
		int ans[] = {start,end};
		return ans;
	}
	private static int bs(int start, int end, int target, int arr[]) {
		int low = start,high = end,mid = 0;
		while(low<=high) {
			mid = low+(high-low)/2;
			if(arr[mid] == target) {
				return mid;
			}
			if(arr[mid]<target) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return -1;
	}

}

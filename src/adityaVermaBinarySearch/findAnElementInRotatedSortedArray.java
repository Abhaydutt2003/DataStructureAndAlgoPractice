package adityaVermaBinarySearch;

public class findAnElementInRotatedSortedArray {

	public static void main(String[] args) {
		int arr[] = {4,5,6,7,0,1,2};
		System.out.print(search(arr,0));

	}
	public static int search(int [] nums , int target) {
		int pivot = getPivot(nums);
		int ans = bs(nums,0,pivot-1,target);
		int ans2 = bs(nums,pivot,nums.length-1,target);
		int a = (ans!=-1)?ans:ans2;
		return a;
	}
	private static int getPivot(int [] nums) {
		int n = nums.length;
		int start = 0,end = nums.length-1, mid = 0;
		while(start<=end) {
			mid = start + (end - start)/2;
			int prev = (mid+n-1)%n;
			int next = (mid+1)%n;
			if(nums[mid]<nums[prev] && nums[mid]<nums[next]) {
				return mid;
			}
			if(nums[mid]<=nums[end]) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return start;
	}
	private static int bs(int arr[], int start , int end, int target) {
		int mid = 0,low  =start,high = end;
		while(low<=high) {
			mid = low + (high-low)/2;
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid]<target) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return -1;
	}

}

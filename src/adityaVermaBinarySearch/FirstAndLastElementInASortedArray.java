package adityaVermaBinarySearch;

public class FirstAndLastElementInASortedArray {
	public static void main(String args[]) {
		int arr[] = {2,4,10,10,10,18,20};
		int ans[] = searchRange(arr,10);
		System.out.print(ans[0]+" "+ ans[1]);
	}
	
	public static int[] searchRange(int []nums,int target) {
		int first = bs1(nums,target);
		int last = bs2(nums,target);
		int ans[] = {first,last};
		return ans;
	}
	private static int bs1(int arr[], int target) {
		int mid = 0,start = 0,end = arr.length-1,res = -1;
		while(start<=end) {
			mid = start + (end-start)/2;
			if(arr[mid] == target) {
				res = mid;
				end = mid-1;
			}else if(arr[mid]<target) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return res;
	}
	private static int bs2(int arr[], int target) {
		int mid = 0,start = 0,end = arr.length-1,res = -1;
		while(start<=end) {
			mid = start + (end-start)/2;
			if(arr[mid] == target) {
				res = mid;
				start = mid+1;
			}else if(arr[mid]<target) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return res;
	}
	

}

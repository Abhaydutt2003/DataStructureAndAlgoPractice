package adityaVermaBinarySearch;

public class CountOfAnElementInASortedArray {

	public static void main(String[] args) {
		int arr[] = {1,2,2,3,3,3,3,5,6};
		System.out.print(count(arr,3));

	}
	public static int count (int arr[], int number) {
		int start = bs1(arr,number);
		int end = bs2(arr,number);
		int count = (end-start)+1;
		return count;
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

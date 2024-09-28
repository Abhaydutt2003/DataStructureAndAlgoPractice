package binarySearch;

public class SearchInAlmostSortedArray {

	public static void main(String[] args) {
		int arr[] = {0, 3, 40, 20, 50, 80, 70};
		//int arr[] = {1};
		System.out.print(search(arr,20));

	}
	public static int search(int arr[], int target) {
		int n = arr.length, start = 0,end = arr.length-1,mid=0;
		while(start<=end) {
			mid = start + (end-start)/2;
			int next = (mid+1)%n,prev = (mid+n-1)%n;
			if(arr[mid] == target) {
				return mid;
			}else if(arr[next] == target) {
				return next;
			}else if(arr[prev] == target) {
				return prev;
			}
			
			if(arr[mid]>target) {
				end = mid-2;
			}else {
				start = mid+2;
			}
		}
		return -1;
	}

}

package binarySearch;

public class SearchInRevereseSortedArray {

	public static void main(String[] args) {
		int arr[] = {8,7,5,3,1};
		System.out.print(bs(arr,7));

	}
	private static int bs(int [] arr, int n) {
		int mid = 0,start = 0,end = arr.length-1;
		while(start<=end) {
			mid = start + (end-start)/2;
			if(arr[mid] == n) {
				return mid;
			}
			else if(arr[mid]<n) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return -1;
	}

}

package adityaVermaBinarySearch;

public class BitonicPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,15,25,45,42,21,17,12,11};
		System.out.print(findMaximum(arr,arr.length));

	}
	public static int findMaximum(int arr[], int n) {
		int mid = 0,low = 0,high = n-1;
		while(low<=high) {
			mid = low+(high-low)/2;
			if(mid<n-1 && arr[mid]<arr[mid+1]) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return arr[low];
	}

}

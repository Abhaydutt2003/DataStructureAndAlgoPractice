package adityaVermaBinarySearch;

public class FindInBitonicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-3, 9, 18, 20, 17, 5, 1};
		System.out.print(find(arr,17));
	}
	public static int find(int arr[], int x) {
		int index = findPoint(arr,arr.length);
		int ans1 = bs1(arr,0,index,x);
		int ans2 = bs2(arr,index+1,arr.length-1,x);
		int ans = (ans1!=-1)?ans1:ans2;
		return ans;
	}
	public static int findPoint(int arr[], int n) {
		int mid = 0,low = 0,high = n-1;
		while(low<=high) {
			mid = low+(high-low)/2;
			if(mid<n-1 && arr[mid]<arr[mid+1]) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return low;
	}
	public static int bs1(int arr[], int start, int end, int target) {
		int low = start,high = end,mid = 0;
		while(low<=high) {
			mid = low + (high-low)/2;
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid]>target) {
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
		return -1;
	}
	public static int bs2(int arr[], int start, int end, int target) {
		int low = start,high = end,mid = 0;
		while(low<=high) {
			mid = low + (high-low)/2;
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid]>target) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return -1;
	}
	

}

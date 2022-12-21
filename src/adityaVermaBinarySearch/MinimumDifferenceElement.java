package adityaVermaBinarySearch;

public class MinimumDifferenceElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,8,10,15};
		System.out.print(getMinElement(arr,14));

	}
	public static int getMinElement(int arr[], int x) {
		int index = bs(arr,x);int n = arr.length;
		int next = (index+1)%n;
		int prev = (index+n-1)%n;
		int candidate1 = Math.abs(arr[index]-x);
		int candidate2 = Math.abs(arr[prev]-x);
		int candidate3 = Math.abs(arr[next]-x);
		return Math.min(candidate2,Math.min(candidate1,candidate3));
	}
	private static int bs(int arr[],int target) {
		int start = 0,end = arr.length-1,mid = 0,res = 0;
		while(start<=end) {
			mid =start+(end-start)/2;
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid]<target) {
				res = mid;
				start = mid+1;
			}else {
				end =mid-1;
			}
		}
		return res;
	}

}

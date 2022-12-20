package adityaVermaBinarySearch;

public class CeilOfAnElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 8, 10, 10, 12, 19};
		System.out.print(find(arr,18));

	}
	public static int find(int arr[], int x) {
		int start = 0,end = arr.length-1,mid = 0,res = -1;
		while(start<=end) {
			mid = start + (end-start)/2;
			if(arr[mid] == x) {
				return arr[mid];
			}else if(arr[mid]>x) {
				res =arr[mid];
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return res;
		
	}

}

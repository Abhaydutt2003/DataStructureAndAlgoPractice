package binarySearch;

public class MinimizedMaximumOfProducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {15,10,10};
		System.out.print(minimizedMaximum(7,arr));

	}
	public static int minimizedMaximum(int n , int [] quantities) {
		int max = 0;
		for(int i:quantities) {
			if(i>max) {max=i;}
		}
		int res = 0,start = 0,end = max,mid=0;
		while(start<=end) {
			mid = start+(end-start)/2;
			if(isValid(n,quantities,mid)) {
				res = mid;
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return res;
	}
	private static boolean isValid(int n, int arr[], int mid) {
		int shop = 0;
		for(int i=0;i<arr.length;i++) {
			shop += Math.ceil(arr[i]/(mid*1.0));
			if(shop>n) {return false;}
		}
		return true;
	}

}

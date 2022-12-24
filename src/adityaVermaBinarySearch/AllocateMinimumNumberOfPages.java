package adityaVermaBinarySearch;

public class AllocateMinimumNumberOfPages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {15,10,19,10,5,18,7};
		System.out.print(findPages(arr,arr.length,5));

	}
	public static int findPages(int [] A, int N,int M) {
		if(N<M) {return -1;}
		int res = -1, mid = 0, start=0,end=0;
		for(int i:A) {
			end +=i;
			if(i>start) {start = i;}
		}
		while(start<=end) {
			mid = start+(end-start)/2;
			if(isValid(A,N,M,mid)) {
				res = mid;
				end = mid-1;
			}else {
				start =mid+1;
			}
		}
		return res;
	}
	private static boolean isValid(int arr[], int n , int m , int max) {
		int student = 1;
		int sum = 0;
		for(int i = 0;i<n;i++) {
			sum +=arr[i];
			if(sum>max) {
				student++;
				sum =arr[i];
			}
			if(student>m) {
				return false;
			}
		}
		return true;
	}

}

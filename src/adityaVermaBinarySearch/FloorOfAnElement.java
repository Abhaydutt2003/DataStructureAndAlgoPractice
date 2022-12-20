package adityaVermaBinarySearch;
import java.util.Scanner;
public class FloorOfAnElement {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		int n  = s.nextInt();
		int x = s.nextInt();
		long arr[] = new long[n];
		for(int i = 0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		System.out.print(findFloor(arr,n,x));
	}
	public static int findFloor(long arr[],int n, int x){
		int res = -1;
		int mid =0,start = 0,end = n-1;
		while(start<=end) {
			mid = start + (end-start)/2;
			if(arr[mid] == x) {
				return mid;
			}else if (arr[mid]>x) {
				end = mid-1;
			}else {
				res = mid;
				start = mid+1;
			}
		}
		return res;
	}

}

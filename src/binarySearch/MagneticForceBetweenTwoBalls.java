package binarySearch;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,7};
		System.out.print(maxDistance(arr,3));

	}
	public static int maxDistance(int[] position, int m) {
		Arrays.sort(position);
		int end = position[position.length-1]-position[0];
		int start = 0,mid = 0,res = 0;
		while(start<=end) {
			mid = start+(end-start)/2;
			if(isValid(position,m,mid)) {
				res = mid;
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return res;
	}
	public static boolean isValid(int[] arr, int limit, int mid) {
		int balls=1,prev =0;
		for(int i = 1;i<arr.length;i++) {
			if(arr[i]-arr[prev]>= mid) {
				balls++;
				//if(balls == limit) {return true;}
				prev = i;
			}
		}
		return balls == limit;
		
	}

}

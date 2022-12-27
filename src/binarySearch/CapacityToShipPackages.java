package binarySearch;

public class CapacityToShipPackages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,2,2,4,1,4};
		System.out.print(shipWithinDays(arr,3));

	}
	public static int shipWithinDays(int[] weights, int days) {
		int max = Integer.MIN_VALUE,sum=0;
		for(int i:weights) {
			sum+=i;
			if(i>max) {max=i;}
		}
		int res = 0, start = max,end = sum,mid=0;
		while(start<=end) {
			mid = start+(end-start)/2;
			if(isValid(weights,days,mid)) {
				res = mid;
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return res;
	}
	private static boolean isValid(int weights[], int limit, int mid) {
		int days = 1,sumW = 0; 
		for(int i =0;i<weights.length;i++) {
			sumW +=weights[i];
			if(sumW>mid) {
				days++;
				sumW = weights[i];
			}
			if(days>limit) {
				return false;
			}
		}
		return true;
	}

}

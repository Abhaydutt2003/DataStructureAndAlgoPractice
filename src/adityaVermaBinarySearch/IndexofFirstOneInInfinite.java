package adityaVermaBinarySearch;

public class IndexofFirstOneInInfinite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.print(find(arr));

	}
	public static int find(int arr[]) {
		int nums[] = findStartEnd(arr,1);
		return bs(arr,nums[0],nums[1]);
	}
	private static int[] findStartEnd(int arr[], int target) {
		int start = 0,end = 2;
		while(true) {
			if(arr[end]==target) {
				break;
			}else {
				start = end;
				end = end*2;
				if(end>arr.length) {
					while(end>arr.length) {
						end = end-1;
					}
				}
			}
		}
		int ans[] = {start,end};
		return ans;
	}
	private static int bs(int arr[], int start, int end) {
		int low = start,high = end,mid=0,res = -1;
		while(low<=high) {
			mid = low +(high-low)/2;
			if(arr[mid]==1) {
				res = mid;
				high = mid-1;
			}else {
				low= mid+1;
			}
		}
		return res;
	}

}

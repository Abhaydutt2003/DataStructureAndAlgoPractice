package adityaVermaBinarySearch;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,1,3,5,6,4};
		System.out.print(findPeakElement(arr));

	}
	public static int findPeakElement(int [] nums) {
		int start = 0,end = nums.length-1,mid = 0;
		while(start<=end) {
			mid = start + (end-start)/2;
		    if((mid<nums.length-1) && (nums[mid]<nums[mid+1])) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return start;
	}

}

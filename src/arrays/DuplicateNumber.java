package arrays;

public class DuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {8,7,1,10,17,15,18,11,16,9,19,12,5,14,3,4,2,13,18,18};
		System.out.println(find3(arr));

	}
	//this approach does not work for many test cases...
	public static int findDuplicate(int[]nums) {
		int sum = 0;
		for(int i =0;i<nums.length;i++)
			sum+=nums[i];
		
		int n = nums.length-1;
		int t = (n * (n+1))/2;
		return sum-t;
	}
	
	//marking visited elements as negative....
	public static int find(int nums[]) {
		for(int i : nums) {
			int index = Math.abs(i);
			if(nums[index] < 0) {
				return index;
			}
			nums[index] = -nums[index];
		}
		return nums.length;
	}
	
	//index sort approach...
	public static int find2(int nums[]) {
		for(int i = 0;i<nums.length;) {
			int temp = nums[i];
			if(temp == i+1) {
				i++;
			}else if(temp == nums[temp-1]) {
				return temp;
			}else {
				nums[i] = nums[temp-1];
				nums[temp-1] = temp;
			}
		}
		return 0;
	}
	//binary search approach...
	public static int find3(int [] nums) {
		int low = 1;
		int high = nums.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			int count = 0;
			for(int i =0;i<nums.length;i++) {
				if(nums[i] <= mid) {
					count++;
				}
			}
			if(count<=mid) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		return low;
	}
	

}

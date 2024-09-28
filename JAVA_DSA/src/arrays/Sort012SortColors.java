package arrays;

public class Sort012SortColors {
	public static void sortColors(int [] nums) {
		int nextZero = 0;
		int nextTwo = nums.length-1;
		for(int i = 0;i<nums.length && i<=nextTwo;) {
			if(nums[i] == 1) {
				i++;
			}else if(nums[i] == 0) {
				int temp = nums[nextZero];
				nums[nextZero] = nums[i];
				nums[i] = temp;
				nextZero++;
				i++;
			}else if(nums[i] == 2) {
				int temp = nums[nextTwo];
				nums[nextTwo] = nums[i];
				nums[i] = temp;
				nextTwo--;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {2,0,2,1,1,0};
		sortColors(arr);
		for(int i = 0;i<arr.length;i++)
			System.out.print(arr[i] +" ");
		
	}

}

package hashTable;

public class MaxConsecOnes {

	public static void main(String[] args) {
		int arr[] = {1,1,0,1,1,1};
		System.out.print(findMaxConsecutiveOnes(arr));

	}
	public static int findMaxConsecutiveOnes(int[] nums) {
		int maxLen = Integer.MIN_VALUE,current = 0;
		for(int i = 0;i<nums.length;i++) {
			if(nums[i] == 0) {
				current = 0;
			}else {
				current++;
				if(maxLen<current) {maxLen = current;}
			}
		}
		return maxLen;
	}

}

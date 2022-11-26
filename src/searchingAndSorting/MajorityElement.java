package searchingAndSorting;

public class MajorityElement {

	public static void main(String[] args) {
		int arr[] = {2,2,1,1,1,2,2};
		System.out.println(boyreMoore(arr));

	}
	//hashing time O(n), space O(n)
	//sorting super bad time complexity, space would be better..
	//below code implements divide and conquer..
	public static int majorityElement(int[]nums) {
		return countRec(nums,0,nums.length-1);
	}
	private static int countRec(int nums[],int si, int ei) {
		if(si == ei) {
			return nums[si];
		}
		int mid = si + (ei-si)/2;
		int left = countRec(nums,si,mid);
		int right = countRec(nums,mid+1,ei);
		if(left == right) {return left;}
		int leftCount = traverse(nums,si,ei,left),rightCount =traverse(nums,si,ei,right);
		int ans = leftCount>rightCount?left:right;
		return ans;
	}
	private static int traverse(int nums[], int si, int ei, int num) {
		int count =0;
		for(int i = 0;i<nums.length;i++) {
			if(nums[i] == num) {count++;}
		}
		return count;
	}
	//below code implements majority vote algorithm , see explanation in leetcode discuss...
	public static int boyreMoore(int nums[]) {
		int candidate = 0,count = 0;
		for(int i:nums) {
			candidate =(count == 0)?i:candidate;
			count += (i == candidate)?1:-1;
		}
		return candidate;
	}

}

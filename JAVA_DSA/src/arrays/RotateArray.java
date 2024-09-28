package arrays;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-1,-100,3,99};
		int k = 2;
		rotate2(arr,k);
		for(int i:arr)
			System.out.print(i+" ");

	}
	private static void reverse(int arr[], int i,int j) {
		if(i >= j) {
			return;
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] =temp;
		reverse(arr,i+1,j-1);
	}
	private static void reverseIterative(int arr[], int i, int j) {
		while(i<j) {
			int temp =arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	//will only work for test cases where k< length of array...
	public static void rotate(int nums[],int k) {
		if(k>=nums.length) {
			reverse(nums,0,nums.length-1);
			return;
		}
		int temp []= new int[nums.length-k];
		for(int i = 0;i<nums.length-k;i++) {
			temp[i] = nums[i];
		}
		int j =0;
		for(int i = nums.length-k;i<nums.length;i++) {
			nums[j++] = nums[i];
		}
		for(int i:temp)
			nums[j++] = i;
		
	}
	//we need to handle the cases where k> array length, it could be less too.....
	public static void rotate2(int nums[], int k) { 
		k = k % nums.length;
		if(k<0) {
			k = k+nums.length;
		}
		reverseIterative(nums,0,nums.length-1);
		reverseIterative(nums,0,nums.length-(nums.length-k)-1);
		reverseIterative(nums,k,nums.length-1);
		
	}

}

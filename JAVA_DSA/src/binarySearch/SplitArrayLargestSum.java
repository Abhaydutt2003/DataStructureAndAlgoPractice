package binarySearch;

public class SplitArrayLargestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 5 };
		System.out.print(splitArray(arr, 2));

	}

	public static int splitArray(int[] nums, int k) {
		int sum = 0, largest = Integer.MIN_VALUE;
		for (int i : nums) {
			sum += i;
			if (i > largest) {
				largest = i;
			}
		}
		int res = 0, start = largest, end = sum, mid = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (isValid(nums, k, mid)) {
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return res;
	}

	public static boolean isValid(int arr[], int k, int maxSum) {
		int sum = 0, noArr = 1;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > maxSum) {
				noArr++;
				sum = arr[i];
			}
			if (noArr > k) {
				return false;
			}
		}
		return true;
	}

}

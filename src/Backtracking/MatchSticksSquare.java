package backTracking;

import java.util.*;

public class MatchSticksSquare {

	public static void main(String[] args) {
		int arr[] = { 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3 };
		System.out.print(util2(arr));
	}

	// bitmask and dp solution
	public static boolean util2(int arr[]) {
		int sum = 0;
		Integer arr1[] = new Integer[arr.length];
		int K = 0;
		for (int i : arr) {
			sum += i;
			arr1[K++] = i;
		}
		if (sum % 4 != 0) {
			return false;
		}
		Arrays.sort(arr1, Collections.reverseOrder());
		int target = sum / 4;
		Boolean dp[] = new Boolean[1 << arr.length];
		return recUtil(arr1, dp, 0, 0, 4, target);
	}

	public static boolean recUtil(Integer arr[], Boolean dp[], int currSum, int mask, int k, int target) {
		if (dp[mask] != null) {
			return dp[mask];
		} else if (k == 0) {
			return true;
		}
		dp[mask] = false;
		for (int i = 0; i < arr.length; i++) {
			if ((mask & (1 << i)) == 0) {
				int curr = currSum % target + arr[i];
				if (curr < target) {
					dp[mask] = recUtil(arr, dp, currSum + arr[i], (mask | (1 << i)), k, target);
				} else if (curr == target) {
					dp[mask] = recUtil(arr, dp, currSum + arr[i], (mask | (1 << i)), k - 1, target);
				}
				if (dp[mask]) {
					return dp[mask];
				}
			}
		}
		return dp[mask];
	}

	// backtracking solution
	public static boolean util1(int[] matchsticks) {
		int sum = 0;
		Integer arr[] = new Integer[matchsticks.length];
		int k = 0;
		for (int i : matchsticks) {
			sum += i;
			arr[k++] = i;
		}
		if (sum % 4 != 0) {
			return false;
		}
		int target = sum / 4;
		Arrays.sort(arr, Collections.reverseOrder());
		// return helper(arr,0,0,0,0,0,target);
		int visited[] = new int[4];
		return helper2(arr, visited, 0, target);
	}

	public static boolean helper2(Integer arr[], int visited[], int index, int target) {
		if (index == arr.length) {
			return true;
		}
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] + arr[index] > target || (i > 0 && visited[i - 1] == visited[i])) {
				continue;
			}
			visited[i] += arr[index];
			boolean ans = helper2(arr, visited, index + 1, target);
			visited[i] -= arr[index];
			if (ans) {
				return true;
			}
		}
		return false;
	}

	public static boolean helper(Integer m[], int index, int side1, int side2, int side3, int side4, int target) {
		if (side1 == target && side2 == target && side3 == target && side4 == target) {
			return true;
		} else if (side1 > target || side2 > target || side3 > target || side4 > target) {
			return false;
		}
		boolean ans1 = helper(m, index + 1, side1 + m[index], side2, side3, side4, target);
		if (ans1) {
			return true;
		}
		boolean ans2 = helper(m, index + 1, side1, side2 + m[index], side3, side4, target);
		if (ans2) {
			return true;
		}
		boolean ans3 = helper(m, index + 1, side1, side2, side3 + m[index], side4, target);
		if (ans3) {
			return true;
		}
		boolean ans4 = helper(m, index + 1, side1, side2, side3, side4 + m[index], target);
		if (ans4) {
			return true;
		}
		return false;
	}

}

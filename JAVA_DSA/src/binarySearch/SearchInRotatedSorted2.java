package binarySearch;

class lc81helper {
    int left;
    int right;

    lc81helper(int left, int right) {
        this.left = left;
        this.right = right;
    }
}

public class SearchInRotatedSorted2 {

    public static void main(String args[]) {
        int arr[] = { 1, 0, 1, 1, 1 };
        // System.out.print(util1(arr, 2));
        lc81helper ans = getPivot(arr);
        System.out.print(ans.left + " " + ans.right);
    }

    // applying binary search directly on the array

    public static boolean util2(int arr[], int target) {
        int start = 0, end = arr.length - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > arr[start]) {// the left subArr is sorted
                if (arr[mid] > target && arr[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] < arr[start]) {// the right sub is sorted
                if (arr[mid] < target && arr[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {// duplicate
                start++;
            }
        }
        return false;
    }

    // getting pivot approach fails
    public static boolean util1(int[] arr, int target) {
        lc81helper pivot = getPivot(arr);
        if (arr[pivot.left] == target) {
            return true;
        }
        return bs(arr, 0, pivot.left, target) || bs(arr, pivot.right, arr.length - 1, target);
    }

    public static boolean bs(int arr[], int start, int end, int target) {
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    // get pivot
    public static lc81helper getPivot(int arr[]) {
        int start = 0, end = arr.length - 1, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            int left = mid;
            int right = mid;
            while (left - 1 >= 0 && arr[left] == arr[left - 1]) {
                left--;
            }
            while (right + 1 < arr.length && arr[right] == arr[right + 1]) {
                right++;
            }
            if (left - 1 >= 0 && arr[left - 1] > arr[mid]) {
                return new lc81helper(left, right);
            } else if (arr[mid] >= arr[end]) {
                start = right;
            } else {
                end = left;
            }
        }
        return new lc81helper(0, 0);
    }

}

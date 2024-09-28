package binarySearch;

public class SearchInsertPosition {

    public static void main(String args[]) {
        int arr[] = { 1, 3, 5, 6 };
        int target = 2;
        System.out.print(searchInsert(arr, target));
    }

    public static int searchInsert(int nums[], int target) {
        int start = 0, end = nums.length - 1, res = nums.length, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }

}

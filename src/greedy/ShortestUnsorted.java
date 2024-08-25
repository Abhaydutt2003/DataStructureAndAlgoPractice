package greedy;

public class ShortestUnsorted {

    // Two elements to find to get the length of the subArray
    // the first will be the one that is smaller than the max on the left side
    // (rightmost) (becuase all the left side elements should be smaller)
    // the second will be the one that is greater than the smallest element on the
    // right side (leftmost)
    public static int findUnsortedSubarray(int[] nums) {
        int left = -1, right = -2;
        // get the rightmost element
        for (int i = 0, max = nums[0]; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            right = (nums[i] < max) ? i : right;
        }
        // get the leftmost element
        for (int i = nums.length - 1, min = nums[nums.length - 1]; i >= 0; i--) {
            min = Math.min(nums[i], min);
            left = (nums[i] > min) ? i : left;
        }
        // return the length (check if there was any change)
        return right - left + 1;
    }

    public static void main(String[] args) {
        // int arr[] = { 2, 6, 4, 8, 10, 9, 15 };
        int arr[] = { 1, 2, 3, 4 };
        // int arr[] = { 2,1 };
        System.out.println(findUnsortedSubarray(arr));
    }

}

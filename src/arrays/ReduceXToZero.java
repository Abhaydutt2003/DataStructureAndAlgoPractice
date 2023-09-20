package arrays;

public class ReduceXToZero {

    public static void main(String[] args) {
        int arr[] = { 3, 2, 20, 1, 1, 3 };
        System.out.print(util1(arr, 10));
    }

    // there is a window on the left and right side, forming a window in middle
    // we need left and right to be minimum,
    // how about we maximize the window in the middle???

    public static int util1(int arr[], int x) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int target = sum - x;
        if (target == 0) {
            return arr.length;
        }
        int start = 0;
        int end = 0;
        int ans = -1;
        int currentSum = 0;
        while (end < arr.length) {
            currentSum += arr[end];
            while (currentSum > target && start <= end) {
                currentSum -= arr[start++];
            }
            if (currentSum == target) {
                ans = Math.max(ans, end - start + 1);
            }
            end++;
        }
        if (ans == -1) {
            return -1;
        } else {
            return arr.length - ans;
        }
    }

}

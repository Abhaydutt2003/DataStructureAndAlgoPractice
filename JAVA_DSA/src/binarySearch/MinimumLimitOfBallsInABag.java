package binarySearch;

class MinimumLimitOfBallsInABag {
    public int minimumSize(int[] nums, int maxOperations) {
        // define max and min
        int min = 1;
        int max = 0;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        int ans = max;// assuming that the answer would be the current number of max balls in \a bag.
        // do bs
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (isPossible(mid, nums, maxOperations)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int max, int nums[], int maxOperations) {
        int totalOperations = 0;
        // iterate through all the num
        for (int i : nums) {
            totalOperations += (int) Math.ceil(i / (max * 1.0)) - 1;
        }
        return totalOperations <= maxOperations;
    }

    public static void main(String[] args) {

    }
}
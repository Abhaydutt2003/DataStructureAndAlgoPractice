package binarySearch;

public class MaximumAtAIndex {

    public static void main(String args[]) {
        System.out.print(util3(4, 2, 6));
    }

    public static int util1(int n, int index, int max) {
        int low = 1, high = max, mid = 0, res = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (isValid(n, index, max, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public static boolean isValid(int n, int index, int max, int mid) {
        int arr[] = new int[n];
        arr[index] = mid;
        int sum = mid;
        int toPut;
        if (mid == 1) {
            toPut = 1;
        } else {
            toPut = mid - 1;
        }
        for (int i = index - 1; i >= 0; i--) {
            arr[i] = toPut;
            sum += toPut;
            if (sum > max) {
                return false;
            }
            if (toPut > 1) {
                toPut--;
            }
        }
        toPut = mid - 1;
        for (int i = index + 1; i < arr.length; i++) {
            arr[i] = toPut;
            sum += toPut;
            if (sum > max) {
                return false;
            }
            if (toPut > 1) {
                toPut--;
            }
        }
        return true;
    }

    static int leftSubarrayLen;
    static int rightSubarrayLen;

    public static int util3(int n, int index, int max) {
        leftSubarrayLen = index;
        rightSubarrayLen = n - index - 1;
        int start = 1, end = max, res = 0, mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (check(mid, max)) {
                start = mid + 1;
                res = mid;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    public static boolean check(int mid, int max) {
        long leftSum = getSum(mid - 1, leftSubarrayLen);
        long rightSum = getSum(mid - 1, rightSubarrayLen);
        long total = leftSum + mid + rightSum;
        return total <= max;
    }

    public static long getSum(int mid, int length) {
        long total = 0;
        int decLength = mid;
        if (decLength <= length) {
            long sum = calc(mid);
            long remSum = length - decLength;
            total = sum + remSum;
        } else {
            long extra = decLength - length;
            total = calc(decLength) - calc(extra);
        }
        return total;
    }

    public static long calc(long n) {
        long ans = ((n * (n + 1)) / 2);
        return ans;
    }

}

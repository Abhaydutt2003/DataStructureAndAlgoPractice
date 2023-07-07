package binarySearch;

public class MaxConfusion {

    public static void main(String args[]) {
        String str = "TTFTTFTT";
        System.out.print(util2(str, 1));
    }

    public static int util2(String str, int k) {
        int numt = 0;
        int numf = 0;
        int start = 0;
        int end = 0;
        int ans = 1;
        while (end != str.length()) {
            if (str.charAt(end) == 'T') {
                numt++;
            } else {
                numf++;
            }
            if (validWindow(numf, numt, k)) {
                System.out.println(start + " " + end);
                int currentWindowSize = end - start + 1;
                ans = Math.max(ans, currentWindowSize);
            } else {
                while (start <= end) {
                    if (validWindow(numf, numt, k)) {
                        break;
                    } else {
                        if (str.charAt(start) == 'T') {
                            numt--;
                        } else {
                            numf--;
                        }
                        start++;
                    }
                }
                int currentWindowSize = end - start + 1;
                ans = Math.max(ans, currentWindowSize);
            }
            end++;
        }
        return ans;
    }

    public static boolean validWindow(int numf, int numt, int k) {
        if (numf - k <= 0) {
            return true;
        } else if (numt - k <= 0) {
            return true;
        } else {
            return false;
        }
    }

    // using binary search
    public static int util1(String str, int k) {
        char[] arr = str.toCharArray();
        int start = 1, end = str.length(), mid = 0, res = 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (isValid(arr, k, mid)) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    public static boolean isValid(char[] arr, int k, int mid) {
        int numt = 0, numf = 0;
        int start = 0, end = 0;
        while (end < mid) {
            if (arr[end] == 'T') {
                numt++;
            } else {
                numf++;
            }
            end++;
        }
        while (end < arr.length) {
            if (numf - k <= 0) {
                return true;
            } else if (numt - k <= 0) {
                return true;
            }
            if (arr[start] == 'T') {
                numt--;
            } else {
                numf--;
            }
            start++;
            if (arr[end] == 'T') {
                numt++;
            } else {
                numf++;
            }
            end++;
        }
        if (numf - k <= 0) {
            return true;
        } else if (numt - k <= 0) {
            return true;
        }
        return false;
    }

}

package dynamicProgramming;

public class TurbulentSubarray {

    public static void main(String args[]) {
        int arr[] = { 8, 8, 8, 8 };
        System.out.print(util1(arr));
    }

    public static int util1(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int max = 0;
        int current = 0;
        for (int i = 0; i < arr.length; i++) {
            current++;
            if (isValid(arr, i)) {
                // do nothing
            } else {
                max = Math.max(max, current);
                if (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                    current = 0;
                } else {
                    current = 1;
                }
            }
        }
        max = Math.max(max, current);
        return max;
    }

    public static boolean isValid(int arr[], int i) {
        if (i == 0) {
            if (arr[i] < arr[i + 1] || arr[i] > arr[i + 1]) {
                return true;
            }
        } else if (i == arr.length - 1) {
            if (arr[i] < arr[i - 1] || arr[i] > arr[i - 1]) {
                return true;
            }
        } else {
            if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
                return true;
            } else if (arr[i] < arr[i + 1] && arr[i] < arr[i - 1]) {
                return true;
            }
        }
        return false;
    }

}

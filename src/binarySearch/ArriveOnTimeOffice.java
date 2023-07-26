package binarySearch;

public class ArriveOnTimeOffice {

    public static void main(String args[]) {
        // double a = 1.1;
        // System.out.print((int)(Math.ceil(a)));
        int arr[] = { 1, 1, 100000 };
        System.out.print(util1(arr, 2.01));
        //System.out.print(isValid(arr,100000, 2.01));
    }

    public static int util1(int[] arr, double hour) {
        int start = 0, end = 10000000, mid = 0, res = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (isValid(arr, mid, hour)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static boolean isValid(int[] arr, int mid, double max) {
        double timeTaken = 0.0;
        double temp2 = (double) mid;
        for (int i = 0; i < arr.length - 1; i++) {
            double temp = (double) arr[i];
            timeTaken += Math.ceil((temp / temp2));
            if (timeTaken > max) {
                return false;
            }
        }
        timeTaken += ((double) arr[arr.length - 1]) / temp2;
        return timeTaken <= max;
    }

}

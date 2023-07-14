package arrays;

public class ThresholdAvgSub {

    public static void main(String args[]) {
        int arr[] = { 11, 13, 17, 23, 29, 31, 7, 5, 2, 3 };
        System.out.print(util1(arr, 3, 5));
    }

    public static int util1(int arr[], int k, int avg) {
        int sum = 0;

        // building the first window..
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int currentAvg = sum / k;
        int ans = 0;
        if (currentAvg >= avg) {
            ans++;
        }

        // now sliding the window..
        int start = 0;
        int end = k - 1;
        while (end < arr.length - 1) {
            sum -= arr[start++];
            sum += arr[++end];
            currentAvg = sum / k;
            if (currentAvg >= avg) {
                ans++;
            }
        }
        return ans;
    }

}

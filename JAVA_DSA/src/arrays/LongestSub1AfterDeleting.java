package arrays;

public class LongestSub1AfterDeleting {

    public static void main(String args[]) {
        int arr[] = { 1, 1, 0, 1 };
        System.out.print(util1(arr));
    }

    public static int util1(int arr[]) {
        int i = 0, j = 0;
        int noZeros = 0;
        int ans = 0;
        while (j < arr.length) {
            if (arr[j] == 0) {
                noZeros++;
            }
            if (noZeros > 1) {
                while (true) {
                    if (arr[i] == 0) {
                        noZeros--;
                        i++;
                        break;
                    }
                    i++;
                }
            }
            int windowLength = j - i + 1;
            ans = Math.max(ans, windowLength - 1);
            j++;
        }
        return ans;
    }

}

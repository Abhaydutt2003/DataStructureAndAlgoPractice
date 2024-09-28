package arrays;

public class ContainerWithMostWater {

    public static void main(String args[]) {
        int arr[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.print(util1(arr));
    }

    public static int util1(int[] arr) {
        int i = 0, j = arr.length - 1;
        int ans = 0;
        while (i < j) {
            int length = Math.min(arr[i], arr[j]);
            int width = j - i;
            int currentAns = width * length;
            ans = Math.max(ans, currentAns);
            if (arr[i] > arr[j]) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }

}

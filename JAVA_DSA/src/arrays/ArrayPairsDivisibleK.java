package arrays;

public class ArrayPairsDivisibleK {

    public static boolean canArrange(int[] arr, int k) {
        int freq[] = new int[k+1];
        // count the frequency of each remainder
        for (int i : arr) {
            freq[i % k]++;
        }
        // check
        for (int i = 0; i < ((k + 1) / 2); i++) {
            if (freq[i] != freq[k - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 };
        int k = 5;
        System.out.println(canArrange(arr, k));
    }
}

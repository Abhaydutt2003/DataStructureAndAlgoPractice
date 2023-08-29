package arrays;

public class CountInversions {

    public static void main(String args[]) {
        int arr[] = { 8, 4, 2, 1 };
        System.out.print(mergeSort(arr));
    }

    // inversion is how far or how close the array is from being sorted
    // can use merge sort to find the inversion count

    public static int mergeSort(int arr[]) {
        if (arr.length == 1) {
            return 0;
        }

        int left[] = new int[arr.length / 2];
        int right[] = new int[arr.length - left.length];
        int k = 0;
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[k++];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[k++];
        }
        int leftAns = mergeSort(left);
        int rightAns = mergeSort(right);
        int currentAns = mergeBoth(left, right, arr);
        return currentAns + leftAns + rightAns;
    }

    public static int mergeBoth(int[] left, int[] right, int[] arr) {
        int count = 0, i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                count += (left.length - i);
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return count;
    }

}

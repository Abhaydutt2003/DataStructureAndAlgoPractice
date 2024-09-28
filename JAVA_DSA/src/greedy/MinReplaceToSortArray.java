package greedy;

public class MinReplaceToSortArray {

    public static void main(String args[]) {
        int i = Integer.MAX_VALUE;
        int j = 8;
        long c = (long) (i + j);
        System.out.print(c);
    }

    // ceiling division
    // (arr[i]+arr[i+1]-1)/arr[i+1]

    public static long util1(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        long operatrions = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                continue;
            }
            int splitInto = arr[i] / arr[i + 1];
            if (arr[i] % arr[i + 1] != 0) {
                splitInto++;
            }
            operatrions += (splitInto - 1);
            arr[i] = arr[i] / splitInto;
        }
        return operatrions;
    }

}

package Math;

public class GCD {

    public static void main(String args[]) {
        int arr[] = { 3,5};
        System.out.print(util1(arr));
    }

    public static int util1(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        return find2(max, min);
    }

    public static int find2(int max, int min) {
        if (min == 0) {
            return max;
        }
        return find2(min, max % min);
    }

    public static int find(int max, int min) {
        int gcd = 1;
        int i = 1;
        while (i <= min) {
            if (max % i == 0 && min % i == 0) {
                gcd = i;
            }
            i++;
        }
        return gcd;
    }

}

package Math;

public class NoOfZeroFilledSubarrays {
    public static void main(String args[]) {
        int arr[] = { 0, 0, 0, 2, 0, 0 };
        System.out.println(zeroFilledSubarray(arr));
    }

    public static long zeroFilledSubarray(int[] nums) {
        long consecZeros = 0;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                consecZeros++;
            } else if (consecZeros != 0) {
                long smallAns = 0;
                for (long j = 1; j <= consecZeros; j++) {
                    smallAns += j;
                }
                ans += smallAns;
                consecZeros = 0;
            }
        }
        if (consecZeros != 0) {
            long smallAns = 0;
            for (long j = 1; j <= consecZeros; j++) {
                smallAns += j;
            }
            ans += smallAns;
        }
        return ans;
    }

}

package math;

public class ValidPickupAndDelivery {

    public static void main(String args[]) {
        System.out.print(util1(8));
    }

    static int mod = 1000000007;

    public static long util1(int n) {
        if (n == 1) {
            return 1;
        }
        long smallAns = util1(n - 1);
        long positions = ((n * 2 - 1) * (n * 2)) / 2;
        return (smallAns * positions) % mod;
    }

    /*
     * for the ith pickup we have exact (2*i-1) positions
     * for the ith delivery we have exact (2*i) positions
     * in exact half of the combinations, the delivery will be before than the
     * pickup, that is why divide by 2
     */
}

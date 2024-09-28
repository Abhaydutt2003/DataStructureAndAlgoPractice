package math;

public class ReverseInteger {

    public static void main(String args[]) {
        System.out.print(util1(1534236469));
    }

    public static int util1(int x) {
        if (x > 0) {
            int len = (int) Math.log10(x) + 1;
            return positiveReverse(x, len);
        } else {
            x *= -1;
            int len = (int) Math.log10(x) + 1;
            int ans = positiveReverse(x, len);
            if (ans == 0) {
                return ans;
            }
            ans *= -1;
            return ans;
        }
    }

    public static int positiveReverse(int x, int len) {
        int ans = 0;
        int placeValue = 1;
        len--;
        while (len >= 0) {
            int toThePower = (int) Math.pow(10, len);
            int firstDigit = x / toThePower;
            int toAdd = firstDigit * placeValue;

            if (toAdd < ans && firstDigit != 0) {
                return 0;
            }

            ans += toAdd;

            if (ans < 0) {
                return 0;
            }

            len--;
            x = x % toThePower;
            placeValue = placeValue * 10;
        }
        return ans;
    }

}

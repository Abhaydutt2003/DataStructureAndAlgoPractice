package strings;

public class StringToInteger {
    public static void main(String[] args) {
        String toCon = "-91283472332";
        System.out.print(util2(toCon));
    }

    public static int util2(String str) {
        // ignore leading whitespaces
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        boolean pos = true;
        if (i == str.length()) {
            return 0;
        }
        // check the number is pos or neg
        if (str.charAt(i) == '-') {
            i++;
            pos = false;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        long ans = 0;
        // set the ranges
        long left = (long) Math.pow(2, 31);
        long right = ((long) Math.pow(2, 31)) - 1;
        while (i < str.length()) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            ans = (ans * 10) + (str.charAt(i) - 48);
            // check overflow
            if (pos) {
                if (ans >= right) {
                    return (int)right;
                }
            } else {
                if (ans >= left) {
                    return (int)left * -1;
                }
            }
            i++;
        }
        if (pos) {
            return (int) ans;
        } else {
            return (int) ans * -1;
        }
    }

    // frustuating and time waste
    public static int util1(String str) {
        // leading whitespaces and 0 are ignored
        int i = 0;
        while (str.charAt(i) == ' ' || str.charAt(i) == '0') {
            i++;
        }
        if (i >= str.length()) {
            return 0;
        } else if (str.charAt(i) == '-') {
            return (int) helper(str.substring(i + 1), 0) * -1;
        } else {
            return (int) helper(str.substring(i), 0);
        }
    }

    public static long helper(String str, int index) {
        if (index == str.length()) {
            return 0;
        }
        char current = str.charAt(index);
        if ((int) current >= 65 && (int) current <= 90) {
            // System.out.print("Aloo1");
            return 0;
        } else if ((int) current >= 97 && (int) current <= 122) {
            // System.out.print("Aloo2");
            return 0;
        } else if (current == ' ') {
            // System.out.print("Aloo3");
            return 0;
        }
        long smallAns = helper(str, index + 1);
        int smallSize;
        if (smallAns == 0) {
            smallSize = 1;
        } else {
            smallSize = (int) (Math.log10(smallAns) + 1);
        }
        long currentNumber = (int) current - 48;
        long a = ((long) Math.pow(10, smallSize)) * currentNumber;
        long b = a + smallAns;
        // System.out.println(smallAns + " " + smallSize + " " + currentNumber + " " + a
        // + " " + b);
        if (b >= (long) Integer.MAX_VALUE) {
            return (long) Integer.MAX_VALUE;
        } else {
            return b;
        }
    }

}

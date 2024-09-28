package strings;

public class DecodeStringAtIndex {

    public static void main(String[] args) {
        System.out.println(util2("a2", 1));
    }

    // very smart math code

    public static String util2(String str, int k) {
        long length = 0;
        // calculate the length of the String after decode
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int digit = str.charAt(i) - '0';
                length *= digit;
            } else {
                length++;
            }
        }
        // now start to encode again
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch) == true) {
                length /= (ch - '0');
                k %= length;
            } else {
                if (k == 0 || length == k) {// k == 0 for the case when the String length is divisible by k
                    return String.valueOf(ch);
                }
                length--;
            }
        }
        // just for the sake of it
        return "";
    }

    // big mess
    public static String util1(String str, int index) {
        if (index == 0) {
            return str.charAt(index) + "";
        }
        return helper(str, index, 0, 0) + "";
    }

    public static char helper(String str, int k, int i, int rangeStart) {
        if (i == str.length()) {
            // just for the sake of it
            return ' ';
        }
        // calculating the range of current String
        String current = "";
        int e = 0;
        while (i < str.length()) {
            int curr = (int) str.charAt(i);
            if (curr >= 48 && curr <= 57) {
                // start of the numbers
                int j = i;
                while (j < str.length() && ((int) str.charAt(j)) <= 57) {
                    e += (((int) str.charAt(j)) - 48);
                    j++;
                }
                i = j;
                break;
            } else {
                current += str.charAt(i);
            }
            i++;
        }
        int rangeRight = rangeStart + (current.length() * e);
        if (k <= rangeRight && k >= rangeStart) {
            // ans lies between
            int index = k / current.length();
            return current.charAt(index);
        } else {
            // ans lies ahead
            return helper(str, k, i, rangeRight);
        }
    }
}

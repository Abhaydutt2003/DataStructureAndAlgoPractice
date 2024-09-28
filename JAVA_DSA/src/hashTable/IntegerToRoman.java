package hashTable;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(util1(1994));
    }

    public static String util1(int n) {
        if (n == 0) {
            return "";
        } else if (n >= 1000) {
            return "M" + util1(n - 1000);
        } else if (n >= 900) {
            return "CM" + util1(n - 900);
        } else if (n >= 500) {
            return "D" + util1(n - 500);
        } else if (n >= 400) {
            return "CD" + util1(n - 400);
        } else if (n >= 100) {
            return "C" + util1(n - 100);
        } else if (n >= 90) {
            return "XC" + util1(n - 90);
        } else if (n >= 50) {
            return "L" + util1(n - 50);
        } else if (n >= 40) {
            return "XL" + util1(n - 40);
        } else if (n >= 10) {
            return "X" + util1(n - 10);
        } else if (n >= 9) {
            return "IX" + util1(n - 9);
        } else if (n >= 5) {
            return "V" + util1(n - 5);
        } else if (n >= 4) {
            return "IV" + util1(n - 4);
        } else {
            return "I" + util1(n - 1);
        }
    }

}

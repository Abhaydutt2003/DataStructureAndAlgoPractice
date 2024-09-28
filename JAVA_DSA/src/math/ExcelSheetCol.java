package math;

public class ExcelSheetCol {

    public static void main(String args[]) {
        // System.out.print(29%26);
        System.out.print(34%26);
    }

    //basically this is a base 26 number system
    //because here A starts from 1, so we do n--

    public static String util1(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            char ch = (char) ((n % 26) + 'A');
            sb.append(ch);
            n /= 26;
        }
        return sb.reverse().toString();
    }

}

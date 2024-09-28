package strings;

public class ReverseString3 {

    public static void main(String[] args) {

    }

    public static String util1(String str) {
        String arr[] = str.split(" ");
        StringBuffer ans = new StringBuffer();
        for (String s : arr) {
            for (int i = s.length() - 1; i >= 0; i--) {
                ans.append(s.charAt(i));
            }
            ans.append(" ");
        }
        return ans.substring(0, ans.length() - 1);
    }

}

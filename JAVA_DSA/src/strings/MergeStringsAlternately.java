package strings;

public class MergeStringsAlternately {

    public static void main(String args[]) {
        String s1 = "abc";
        String s2 = "pqr";
        System.out.println(util1(s1, s2));
    }

    public static String util1(String s1, String s2) {
        int i = 0, j = 0;
        String ans = new String();
        int alt = 0;// if alt 0 put string 1, vice versa
        while (i < s1.length() && j < s2.length()) {
            if (alt == 0) {
                ans = ans + s1.charAt(i++);
                alt = 1;
            } else {
                ans = ans + s2.charAt(j++);
                alt = 0;
            }
        }
        while (i < s1.length()) {
            ans = ans + s1.charAt(i++);
        }
        while (j < s2.length()) {
            ans = ans + s2.charAt(j++);
        }
        return ans;
    }

}

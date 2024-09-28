package greedy;

public class ValidPalindrome2 {

    public static void main(String args[]) {

    }

    // recursion
    public static boolean util1(String str) {
        int i = 0, j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return func(str, i + 1, j) || func(str, i, j - 1);
            }
        }
        return true;
    }

    public static boolean func(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // failed, but makes no sense
    public static boolean util2(String str) {
        int start = 0, end = str.length() - 1;
        boolean canDelete = true;
        while (start < end) {
            if (str.charAt(end) == str.charAt(start)) {
                start++;
                end--;
            } else {
                if (canDelete) {
                    if (str.charAt(start + 1) == str.charAt(end)) {
                        start++;
                        canDelete = false;
                    } else if (str.charAt(start) == str.charAt(end - 1)) {
                        end--;
                        canDelete = false;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}

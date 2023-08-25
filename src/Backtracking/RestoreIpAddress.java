package backTracking;

import java.util.*;

public class RestoreIpAddress {

    public static void main(String args[]) {
        String s = "25525511135";
        List<String> a = util1(s);
        for (String str : a) {
            System.out.println(str);
        }
    }

    public static List<String> util1(String str) {
        ans = new ArrayList<>();
        helper(str, 0, "", 0);
        return ans;
    }

    static List<String> ans;

    public static void helper(String str, int index, String tillNow, int numDigits) {
        if (index == str.length()) {
            if (numDigits == 4) {
                String toAdd = new String(tillNow.substring(0, tillNow.length() - 1));
                ans.add(toAdd);
            }
            return;
        } else if (numDigits >= 4) {
            return;
        } else if (str.charAt(index) == '0') {
            String toAdd = "0.";
            String toSend = new String(tillNow);
            toSend += toAdd;
            helper(str, index + 1, toSend, numDigits + 1);
            return;
        } else {
            int length = 0;
            for (int i = index; i < str.length() && length <= 3; i++) {
                length++;
                if (length <= 2 || isValid(str.substring(index, i + 1))) {
                    String toAdd = str.substring(index, i + 1) + ".";
                    String toSend = new String(tillNow);
                    toSend += toAdd;
                    helper(str, i + 1, toSend, numDigits + 1);
                }
            }
        }
    }

    public static boolean isValid(String str) {
        if (Integer.parseInt(str) <= 255) {
            return true;
        } else {
            return false;
        }
    }

}

package strings;

public class RemoveColouredPieces {

    public static void main(String[] args) {
        String str = "ABBBBBBBAAA";
        System.out.println(util1(str));
    }

    // using pattern matching
    public static boolean util1(String colors) {
        if (colors.length() < 3) {
            return false;
        }
        int patternA = rabinKarp(colors, "AAA");
        int patternB = rabinKarp(colors, "BBB");
        if (patternA > patternB) {
            return true;
        } else {
            return false;
        }
    }

    // rabin karp
    // base 33 number system with mod 101
    public static int rabinKarp(String text, String pattern) {
        int hashPattern = 0;
        int hashText = 0;
        int patternLength = pattern.length();
        int textLength = text.length();
        // calculate power once
        int power = 1;
        for (int i = 0; i < patternLength - 1; i++) {
            power = (33 * power) % 101;
        }
        // now calculate the power of pattern and text;
        for (int i = 0; i < patternLength; i++) {
            hashPattern = (33 * hashPattern + pattern.charAt(i)) % 101;
            hashText = (33 * hashText + text.charAt(i)) % 101;
        }
        // now slide the window
        int ans = 0;
        for (int i = 0; i <= textLength - patternLength; i++) {
            if (hashPattern == hashText) {
                // possible answer
                int j = 0;
                for (j = 0; j < patternLength; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == patternLength) {
                    ans++;
                }
            }
            if (i < textLength - patternLength) {
                hashText = (33 * (hashText - (text.charAt(i) * power)) + text.charAt(i + patternLength)) % 101;
                if (hashText < 0) {
                    hashText += 101;
                }
            }
        }
        return ans;
    }

}

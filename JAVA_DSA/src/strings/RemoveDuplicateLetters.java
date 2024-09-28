package strings;

import java.util.*;

public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        // String str = "abcdefg";
        // StringBuffer s = new StringBuffer(str);
        // System.out.println(str.substring(0, 2));
        // String str = "abc";
        // String str2 = "abc";
        // System.out.println("acb".compareTo("bac"));
        System.out.println(util3("cbacdcbc"));
    }

    //the stack will keep the characters in a sorted way
    //if the previous is bigger, pop
    //but pop only if we know we see this character in future
    //for that we keep a hashMap

    // hate stacks
    public static String util3(String str) {
        HashMap<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            last.put((int) str.charAt(i), i);
        }
        HashSet<Integer> hs = new HashSet<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            int current = (int) str.charAt(i);
            if (hs.contains(current)) {
                continue;
            }
            while (s.isEmpty() == false && s.peek() > current && last.get(s.peek()) > i) {
                hs.remove(s.pop());
            }
            s.push(current);
            hs.add(current);
        }
        StringBuilder sb = new StringBuilder();
        while (s.isEmpty() == false) {
            int current = s.pop();
            char ch = (char) current;
            sb.append(ch);
        }
        return sb.reverse().toString();
    }

    public static String util2(String str) {
        char[] arr = new char[str.length()];
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (hm.containsKey(str.charAt(i))) {
                int j = i - 1;
                while (arr[j] == '#') {
                    j--;
                }
                if (((int) arr[j]) < ((int) str.charAt(i))) {
                    int index = hm.get(str.charAt(i));
                    arr[index] = '#';
                    arr[i] = str.charAt(i);
                } else {
                    arr[i] = '#';
                }
            } else {
                arr[i] = str.charAt(i);
                hm.put(str.charAt(i), i);
            }
        }
        String ans = "";
        for (char ch : arr) {
            if (ch != '#') {
                ans += ch;
            }
        }
        return ans;
    }

    // sort of bfs
    public static String util1(String str) {
        StringBuffer formed = new StringBuffer();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (hm.containsKey(str.charAt(i))) {
                int index = hm.get(str.charAt(i));
                String sb = formed.substring(0, index) + formed.substring(index + 1) + str.charAt(i);
                System.out.println(index + " " + formed + " " + sb);
                if (sb.compareTo(formed.toString()) <= 0) {
                    // need to make change
                    hm.put(str.charAt(i), i);
                    formed = new StringBuffer(sb);
                } else {
                    // no need to make change
                }
            } else {
                hm.put(str.charAt(i), i);
                formed.append(str.charAt(i));
            }
        }
        return formed.toString();
    }
}

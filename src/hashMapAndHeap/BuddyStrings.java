package hashMapAndHeap;

import java.util.*;

public class BuddyStrings {

    public static void main(String args[]) {
        String str = "abac";
        String goal = "abad";
        System.out.print(util2(str, goal));
    }

    public static boolean util2(String str, String goal) {
        if (str.equals(goal)) {
            HashSet<Character> hs = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                if (hs.contains(str.charAt(i))) {
                    return true;
                } else {
                    hs.add(str.charAt(i));
                }
            }
            return false;
        }
        if (str.length() != goal.length()) {
            return false;
        }

        int indexOfDiff1 = -1;
        int indexOfDiff2 = -1;
        int totalDiff = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != goal.charAt(i)) {
                totalDiff++;
                if (totalDiff > 2) {
                    return false;
                } else if (indexOfDiff1 == -1) {
                    indexOfDiff1 = i;
                } else {
                    indexOfDiff2 = i;
                }
            }
        }

        if(totalDiff <2){
            return false;
        }else if ((str.charAt(indexOfDiff1) == goal.charAt(indexOfDiff2))
                && (str.charAt(indexOfDiff2) == goal.charAt(indexOfDiff1))) {
            return true;
        } else {
            return false;
        }
    }

}

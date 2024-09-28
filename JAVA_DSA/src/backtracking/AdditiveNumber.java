package backtracking;

import java.util.*;

public class AdditiveNumber {

    public static void main(String args[]) {
        String str = "1023";
        System.out.print(util1(str));
    }

    public static boolean util1(String nums) {
        // convert String to int array
        int arr[] = new int[nums.length()];
        for (int i = 0; i < nums.length(); i++) {
            int number = nums.charAt(i) - 48;
            arr[i] = number;
        }
        // call helper function
        return helper(arr, 0, new ArrayList<>());
    }

    public static boolean helper(int arr[], int index, List<Long> l) {
        // base conditions
        if (index >= arr.length) {
            if (l.size() == 1 || l.size() == 2) {
                return false;
            }
            return true;
        }
        if (arr[index] == 0) {// handle case where the start is with 0
            if ((l.size() == 0 || l.size() == 1)) {
                l.add(0l);
                boolean smallAns = helper(arr, index + 1, l);
                if (smallAns) {
                    return true;
                } else {
                    l.remove(l.size() - 1);
                    return false;
                }
            } else {
                long toGet = l.get(l.size() - 1) + l.get(l.size() - 2);
                if (toGet == 0) {
                    l.add(0l);
                    boolean smallAns = helper(arr, index + 1, l);
                    if (smallAns) {
                        return true;
                    } else {
                        l.remove(l.size() - 1);
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } else if (l.size() == 0 || l.size() == 1) { // if we are the starting 2 indices
            long prev = 0;
            for (int i = index; i < arr.length; i++) {
                prev = prev * 10 + arr[i];
                l.add(prev);
                boolean smallAns = helper(arr, i + 1, l);
                if (smallAns) {
                    return true;
                }
                l.remove(l.size() - 1);
            }
            return false;
        } else {// need to make a digit from the prev 2 digits
            long toGet = l.get(l.size() - 1) + l.get(l.size() - 2);
            long digit = 0;
            for (int i = index; i < arr.length; i++) {
                digit = digit * 10 + arr[i];
                if (digit == toGet) {
                    l.add(digit);
                    boolean smallAns = helper(arr, i + 1, l);
                    if (smallAns) {
                        return true;
                    } else {
                        l.remove(l.size() - 1);
                        return false;
                    }
                } else if (digit > toGet) {
                    return false;
                }
            }
            return false;
        }
    }

}

package StackAndQueues;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String args[]) {
        int arr[] = { -2, -1, 1, 2 };
        int ans[] = util2(arr);
        for (int i : ans) {
            System.out.println(i + " ");
        }
    }

    // failed approah , minus moving in left, positive moving in right..
    public static int[] util1(int[] arr) {
        Stack<Integer> s = new Stack<Integer>();
        s.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int currentSize = Math.abs(arr[i]);
            int currentDirection = getDirection(arr[i]);
            if (getDirection(s.peek()) != currentDirection) {
                boolean willPut = true;
                while (s.isEmpty() == false && getDirection(s.peek()) != currentDirection) {
                    if (Math.abs(s.peek()) > currentSize) {
                        willPut = false;
                        break;
                    } else if (Math.abs(s.peek()) == currentSize) {
                        s.pop();
                        willPut = false;
                        break;
                    }
                    s.pop();
                }
                if (willPut) {
                    s.push(arr[i]);
                }
            } else {
                s.push(arr[i]);
            }
        }
        int ans[] = new int[s.size()];
        int k = ans.length - 1;
        while (s.isEmpty() == false) {
            ans[k--] = s.pop();
        }
        return ans;
    }

    private static int getDirection(int i) {
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int[] util2(int arr[]) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if ((current < 0) && (s.isEmpty() == false) && (s.peek() > 0)) {
                boolean willPut = true;
                int toPut = current;
                while ((s.isEmpty() == false)) {
                    if (s.peek() < 0) {
                        break;
                    } else if (Math.abs(s.peek()) < Math.abs(toPut)) {
                        s.pop();
                    } else if (Math.abs(s.peek()) == Math.abs(toPut)) {
                        willPut = false;
                        s.pop();
                        break;
                    } else {
                        willPut = false;
                        break;
                    }
                }
                if (willPut) {
                    s.push(toPut);
                }
            } else {
                s.push(arr[i]);
            }
        }
        int ans[] = new int[s.size()];
        int k = ans.length - 1;
        while (s.isEmpty() == false) {
            ans[k--] = s.pop();
        }
        return ans;
    }

}

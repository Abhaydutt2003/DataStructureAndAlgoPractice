package arrays;

import java.util.*;

public class PushDominoes {

    public static void main(String args[]) {
        System.out.print(util2("RR.L"));
    }

    // simple bfs
    public static String util1(String dom) {
        char visited[] = new char[dom.length()];
        int time[] = new int[dom.length()];
        for (int i = 0; i < visited.length; i++) {
            time[i] = -1;
            if (dom.charAt(i) == 'L') {
                visited[i] = 'L';
            } else if (dom.charAt(i) == 'R') {
                visited[i] = 'R';
            } else {
                visited[i] = '.';
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < dom.length(); i++) {
            if (dom.charAt(i) == 'L') {
                q.add(i);
                visited[i] = 'L';
                time[i] = 0;
            } else if (dom.charAt(i) == 'R') {
                q.add(i);
                visited[i] = 'R';
                time[i] = 0;
            }
        }
        while (q.isEmpty() == false) {
            int current = q.poll();
            if (visited[current] == 'L') {
                if (current - 1 >= 0) {
                    if (time[current - 1] != -1) {
                        if (time[current] + 1 == time[current - 1] && visited[current - 1] == 'R') {
                            visited[current - 1] = '.';
                        }
                    } else {
                        visited[current - 1] = 'L';
                        time[current - 1] = time[current] + 1;
                        q.add(current - 1);
                    }
                }
            } else if (visited[current] == 'R') {
                if (current + 1 < time.length) {
                    if (time[current + 1] != -1) {
                        if (time[current] + 1 == time[current + 1] && visited[current + 1] == 'L') {
                            visited[current + 1] = '.';
                        }
                    } else {
                        visited[current + 1] = 'R';
                        time[current + 1] = time[current] + 1;
                        q.add(current + 1);
                    }
                }
            } else {
                // do nothing
            }

        }
        StringBuffer ans = new StringBuffer();
        for (char ch : visited) {
            ans.append(ch);
        }
        return ans.toString();
    }

    // better simpler solution

    static StringBuilder sb;

    public static String util2(String dom) {
        sb = new StringBuilder();
        int count = 0;
        char prev = 'L';
        for (int i = 0; i < dom.length(); i++) {
            char ch = dom.charAt(i);
            if (ch != '.') {
                if (prev == 'L' && ch == 'L') {
                    add(count, 'L');
                } else if (prev == 'R' && ch == 'R') {
                    add(count, 'R');
                } else if (prev != ch && prev == 'L') {
                    add(count, '.');
                } else {
                    add(count / 2, 'R');
                    if (count % 2 != 0) {
                        sb.append('.');
                    }
                    add(count / 2, 'L');
                }
                prev = ch;
                sb.append(ch);
                count = 0;
            } else {
                count++;
            }
        }
        if (count > 0 && prev == 'R') {
            add(count, 'R');
        }
        return sb.toString();
    }

    public static void add(int count, char ch) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }

}

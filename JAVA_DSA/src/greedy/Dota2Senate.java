package greedy;

import java.util.*;

public class Dota2Senate {

    public static void main(String[] args) {
        System.out.println(util2("RDD"));
    }

    // one queue solution

    public static String util2(String senate) {
        int radiants = 0, dires = 0, bannedR = 0, bannedD = 0;
        Queue<Character> q = new LinkedList<>();
        for (char ch : senate.toCharArray()) {
            if (ch == 'R') {
                radiants++;
            } else {
                dires++;
            }
            q.add(ch);
        }
        for (; (radiants > 0 && dires > 0);) {
            char current = q.poll();
            if (current == 'R') {
                if (bannedR > 0) {
                    bannedR--;
                    radiants--;
                } else {
                    bannedD++;
                    q.add(current);
                }
            } else {
                if (bannedD > 0) {
                    bannedD--;
                    dires--;
                } else {
                    bannedR++;
                    q.add(current);
                }
            }
        }
        return (radiants > 0) ? "Radiant" : "Dire";
    }

    // two queue solution self explanatory
    public static String util1(String senate) {
        Queue<Integer> Radiants = new LinkedList<>();
        Queue<Integer> Dires = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                Radiants.add(i);
            } else {
                Dires.add(i);
            }
        }
        for (; (Radiants.isEmpty() == false) && (Dires.isEmpty() == false);) {
            int posR = Radiants.poll();
            int posD = Dires.poll();
            if (posR < posD) {
                Radiants.add(senate.length() + posR);
            } else {
                Dires.add(senate.length() + posD);
            }
        }
        return (Radiants.isEmpty()) ? "Dire" : "Radiant";
    }

}

package hashTable;

import java.util.*;

public class GroupThePeople {

    public static void main(String args[]) {

    }

    //a very easy basic question

    public static List<List<Integer>> util1(int[] arr) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int gSize = arr[i];
            if (hm.containsKey(gSize)) {
                List<Integer> l = hm.get(gSize);
                if (l.size() == gSize) {
                    ans.add(l);
                    l = new ArrayList<>();
                    l.add(i);
                    hm.put(gSize, l);
                } else {
                    l.add(i);
                }
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                hm.put(gSize, l);
            }
        }
        for (Map.Entry<Integer, List<Integer>> en : hm.entrySet()) {
            ans.add(en.getValue());
        }
        return ans;
    }

}

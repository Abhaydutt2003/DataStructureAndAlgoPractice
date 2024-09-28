package graphs;

import java.util.*;

public class ReconstructItenary {

    public static void main(String args[]) {
        // TreeSet<String> ts = new TreeSet<>();
        // ts.add("KUL");
        // ts.add("NRT");
        // System.out.print(ts.first());
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("KUL");
        pq.add("NRT");
        // pq.add("SFO");
        System.out.print(pq.poll());
    }

    public static List<String> util1(List<List<String>> tickets) {
        HashMap<String, TreeMap<String, Integer>> hm = constGraph(tickets);
        ans = new LinkedList<>();
        dfs(hm, "JFK");
        return ans;
    }

    public static void dfs(HashMap<String, TreeMap<String, Integer>> hm, String start) {
        TreeMap<String, Integer> tm = hm.get(start);
        while (tm.size() != 0) {
            String nextNode = tm.firstKey();
            tm.put(nextNode, tm.get(nextNode) - 1);
            if (tm.get(nextNode) == 0) {
                tm.remove(nextNode);
            }
            dfs(hm, nextNode);
        }
        ans.addFirst(start);
    }

    static LinkedList<String> ans;

    public static HashMap<String, TreeMap<String, Integer>> constGraph(List<List<String>> tickets) {
        HashMap<String, TreeMap<String, Integer>> hm = new HashMap<>();
        for (List<String> ls : tickets) {
            String node1 = ls.get(0);
            String node2 = ls.get(1);
            if (hm.containsKey(node1)) {
                TreeMap<String, Integer> t = hm.get(node1);
                t.put(node2, t.getOrDefault(node2, 0) + 1);
            } else {
                TreeMap<String, Integer> t = new TreeMap<>();
                t.put(node2, 1);
                hm.put(node1, t);
            }

            if (hm.containsKey(node2) == false) {
                hm.put(node2, new TreeMap<>());
            }
        }
        return hm;
    }

}

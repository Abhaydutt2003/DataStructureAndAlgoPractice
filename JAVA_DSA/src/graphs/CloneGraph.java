package graphs;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    public static void main(String args[]) {

    }

    static HashMap<Integer, Node> hm;

    public static Node clone(Node source) {
        hm = new HashMap<>();
        Node clone = dfs(source);
        return clone;
    }

    public static Node dfs(Node source) {
        Node clone = new Node(source.val, new ArrayList<>());
        hm.put(source.val, clone);
        List<Node> currentList = source.neighbors;
        for (Node n : currentList) {
            if (hm.containsKey(n.val)) {
                clone.neighbors.add(hm.get(n.val));
            } else {
                Node nClone = dfs(n);
                clone.neighbors.add(nClone);
            }
        }
        return clone;
    }

    // public static Node dfs(Node source) {
    // visited.add(source.val);
    // ArrayList<Node> newList = new ArrayList<>();
    // List<Node> currentList = source.neighbors;
    // for (Node n : currentList) {
    // if (visited.contains(n.val) == false) {
    // Node nClone = dfs(n);
    // newList.add(nClone);
    // }else{

    // }
    // }
    // Node clone = new Node(source.val, newList);
    // hm.put(source.val,)
    // return clone;
    // }

}

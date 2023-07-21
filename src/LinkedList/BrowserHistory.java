package linkedList;

import java.util.*;

class DLLS {
    String val;
    DLLS next;
    DLLS prev;

    DLLS(String val, DLLS prev) {
        this.val = val;
        this.prev = prev;
    }
}
// class bsUse{
// public static void main(String args[]){
// BrowserHistory b = new BrowserHistory()
// }
// }

// public class BrowserHistory {

// DLLS node;

// public BrowserHistory(String homepage) {
// node = new DLLS(homepage, null);
// }

// public void visit(String url) {
// DLLS nNode = new DLLS(url, node);
// node.next = nNode;
// node = nNode;
// }

// public String back(int steps) {
// while (steps != 0 && node.prev != null) {
// node = node.prev;
// steps--;
// }
// return node.val;
// }

// public String forward(int steps) {
// while (steps != 0 && node.next != null) {
// node = node.next;
// steps--;
// }
// return node.val;
// }
// }

class BrowserHistory {
    int index;
    int end;
    ArrayList<String> al;

    public BrowserHistory(String homepage) {
        index = 0;
        end = 0;
        al = new ArrayList<>();
        al.add(homepage);
    }

    public String forward(int steps) {
        int indexToGet = index + steps;
        if (indexToGet > end) {
            index = end;
        } else {
            index = indexToGet;
        }
        return al.get(index);
    }

    public String back(int steps) {
        int indexToGet = index - steps;
        if (indexToGet < 0) {
            index = 0;
        } else {
            index = indexToGet;
        }
        return al.get(index);
    }

    public void visit(String url) {
        int indexToInsert = index + 1;
        if (indexToInsert >= al.size()) {
            al.add(indexToInsert, url);
        } else {
            al.set(indexToInsert, url);
        }
        end = indexToInsert;
        index = indexToInsert;
    }
}

package Strings;

import java.util.*;

// class nodeTrie {
//     nodeTrie next[] = new nodeTrie[26];
//     boolean isLast = false;
//     int index;
// }

public class NamingACompany {

    public static void main(String[] args) {

    }

    /*
     * the first char shoudld always be different
     * then traverse and see the number of suffix which are same
     * reduce the size and calculate the answer accordingly
     */
    public static long util1(String[] words) {
        HashMap<Character, HashSet<String>> hm = new HashMap<>();
        for (String str : words) {
            char ch = str.charAt(0);
            if (hm.containsKey(ch) == false) {
                hm.put(ch, new HashSet<>());
            }
            hm.get(ch).add(str.substring(1));
        }
        long ans = 0;
        for (Map.Entry<Character, HashSet<String>> en : hm.entrySet()) {
            HashSet<String> suffix1 = en.getValue();
            for (Map.Entry<Character, HashSet<String>> en2 : hm.entrySet()) {
                if (en == en2) {
                    continue;
                }
                int common = 0;
                HashSet<String> suffix2 = en2.getValue();
                for (String str : suffix2) {
                    if (suffix1.contains(str)) {
                        common++;
                    }
                }
                int valid1 = suffix1.size() - common;
                int valid2 = suffix2.size() - common;
                ans += (valid1 * valid2);
            }
        }
        return ans;
    }

    // trie try
    // which i gave up on
    // public static long util1(String[] ideas) {
    // // build the trie
    // nodeTrie root = buildTrie(ideas);
    // // start traversing the trie tree for valid answers
    // long ans = traverseTrie(root);
    // return ans;
    // }

    // public static long traverseTrie(nodeTrie root) {
    // long ans = 0;
    // for (int i = 0; i < root.next.length; i++) {
    // if (root.next[i] != null) {
    // for (int j = i + 1; j < root.next.length; j++) {
    // if (root.next[j] != null) {
    // //call function
    // }
    // }
    // }
    // }
    // return ans;
    // }

    // public static long isValid(nodeTrie n1, nodeTrie n2,boolean isDiff){
    // if(n1.index != )
    // if(n1.isLast || n2.isLast){

    // }
    // }

    // public static nodeTrie buildTrie(String[] ideas) {
    // nodeTrie root = new nodeTrie();
    // for (String str : ideas) {
    // nodeTrie current = root;
    // char arr[] = str.toCharArray();
    // for (char ch : arr) {
    // int index = ch - 'a';
    // if (current.next[index] == null) {
    // current.next[index] = new nodeTrie();
    // current.next[index].index = index;
    // }
    // current = current.next[index];
    // }
    // current.isLast = true;
    // }
    // return root;
    // }

}

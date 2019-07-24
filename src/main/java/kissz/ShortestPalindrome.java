package kissz;

import kissz.util.Trie;

import java.util.*;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s.isEmpty()) return "";
        Trie trie = new Trie();
        trie.add(s, Arrays.asList("A"));
        String reverseS = new StringBuilder(s).reverse().toString();
        trie.suffixTree(reverseS, Arrays.asList("B"));

        String maxDepthString = trie.maxDepthString(Arrays.asList("A", "B"));
        if (maxDepthString.isEmpty()) {
            maxDepthString = s.substring(0, 1);
        }
        return new StringBuilder(s.substring(maxDepthString.length())).reverse().toString() + s;
    }
}

package kissz.util;

import kissz.ShortestPalindrome;

import java.util.*;

/**
 * A mutable trie data structure that allows tagging nodes.
 */
public class Trie {

    private final Map<Character, Node> roots = new HashMap<>();

    /** Creates an empty prefix tree. */
    public Trie() {}

    public Trie(String s) { add(s);}

    /** Adds all suffix substrings s to a tree. */
    public void suffixTree(String s) {
        suffixTree(s, Collections.EMPTY_LIST);
    }

    /** Adds all suffix substrings s to a tree. */
    public void suffixTree(String s, Collection<String> tags) {
        for (int i = 0; i < s.length(); i++) {
            add(s.substring(i), tags);
        }
    }

    public void add(String s) {
        add(s, Collections.EMPTY_LIST);
    }

    public void add(String s, Collection<String> tags) {
        // find first missing node.
        Node node = null;
        for (Iterator<Node> iterator = iterator(s); iterator.hasNext();) {
            Node next = iterator.next();
            if (next == null) break;
            node = next;
            for (String tag: tags) {
                node.tag(tag);
            }
        }

        // insert root node if missing.
        if (node == null) {
            node = new Node(s.substring(0, 1), tags);
            roots.put(s.charAt(0), node);
        }
        // insert all missing nodes.
        for (int i = node.value.length(); i < s.length(); i++) {
            final int currentIndex = i;
            node = node.children.computeIfAbsent(s.charAt(i), c -> new Node(s.substring(0, currentIndex + 1), tags));
        }
    }

    public boolean contains(String p) {
        for (Iterator<Node> iterator = iterator(p); iterator.hasNext();) {
            Node node = iterator.next();
            if (node == null) return false;
        }
        return true;
    }

    /**
     * Returns the string of maximum depth that has all the tags.
     */
    public String maxDepthString(Collection<String> tags) {
        // Calculate max depth
        int maxDepth = 0;
        String maxDepthString = "";
        for (Trie.Node root : getRoots().values()) {
            if (root.getTags().containsAll(tags)) {

                Deque<StackElem> dfsStack = new LinkedList<>();
                dfsStack.push(new StackElem(1, root));

                while (!dfsStack.isEmpty()) {
                    StackElem elem = dfsStack.pop();
                    for (Trie.Node child : elem.trieNode.getChildren()) {
                        if (child.getTags().containsAll(tags)) {
                            int depth = elem.depth + 1;
                            if (depth > maxDepth) {
                                maxDepth = depth;
                                maxDepthString = child.getValue();
                            }
                            dfsStack.push(new StackElem(depth, child));
                        }
                    }
                }
            }
        }
        return maxDepthString;
    }

    private static class StackElem {
        final int depth;
        final Trie.Node trieNode;

        public StackElem(int depth, Trie.Node trieNode) {
            this.depth = depth;
            this.trieNode = trieNode;
        }
    }

    public Map<Character, Node> getRoots() {
        return Collections.unmodifiableMap(roots);
    }

    /**
     * An iterator that return hasNext: false when the source string is exhausted. If the trie does not contain the
     * string after the last matching node null values will be returned.
     */
    public Iterator<Node> iterator(String s) {
        return new Iterator<Node>() {
            private int index;
            private Node node;

            @Override
            public boolean hasNext() {
                return index < s.length();
            }

            @Override
            public Node next() {
                if (index == 0) {
                    node = roots.get(s.charAt(index));
                } else {
                    node = node.children.get(s.charAt(index));
                }
                ++index;
                return node;
            }
        };
    }

    public static class Node {
        private final Set<String> tags;
        private final String value;
        private final Map<Character, Node> children;

        public Node(String value, Collection<String> tags) {
            this.value = value;
            this.tags = new HashSet<>(tags);
            this.children = new HashMap<>();
        }

        public Node(String value, String... tags) {
            this.value = value;
            this.tags = new HashSet<>(Arrays.asList(tags));
            this.children = new HashMap<>();
        }

        public Iterable<Node> getChildren() {
            return Collections.unmodifiableCollection(children.values());
        }

        public Set<String> getTags() {
            return Collections.unmodifiableSet(tags);
        }

        public String getValue() {
            return value;
        }

        public void tag(String tag) {
            tags.add(tag);
        }

        private void addChild(Node child) {
            this.children.put(child.value.charAt(0), child);
        }
    }
}

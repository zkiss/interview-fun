package kissz;

import java.util.*;

/**
 * A mutable trie data structure that allows tagging nodes.
 */
public class Trie {

    private final Map<Character, Node> roots = new HashMap<>();

    /** Creates an empty prefix tree. */
    public Trie() {}

    public Trie(String s) { add(s);}

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

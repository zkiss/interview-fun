package kissz.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void testIterator() {
        Trie trie = new Trie("irgumburgum");
        trie.add("irrationality");
        List<Trie.Node> results = new ArrayList<>();
        for (Iterator<Trie.Node> nodeIterator = trie.iterator("irgum"); nodeIterator.hasNext();) {
            results.add(nodeIterator.next());
        }
        List<String> values = results.stream().map(Trie.Node::getValue).collect(Collectors.toList());
        assertEquals(Arrays.asList("i", "ir", "irg", "irgu", "irgum"), values);

        List<Trie.Node> results2 = new ArrayList<>();
        for (Iterator<Trie.Node> nodeIterator = trie.iterator("irre"); nodeIterator.hasNext();) {
            results2.add(nodeIterator.next());
        }
        assertEquals(3, results2.stream().filter(r -> r != null).count());

        assertEquals(Arrays.asList("i", "ir", "irr"),
                results2.stream().filter(r -> r != null).map(Trie.Node::getValue).collect(Collectors.toList()));
    }

    @Test
    public void testContains() {
        Trie trie = new Trie("compellable");
        assertTrue(trie.contains("compel"));
        assertFalse(trie.contains("giraffe"));
    }
}
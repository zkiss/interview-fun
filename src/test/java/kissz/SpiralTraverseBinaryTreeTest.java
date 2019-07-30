package kissz;

import kissz.SpiralTraverseBinaryTree.Node;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SpiralTraverseBinaryTreeTest {

    private SpiralTraverseBinaryTree s = new SpiralTraverseBinaryTree();

    @Test
    public void test() {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        assertEquals(Arrays.asList(0, 5, 4, 3, 1, 2), s.spiral(root));
    }

}
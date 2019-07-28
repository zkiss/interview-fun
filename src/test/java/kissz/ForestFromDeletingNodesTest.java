package kissz;

import kissz.ForestFromDeletingNodes.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ForestFromDeletingNodesTest {

    ForestFromDeletingNodes underTest = new ForestFromDeletingNodes();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        assertEquals(2, underTest.delNodes(root, new int[] {2, 3}).size());
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        assertTrue(root.left != null);
        assertEquals(3, underTest.delNodes(root, new int[] {2, 3}).size());
    }
}
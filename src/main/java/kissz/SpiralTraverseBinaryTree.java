package kissz;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SpiralTraverseBinaryTree {
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int x) {
            val = x;
        }
    }

    public List<Integer> spiral(Node root) {
        LinkedList<List<Integer>> levels = buildLevels(root);

        LinkedList<Integer> res = new LinkedList<>();
        while (!levels.isEmpty()) {
            res.addAll(levels.removeFirst());
            if (!levels.isEmpty()) {
                Collections.reverse(levels.getLast());
                res.addAll(levels.removeLast());
            }
        }
        return res;
    }

    private LinkedList<List<Integer>> buildLevels(Node root) {
        if (root == null) return new LinkedList<>();
        LinkedList<List<Integer>> levels = new LinkedList<>();

        LinkedList<Node> q = new LinkedList<>();
        LinkedList<Integer> currentLevel = new LinkedList<>();
        q.push(root);

        while (!q.isEmpty()) {
            int levelNodes = q.size();
            currentLevel = new LinkedList<>();
            while (levelNodes > 0) {
                Node node = q.pop();
                currentLevel.add(node.val);
                if (node.left != null) q.addLast(node.left);
                if (node.right != null) q.addLast(node.right);
                levelNodes--;
            }
            levels.add(currentLevel);
        }

        return levels;
    }

}


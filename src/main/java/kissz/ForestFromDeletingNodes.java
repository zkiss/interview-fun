package kissz;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForestFromDeletingNodes {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = IntStream.of(to_delete).boxed().collect(Collectors.toSet());
        List<TreeNode> ret = new ArrayList<>();
        Deque<TreeNode> f = new LinkedList<>();
        f.add(root);
        if (!toDeleteSet.contains(root.val)) {
            ret.add(root);
        }

        while (!f.isEmpty()) {
            TreeNode node = f.pop();
            if (node.left != null) {
                f.push(node.left);
                if (toDeleteSet.contains(node.val) && !toDeleteSet.contains(node.left.val)) {
                    ret.add(node.left);
                } else if (toDeleteSet.contains(node.left.val)) {
                    node.left = null;
                }
            }
            if (node.right != null) {
                f.push(node.right);
                if (toDeleteSet.contains(node.val) && !toDeleteSet.contains(node.right.val)) {
                    ret.add(node.right);
                } else if (toDeleteSet.contains(node.right.val)) {
                    node.right = null;
                }
            }
        }

        return ret;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
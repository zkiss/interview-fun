package kissz;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeCodec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        printTree(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "null") return null;
        int val = Integer.valueOf(data.substring(1, data.indexOf(' ')));

        return readTree(null);
    }

    private TreeNode readTree(TreeNode t) {
        return null;
    }

    private String printTree(TreeNode t, StringBuilder sb) {
        if (t == null) {
            sb.append("null");
        } else {
            sb.append('(');
            sb.append(t.val);
            sb.append(' ');
            printTree(t.left, sb);
            sb.append(' ');
            printTree(t.right, sb);
            sb.append(')');
        }
        return null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TreeNode) {
            TreeNode other = (TreeNode) obj;
            if (this == other) return true;
            if (val != other.val) return false;
            if (left == null && other.left != null || left != null && other.left != null) return false;
            if (right == null && other.right != null || right != null && other.right != null) return false;
            if (left != null) if (!left.equals(other.left)) return false;
            if (right != null) if (!right.equals(other.right)) return false;
        }
        return false;
    }
}
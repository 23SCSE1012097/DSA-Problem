import java.util.*;

class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> childValues = new HashSet<>();

        for (TreeNode root : trees) {
            map.put(root.val, root);

            if (root.left != null) {
                childValues.add(root.left.val);
            }

            if (root.right != null) {
                childValues.add(root.right.val);
            }
        }

        TreeNode root = null;

        for (TreeNode node : trees) {
            if (!childValues.contains(node.val)) {
                if (root != null) {
                    return null;
                }
                root = node;
            }
        }

        if (root == null) {
            return null;
        }

        map.remove(root.val);

        if (!validate(root, Long.MIN_VALUE, Long.MAX_VALUE, map)) {
            return null;
        }

        return map.isEmpty() ? root : null;
    }

    private boolean validate(TreeNode node, long min, long max,
                             Map<Integer, TreeNode> map) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        if (node.left == null && node.right == null) {
            TreeNode merge = map.remove(node.val);

            if (merge != null) {
                node.left = merge.left;
                node.right = merge.right;
            }
        }

        return validate(node.left, min, node.val, map)
            && validate(node.right, node.val, max, map);
    }
}
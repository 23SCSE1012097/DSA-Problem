class Solution {

    long totalSum = 0;
    long maxProduct = 0;
    final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        // Step 1: find total sum of tree
        totalSum = getTotalSum(root);

        // Step 2: find maximum product by splitting
        findMaxProduct(root);

        return (int)(maxProduct % MOD);
    }

    // First DFS to calculate total sum
    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    // Second DFS to calculate subtree sums and product
    private long findMaxProduct(TreeNode node) {
        if (node == null) return 0;

        long leftSum = findMaxProduct(node.left);
        long rightSum = findMaxProduct(node.right);

        long subtreeSum = node.val + leftSum + rightSum;

        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}

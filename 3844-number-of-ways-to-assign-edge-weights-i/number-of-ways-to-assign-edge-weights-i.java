import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    private long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(new int[]{1, 0}); // {node, depth}
        visited[1] = true;

        int maxDepth = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int depth = current[1];

            maxDepth = Math.max(maxDepth, depth);

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, depth + 1});
                }
            }
        }

        return (int) modPow(2, maxDepth - 1);
    }
}
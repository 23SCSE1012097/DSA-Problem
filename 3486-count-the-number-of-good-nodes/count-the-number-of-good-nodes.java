import java.util.*;

class Solution {
    int ans = 0;
    
    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        dfs(0, -1, graph);
        
        return ans;
    }
    
    private int dfs(int node, int parent, List<List<Integer>> graph) {
        int subtreeSize = 1;
        int firstChildSize = -1;
        boolean good = true;
        
        for (int child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            
            int childSize = dfs(child, node, graph);
            
            if (firstChildSize == -1) {
                firstChildSize = childSize;
            } else if (firstChildSize != childSize) {
                good = false;
            }
            
            subtreeSize += childSize;
        }
        
        if (good) {
            ans++;
        }
        
        return subtreeSize;
    }
}
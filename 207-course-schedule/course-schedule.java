import java.util.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

       
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

    
        for (int[] arr : prerequisites) {
            adj.get(arr[1]).add(arr[0]);
        }

      
        int[] visited = new int[numCourses];
        int[] inStack = new int[numCourses];

       
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, adj, visited, inStack)) {
                return false; 
            }
        }

        return true; 
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                        int[] visited, int[] inStack) {

        if (inStack[node] == 1) return true;   
        if (visited[node] == 1) return false;  

        visited[node] = 1;
        inStack[node] = 1;

        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor, adj, visited, inStack)) {
                return true;
            }
        }

        inStack[node] = 0;  
        return false;
    }
}

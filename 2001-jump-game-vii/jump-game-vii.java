import java.util.*;

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.add(0);
        visited[0] = true;

        int far = 0;

        while (!q.isEmpty()) {
            int index = q.poll();

            if (index == n - 1) {
                return true;
            }

            int start = Math.max(far + 1, index + minJump);
            int end = Math.min(n - 1, index + maxJump);

            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '0' && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }

            far = Math.max(far, end);
        }

        return false;
    }
}
import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(1);
        visited[1] = true;
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                if (curr == n * n) return moves;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) break;

                    int[] pos = getPosition(next, n);
                    int r = pos[0], c = pos[1];

                    if (board[r][c] != -1)
                        next = board[r][c];

                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private int[] getPosition(int cell, int n) {
        int idx = cell - 1;
        int row = n - 1 - idx / n;
        int col = idx % n;
        if ((n - 1 - row) % 2 == 1)
            col = n - 1 - col;
        return new int[]{row, col};
    }
}

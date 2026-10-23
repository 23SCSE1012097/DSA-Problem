
class Solution {
    int[] height;
    int best;
    int n, m;

    public int tilingRectangle(int n, int m) {
        if (n == m) {
            return 1;
        }

        this.n = n;
        this.m = m;
        height = new int[m];
        best = n * m;

        dfs(0);

        return best;
    }

    private void dfs(int count) {
        if (count >= best) {
            return;
        }

        int minHeight = Integer.MAX_VALUE;
        int pos = -1;

        for (int i = 0; i < m; i++) {
            if (height[i] < minHeight) {
                minHeight = height[i];
                pos = i;
            }
        }

        if (minHeight == n) {
            best = count;
            return;
        }

        int end = pos;

        while (end < m && height[end] == minHeight) {
            end++;
        }

        int maxSize = Math.min(end - pos, n - minHeight);

        for (int size = maxSize; size >= 1; size--) {
            for (int i = pos; i < pos + size; i++) {
                height[i] += size;
            }

            dfs(count + 1);

            for (int i = pos; i < pos + size; i++) {
                height[i] -= size;
            }
        }
    }
}

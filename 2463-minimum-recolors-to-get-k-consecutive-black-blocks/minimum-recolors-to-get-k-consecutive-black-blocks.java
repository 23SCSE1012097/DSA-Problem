class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int white = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') white++;
        }

        int ans = white;

        for (int i = k; i < n; i++) {
            if (blocks.charAt(i - k) == 'W') white--;
            if (blocks.charAt(i) == 'W') white++;

            ans = Math.min(ans, white);
        }

        return ans;
    }
}
class Solution {
    public int lengthLongestPath(String input) {
        String[] parts = input.split("\n");
        int[] len = new int[parts.length + 1];
        int ans = 0;

        for (String s : parts) {
            int level = 0;
            while (level < s.length() && s.charAt(level) == '\t') {
                level++;
            }

            String name = s.substring(level);

            if (name.contains(".")) {
                ans = Math.max(ans, len[level] + name.length());
            } else {
                len[level + 1] = len[level] + name.length() + 1;
            }
        }

        return ans;
    }
}
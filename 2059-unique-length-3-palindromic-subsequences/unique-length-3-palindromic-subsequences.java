class Solution {
    public int countPalindromicSubsequence(String s) {
        int count = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);

            if (first != -1 && last - first >= 2) {
                boolean[] seen = new boolean[26];

                for (int i = first + 1; i < last; i++) {
                    if (!seen[s.charAt(i) - 'a']) {
                        seen[s.charAt(i) - 'a'] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
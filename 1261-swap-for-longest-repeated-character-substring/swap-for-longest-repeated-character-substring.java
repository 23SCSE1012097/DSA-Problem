
class Solution {
    public int maxRepOpt1(String text) {
        int n = text.length();
        int[] freq = new int[26];

        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        int ans = 0;

        for (int i = 0; i < n;) {
            int j = i;

            while (j < n && text.charAt(i) == text.charAt(j)) {
                j++;
            }

            int left = j - i;
            int k = j + 1;

            while (k < n && text.charAt(i) == text.charAt(k)) {
                k++;
            }

            int right = k - j - 1;

            ans = Math.max(ans, Math.min(left + right + 1, freq[text.charAt(i) - 'a']));

            i = j;
        }

        return ans;
    }
}
class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        // If needle is bigger, it can never be found
        if (m > n) return -1;

        // Check every position in haystack where needle can fit
        for (int i = 0; i <= n - m; i++) {

            // Check if haystack substring matches needle
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        // If no match found
        return -1;
    }
}

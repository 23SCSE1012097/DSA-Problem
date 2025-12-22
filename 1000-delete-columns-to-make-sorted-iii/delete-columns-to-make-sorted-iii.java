class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        
        int[] dp = new int[m];
        java.util.Arrays.fill(dp, 1);
        
        int maxKept = 1;
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (isSorted(strs, j, i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxKept = Math.max(maxKept, dp[i]);
        }
        
        return m - maxKept;
    }
    
    private boolean isSorted(String[] strs, int j, int i) {
        for (String s : strs) {
            if (s.charAt(j) > s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
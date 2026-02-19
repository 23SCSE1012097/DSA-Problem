class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        int n = s.length();
        int cnt01 = 0;
        int cnt10 = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0' && t.charAt(i) == '1') cnt01++;
            else if (s.charAt(i) == '1' && t.charAt(i) == '0') cnt10++;
        }

        // We use DP to find the minimum cost to reach the state (cnt01, cnt10)
        // Since we can always resolve a (0,1) and (1,0) together, or two of the same,
        // we can simplify the state to the number of mismatches of each type.
        
        // However, a simple greedy approach with a slight adjustment works:
        // You can convert a (0,1) to (1,0) for 'crossCost'.
        // So we can try all possible number of cross-swaps.
        
        long minTotal = Long.MAX_VALUE;
        
        // Let i be the number of (0,1) we convert to (1,0)
        // OR let i be the number of (1,0) we convert to (0,1)
        // Since we want to balance them to use swapCost, we only need to check
        // a small range around the balance point.
        
        for (int i = -cnt01; i <= cnt10; i++) {
            // i > 0 means we convert i (1,0)s into (0,1)s
            // i < 0 means we convert |i| (0,1)s into (1,0)s
            long new01 = cnt01 + i;
            long new10 = cnt10 - i;
            
            if (new01 < 0 || new10 < 0) continue;
            
            long currentCost = Math.abs((long)i) * crossCost;
            long pairs = Math.min(new01, new10);
            currentCost += pairs * Math.min(2L * flipCost, (long)swapCost);
            
            long remaining = Math.abs(new01 - new10);
            currentCost += (remaining / 2) * Math.min(2L * flipCost, (long)swapCost + 2L * crossCost);
            if (remaining % 2 == 1) currentCost += flipCost;
            
            minTotal = Math.min(minTotal, currentCost);
        }

        return minTotal;
    }
}
class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        int n = s.length();
        int cnt01 = 0;
        int cnt10 = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0' && t.charAt(i) == '1') cnt01++;
            else if (s.charAt(i) == '1' && t.charAt(i) == '0') cnt10++;
        }

        
        
        long minTotal = Long.MAX_VALUE;
        
        
        
        for (int i = -cnt01; i <= cnt10; i++) {
    
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